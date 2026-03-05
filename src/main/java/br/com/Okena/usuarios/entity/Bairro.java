package br.com.Okena.usuarios.entity;

public enum Bairro {
    BAIRRO_DA_LUZ("Bairro da Luz"),
    CENTRO("Centro"),
    CALIFORNIA("Califónia"),
    CAONZE("Caonze"),
    JARDIM_IGUAÇU("Jardim Iguaçu"),
    JARDIM_TROPICAL("Jardim Tropical"),
    MOQUETA("Moquetá"),
    RANCHO_NOVO("Rancho Novo"),
    SANTA_EUGENIA("Santa Eugênia"),
    COMENDADOR_SOARES("Comendador Soares"),
    JARDIM_ALVORADA("Jardim Alvorada"),
    KM_32("Km 32"),
    MIGUEL_COUTO("Miguel Couto"),
    BOTAFOGO("Botafogo"),
    POSSE("Posse"),
    ADRIANOPOLIS("Adrianópolis"),
    TINGUA("Tinguá"),
    VILA_DE_CAVA("Vila de Cava"),
    SANTA_RITA("Santa Rita"),
    AUSTIN("Austin"),
    CABUCU("Cabuçu");

    private String bairro;

    Bairro(String bairro) {
        this.bairro = bairro;
    }
    public String getBairro() {
        return bairro;
    }

    public static Bairro fromString(String text) {
        for (Bairro bairro : Bairro.values()) {
            if (bairro.bairro.equalsIgnoreCase(text)) {
                return bairro;
            }
        }
        throw new IllegalArgumentException("Nenhum bairro encontrado para a string fornecida: " + text);
    }
}
