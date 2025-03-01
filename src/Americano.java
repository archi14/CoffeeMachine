import java.util.Map;

public class Americano extends Coffee {
    public Americano(Map<IngrediantsType, Integer> ingrediants) {
        super(CoffeeType.AMERICANO, ingrediants);
    }

    @Override
    public double cost() {
        return 120;
    }
}
