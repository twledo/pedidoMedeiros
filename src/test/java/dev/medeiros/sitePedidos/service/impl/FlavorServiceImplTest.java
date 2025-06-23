package dev.medeiros.sitePedidos.service.impl;

import dev.medeiros.sitePedidos.enums.TypeFlavors;
import dev.medeiros.sitePedidos.model.Flavor;
import dev.medeiros.sitePedidos.repository.FlavorRepository;
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
class FlavorServiceImplTest {

    @Mock
    private FlavorRepository flavorRepository;

    @InjectMocks
    private FlavorServiceImpl flavorService;

    @Test
    void saveReturnsSavedFlavor() {
        Flavor flavor = new Flavor();
        when(flavorRepository.save(flavor)).thenReturn(flavor);
        assertEquals(flavor, flavorService.save(flavor));
    }

    @Test
    void findAllReturnsListOfFlavors() {
        List<Flavor> flavors = List.of(new Flavor(), new Flavor());
        when(flavorRepository.findAll()).thenReturn(flavors);
        assertEquals(flavors, flavorService.findAll());
    }

    @Test
    void findByIdReturnsFlavorWhenExists() {
        Flavor flavor = new Flavor();
        flavor.setId(1L);
        when(flavorRepository.findById(1L)).thenReturn(Optional.of(flavor));
        assertEquals(flavor, flavorService.findById(1L));
    }

    @Test
    void findByIdThrowsExceptionWhenNotFound() {
        when(flavorRepository.findById(99L)).thenReturn(Optional.empty());
        RuntimeException ex = assertThrows(RuntimeException.class, () -> flavorService.findById(99L));
        assertTrue(ex.getMessage().contains("Sabor não encontrado com ID: 99"));
    }

    @Test
    void editUpdatesFlavorWhenExists() {
        Flavor existing = new Flavor();
        existing.setId(1L);
        existing.setName("Original");

        Flavor updated = new Flavor();
        updated.setName("Novo");

        when(flavorRepository.findById(1L)).thenReturn(Optional.of(existing));
        when(flavorRepository.save(existing)).thenReturn(existing);

        Flavor result = flavorService.edit(1L, updated);
        assertEquals("Novo", result.getName());
    }

    @Test
    void deleteByIdRemovesFlavor() {
        doNothing().when(flavorRepository).deleteById(1L);
        flavorService.deleteById(1L);
        verify(flavorRepository).deleteById(1L);
    }

    @Test
    void findByTypeReturnsFlavorsOfGivenType() {
        List<Flavor> flavors = List.of(new Flavor(), new Flavor());
        when(flavorRepository.findByType(TypeFlavors.SALGADO)).thenReturn(flavors);
        assertEquals(flavors, flavorService.findByType(TypeFlavors.SALGADO));
    }
}