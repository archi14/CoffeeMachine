public class WhippedCream extends Ingrediants {
    private int price;
    private int squeeze;

    public WhippedCream(Coffee coffee, int squeeze) {
        super(coffee);
        this.price = 50;
        this.squeeze = squeeze;
    }

    public int getSqueeze() {
        return squeeze;
    }

    @Override
    public double cost() {
        return getCoffee().cost() + price*squeeze;
    }
}
