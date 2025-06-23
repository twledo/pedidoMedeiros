package dev.medeiros.sitePedidos.service.impl;

import dev.medeiros.sitePedidos.model.Border;
import dev.medeiros.sitePedidos.repository.BorderRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BorderServiceImplTest {

    @Mock
    BorderRepository borderRepository;

    @InjectMocks
    BorderServiceImpl borderService;

    @Test
    void saveReturnsSavedBorder() {
        Border border = new Border();
        when(borderRepository.save(border)).thenReturn(border);
        assertEquals(border, borderService.save(border));
    }

    @Test
    void findAllReturnsListOfBorders() {
        List<Border> borders = List.of(new Border(), new Border());
        when(borderRepository.findAll()).thenReturn(borders);
        assertEquals(borders, borderService.findAll());
    }

    @Test
    void findByIdReturnsBorderWhenExists() {
        Border border = new Border();
        border.setId(1L);
        when(borderRepository.findById(1L)).thenReturn(java.util.Optional.of(border));
        assertEquals(border, borderService.findById(1L));
    }

    @Test
    void findByIdThrowsExceptionWhenNotFound() {
        when(borderRepository.findById(99L)).thenReturn(java.util.Optional.empty());
        RuntimeException ex = org.junit.jupiter.api.Assertions.assertThrows(
                RuntimeException.class, () -> borderService.findById(99L));
        org.junit.jupiter.api.Assertions.assertTrue(ex.getMessage().contains("Borda não encontrada com ID: 99"));
    }

    @Test
    void editUpdatesBorderWhenExists() {
        Border existing = new Border();
        existing.setId(1L);
        existing.setName("Original");
        existing.setPrice(10L);

        Border updated = new Border();
        updated.setName("Nova");
        updated.setPrice(20L);

        when(borderRepository.findById(1L)).thenReturn(java.util.Optional.of(existing));
        when(borderRepository.save(existing)).thenReturn(existing);

        Border result = borderService.edit(1L, updated);
        assertEquals("Nova", result.getName());
        assertEquals(20L, result.getPrice());
    }

    @Test
    void deleteByIdRemovesBorder() {
        org.mockito.Mockito.doNothing().when(borderRepository).deleteById(1L);
        borderService.deleteById(1L);
        org.mockito.Mockito.verify(borderRepository).deleteById(1L);
    }
}
