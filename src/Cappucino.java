import java.util.Map;

public class Cappucino extends Coffee {
    public Cappucino(Map<IngrediantsType, Integer> ingrediants) {
        super(CoffeeType.CAPPUCINO, ingrediants);
    }

    @Override
    public double cost() {
        return 130;
    }
}
