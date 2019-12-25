package cc.BusinessLogicLayer.obj;

public enum WalletType {
    INCOME("INCOME"),
    COST("COST"),
    MONEY("MONEY");

    private String type;

    WalletType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
