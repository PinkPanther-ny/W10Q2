public enum DrinkType {
    BEER(7),
    MARTINI(8),
    VODKA(9);

    private final double price;

    DrinkType(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}
