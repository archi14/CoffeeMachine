import java.util.Map;

public class Latte extends Coffee {
    public Latte(Map<IngrediantsType, Integer> ingrediants) {
        super(CoffeeType.LATTE, ingrediants);
    }

    @Override
    public double cost() {
        return 150;
    }
}
