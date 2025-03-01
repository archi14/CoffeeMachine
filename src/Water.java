public class Water extends Ingrediants{
    private int quantityML;
    private int costPerML;

    public Water(Coffee coffee, int quantityML) {
        super(coffee);
        this.quantityML = quantityML;
        this.costPerML = 2;
    }

    public int getQuantityML() {
        return quantityML;
    }

    @Override
    public double cost() {
        return getCoffee().cost() + quantityML*costPerML;
    }
}
