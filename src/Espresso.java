import java.util.Map;

public class Espresso extends Coffee{
    public Espresso(Map<IngrediantsType, Integer> ingrediants) {
        super(CoffeeType.ESPRESSO, ingrediants);
    }

    @Override
    public double cost() {
        return 100;
    }
}
