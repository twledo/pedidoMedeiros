package dev.medeiros.sitePedidos.service.impl;

import dev.medeiros.sitePedidos.model.SizePizza;
import dev.medeiros.sitePedidos.repository.SizePizzaRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SizePizzaServiceImplTest {

    @Mock
    private SizePizzaRepository sizePizzaRepository;

    @InjectMocks
    private SizePizzaServiceImpl sizePizzaService;

    /**
     * Testa se o metodo save retorna a pizza salva corretamente.
     *
     * @see SizePizzaServiceImpl#save(SizePizza)
     */
    @Test
    void saveReturnsSavedPizza() {
        SizePizza pizza = new SizePizza();
        when(sizePizzaRepository.save(pizza)).thenReturn(pizza);
        assertEquals(pizza, sizePizzaService.save(pizza));
    }

    /**
     * Testa se o metodo findAll retorna a lista de pizzas corretamente.
     *
     * @see SizePizzaServiceImpl#findAll()
     */
    @Test
    void findAllReturnsListOfPizzas() {
        List<SizePizza> list = Arrays.asList(new SizePizza(), new SizePizza());
        when(sizePizzaRepository.findAll()).thenReturn(list);
        assertEquals(list, sizePizzaService.findAll());
    }

    /**
     * Testa se o metodo findById retorna a pizza quando ela existe.
     *
     * @see SizePizzaServiceImpl#findById(Long)
     */
    @Test
    void findByIdReturnsPizzaWhenExists() {
        SizePizza pizza = new SizePizza();
        pizza.setId(1L);
        when(sizePizzaRepository.findById(1L)).thenReturn(Optional.of(pizza));
        assertEquals(pizza, sizePizzaService.findById(1L));
    }

    /**
     * Testa se o metodo edit atualiza a pizza corretamente quando ela existe.
     *
     * @see SizePizzaServiceImpl#edit(Long, SizePizza)
     */
    @Test
    void editUpdatesPizzaWhenExists() {
        SizePizza pizza = new SizePizza();
        pizza.setId(1L);
        pizza.setName("Pequena");
        pizza.setPrice(10L);
        pizza.setDescription("desc");

        SizePizza updated = new SizePizza();
        updated.setName("Grande");
        updated.setPrice(20L);
        updated.setDescription("nova desc");

        when(sizePizzaRepository.findById(1L)).thenReturn(Optional.of(pizza));
        when(sizePizzaRepository.save(any(SizePizza.class))).thenReturn(pizza);

        SizePizza result = sizePizzaService.edit(1L, updated);
        Assertions.assertEquals("Grande", result.getName());
        Assertions.assertEquals(20L, result.getPrice());
        Assertions.assertEquals("nova desc", result.getDescription());
    }

    /**
     * Testa se o metodo deleteById remove a pizza corretamente.
     *
     * @see SizePizzaServiceImpl#deleteById(Long)
     */
    @Test
    void deleteByIdRemovesPizza() {
        doNothing().when(sizePizzaRepository).deleteById(1L);
        sizePizzaService.deleteById(1L);
        verify(sizePizzaRepository, times(1)).deleteById(1L);
    }
}