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

    /**
     * Testa se o metodo save retorna o sabor salvo corretamente.
     *
     * @see FlavorServiceImpl#save(Flavor)
     */
    @Test
    void saveReturnsSavedFlavor() {
        Flavor flavor = new Flavor();
        when(flavorRepository.save(flavor)).thenReturn(flavor);
        assertEquals(flavor, flavorService.save(flavor));
    }

    /**
     * Testa se o metodo findAll retorna a lista de sabores corretamente.
     *
     * @see FlavorServiceImpl#findAll()
     */
    @Test
    void findAllReturnsListOfFlavors() {
        List<Flavor> flavors = List.of(new Flavor(), new Flavor());
        when(flavorRepository.findAll()).thenReturn(flavors);
        assertEquals(flavors, flavorService.findAll());
    }

    /**
     * Testa se o metodo findById retorna o sabor quando ele existe.
     *
     * @see FlavorServiceImpl#findById(Long)
     */
    @Test
    void findByIdReturnsFlavorWhenExists() {
        Flavor flavor = new Flavor();
        flavor.setId(1L);
        when(flavorRepository.findById(1L)).thenReturn(Optional.of(flavor));
        assertEquals(flavor, flavorService.findById(1L));
    }

    /**
     * Testa se o metodo findById lan��a exceção quando o sabor não é encontrado.
     *
     * @see FlavorServiceImpl#findById(Long)
     */
    @Test
    void findByIdThrowsExceptionWhenNotFound() {
        when(flavorRepository.findById(99L)).thenReturn(Optional.empty());
        RuntimeException ex = assertThrows(RuntimeException.class, () -> flavorService.findById(99L));
        assertTrue(ex.getMessage().contains("Sabor não encontrado com ID: 99"));
    }

    /**
     * Testa se o metodo edit atualiza o sabor corretamente quando ele existe.
     *
     * @see FlavorServiceImpl#edit(Long, Flavor)
     */
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

    /**
     * Testa se o metodo deleteById remove o sabor corretamente.
     *
     * @see FlavorServiceImpl#deleteById(Long)
     */
    @Test
    void deleteByIdRemovesFlavor() {
        doNothing().when(flavorRepository).deleteById(1L);
        flavorService.deleteById(1L);
        verify(flavorRepository).deleteById(1L);
    }

    /**
     * Testa se o metodo findByType retorna os sabores do tipo informado.
     *
     * @see FlavorServiceImpl#findByType(TypeFlavors)
     */
    @Test
    void findByTypeReturnsFlavorsOfGivenType() {
        List<Flavor> flavors = List.of(new Flavor(), new Flavor());
        when(flavorRepository.findByType(TypeFlavors.SALGADO)).thenReturn(flavors);
        assertEquals(flavors, flavorService.findByType(TypeFlavors.SALGADO));
    }
}