public class Milk extends Ingrediants {
    private int quantityML;
    private int costPerML;
    public Milk(Coffee coffee, int quantityML) {
        super(coffee);
        this.quantityML = quantityML;
        this.costPerML = 10;
    }

    public int getQuantityML() {
        return quantityML;
    }

    @Override
    public double cost() {
        return getCoffee().cost() + quantityML*costPerML;
    }
}
