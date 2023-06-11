package co.edu.cue.proyectoNuclear.domain.enums;

public enum DayOfWeek {
    MONDAY(0, "Lunes"),
    TUESDAY(1, "Martes"),
    WEDNESDAY(2, "Miércoles"),
    THURSDAY(3, "Jueves"),
    FRIDAY(4, "Viernes"),
    SATURDAY(5, "Sábado");

    private final int value;
    private final String name;

    DayOfWeek(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }
}

