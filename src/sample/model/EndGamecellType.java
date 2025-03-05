package sample.model;

public enum EndGamecellType {
    Cat("00"),Cheese("CH");

    public final String symbol;

    EndGamecellType(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

}

