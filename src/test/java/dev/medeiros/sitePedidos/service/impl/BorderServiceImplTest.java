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

/**
 * Classe de teste para {@link BorderServiceImpl}.
 * <p>
 * Utiliza Mockito para simular o comportamento do {@link BorderRepository} e testar os metodos do serviço.
 * </p>
 */
@ExtendWith(MockitoExtension.class)
public class BorderServiceImplTest {

    @Mock
    BorderRepository borderRepository;

    @InjectMocks
    BorderServiceImpl borderService;

    /**
     * Testa se o metodo save retorna a borda salva corretamente.
     *
     * @see BorderServiceImpl#save(Border)
     */
    @Test
    void saveReturnsSavedBorder() {
        Border border = new Border();
        when(borderRepository.save(border)).thenReturn(border);
        assertEquals(border, borderService.save(border));
    }

    /**
     * Testa se o metodo findAll retorna a lista de bordas corretamente.
     *
     * @see BorderServiceImpl#findAll()
     */
    @Test
    void findAllReturnsListOfBorders() {
        List<Border> borders = List.of(new Border(), new Border());
        when(borderRepository.findAll()).thenReturn(borders);
        assertEquals(borders, borderService.findAll());
    }

    /**
     * Testa se o metodo findById retorna a borda quando ela existe.
     *
     * @see BorderServiceImpl#findById(Long)
     */
    @Test
    void findByIdReturnsBorderWhenExists() {
        Border border = new Border();
        border.setId(1L);
        when(borderRepository.findById(1L)).thenReturn(java.util.Optional.of(border));
        assertEquals(border, borderService.findById(1L));
    }

    /**
     * Testa se o metodo findById lança exceção quando a borda não é encontrada.
     *
     * @see BorderServiceImpl#findById(Long)
     */
    @Test
    void findByIdThrowsExceptionWhenNotFound() {
        when(borderRepository.findById(99L)).thenReturn(java.util.Optional.empty());
        RuntimeException ex = org.junit.jupiter.api.Assertions.assertThrows(
                RuntimeException.class, () -> borderService.findById(99L));
        org.junit.jupiter.api.Assertions.assertTrue(ex.getMessage().contains("Borda não encontrada com ID: 99"));
    }

    /**
     * Testa se o metodo edit atualiza a borda corretamente quando ela existe.
     *
     * @see BorderServiceImpl#edit(Long, Border)
     */
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

    /**
     * Testa se o metodo deleteById remove a borda corretamente.
     *
     * @see BorderServiceImpl#deleteById(Long)
     */
    @Test
    void deleteByIdRemovesBorder() {
        org.mockito.Mockito.doNothing().when(borderRepository).deleteById(1L);
        borderService.deleteById(1L);
        org.mockito.Mockito.verify(borderRepository).deleteById(1L);
    }
}
