package co.edu.cue.proyectoNuclear.domain.enums;



public enum Property {
    PROJECTOR(0, "Proyector"),
    CAMERA(1, "Cámara"),
    TELEVISION(2, "Televisión"),
    AIR_CONDITIONER(3, "Aire Acondicionado"),
    VENTILATOR(4, "Ventilador");

    private final int value;
    private final String spanishName;

    Property(int value, String spanishName) {
        this.value = value;
        this.spanishName = spanishName;
    }

    public int getValue() {
        return value;
    }

    public String getSpanishName() {
        return spanishName;
    }

    public static Property getBySpanishName(String spanishName) {
        for (Property property : Property.values()) {
            if (property.getSpanishName().equalsIgnoreCase(spanishName)) {
                return property;
            }
        }
        throw new IllegalArgumentException("Invalid property name: " + spanishName);
    }
}
