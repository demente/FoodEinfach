package my.superfood.model.enums;

public enum Unit {
    GRAM("g", 1000000L),
    MICROGRAM("μg", 1L),
    SPOON("tbs", 14300000L);

    private String label;
    private Long multiplier;

    Unit(String label, Long multiplier) {
        this.label = label;
        this.multiplier = multiplier;
    }

    public static Unit getByLabel(String label) {
        for (Unit unit : values()) {
            if (unit.getLabel().equals(label)) {
                return unit;
            }
        }
        return null;
    }

    public String getLabel() {
        return label;
    }

    public Long getMultiplier() {
        return multiplier;
    }
}
