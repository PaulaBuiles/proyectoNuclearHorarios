package co.edu.cue.proyectoNuclear.domain.enums;

public enum Semester {
    SEMESTER1(1),
    SEMESTER2(2),
    SEMESTER3(3),
    SEMESTER4(4),
    SEMESTER5(5),
    SEMESTER6(6),
    SEMESTER7(7),
    SEMESTER8(8);

    private final int value;

    Semester(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
