package dev.medeiros.sitePedidos.enums;

/**
 * Enum que representa os tipos de sabor de pizza disponíveis.
 */
public enum TypeFlavors {
    DOCE,
    SALGADO;

    /**
     * Converte uma string para o enum {@link TypeFlavors}, ignorando caixa e espaços.
     *
     * @param value valor textual ("doce", "DOCE", " DoCe ", etc.)
     * @return {@link TypeFlavors} correspondente
     * @throws IllegalArgumentException se o valor não for reconhecido
     */
    public static TypeFlavors fromStringIgnoreCase(String value) {
        return TypeFlavors.valueOf(value.trim().toUpperCase());
    }
}
