package br.com.jfabiodev.APIScreenMatch.enums;

public enum Categoria {
    ACAO("Action", "Ação"),
    ROMANCE("Romance", "Romance"),
    COMEDIA("Comedy", "Comedia"),
    DRAMA("Drama", "Drama"),
    CRIME("Crime", "Crime"),
    TERROR("Horror","Terror");

    private String categoriaOMDB;
    private String categoriaPortugues;

    Categoria(String categoriaOMDB, String categoriaPortugues){
        this.categoriaOMDB = categoriaOMDB;
        this.categoriaPortugues = categoriaPortugues;
    }


    public static Categoria fromString(String text) {
        for (Categoria categoria : Categoria.values()) {
            if (categoria.categoriaOMDB.equalsIgnoreCase(text)) {
                return categoria;
            }
        }
        throw new IllegalArgumentException("Nenhuma categoria encontrada para a string fornecida: " + text);
    }
    public static Categoria fromPortugues(String text) {
        for (Categoria categoria : Categoria.values()) {
            if (categoria.categoriaPortugues.equalsIgnoreCase(text)) {
                return categoria;
            }
        }
        throw new IllegalArgumentException("Nenhuma categoria encontrada para a string fornecida: " + text);
    }
}
