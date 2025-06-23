package dev.medeiros.sitePedidos.service.impl;

import dev.medeiros.sitePedidos.model.Drink;
import dev.medeiros.sitePedidos.repository.DrinkRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DrinkServiceImplTest {

    @Mock
    private DrinkRepository drinkRepository;

    @InjectMocks
    private DrinkServiceImpl drinkService;

    @Test
    void saveReturnsSavedDrink() {
        Drink drink = new Drink();
        when(drinkRepository.save(drink)).thenReturn(drink);
        assertEquals(drink, drinkService.save(drink));
    }

    @Test
    void findAllReturnsListOfDrinks() {
        List<Drink> drinks = List.of(new Drink(), new Drink());
        when(drinkRepository.findAll()).thenReturn(drinks);
        assertEquals(drinks, drinkService.findAll());
    }

    @Test
    void findByIdReturnsDrinkWhenExists() {
        Drink drink = new Drink();
        drink.setId(1L);
        when(drinkRepository.findById(1L)).thenReturn(Optional.of(drink));
        assertEquals(drink, drinkService.findById(1L));
    }

    @Test
    void findByIdThrowsExceptionWhenNotFound() {
        when(drinkRepository.findById(99L)).thenReturn(Optional.empty());
        RuntimeException ex = assertThrows(RuntimeException.class, () -> drinkService.findById(99L));
        assertTrue(ex.getMessage().contains("Bebida não encontrada com ID: 99"));
    }

    @Test
    void editUpdatesDrinkWhenExists() {
        Drink existing = new Drink();
        existing.setId(1L);
        existing.setName("Original");
        existing.setPrice(10L);

        Drink updated = new Drink();
        updated.setName("Nova");
        updated.setPrice(20L);

        when(drinkRepository.findById(1L)).thenReturn(Optional.of(existing));
        when(drinkRepository.save(existing)).thenReturn(existing);

        Drink result = drinkService.edit(1L, updated);
        assertEquals("Nova", result.getName());
        assertEquals(20L, result.getPrice());
    }

    @Test
    void deleteByIdRemovesDrink() {
        doNothing().when(drinkRepository).deleteById(1L);
        drinkService.deleteById(1L);
        verify(drinkRepository).deleteById(1L);
    }
}