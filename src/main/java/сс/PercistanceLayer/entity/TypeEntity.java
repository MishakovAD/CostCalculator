package сс.PercistanceLayer.entity;

public enum TypeEntity {
    INCOME("INCOME"),
    COST("COST"),
    WALLET("WALLET");

    private String type;

    TypeEntity(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
