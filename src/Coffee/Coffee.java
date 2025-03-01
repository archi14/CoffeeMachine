package Coffee;

import IngrediantsDecorator.IngrediantsType;

import java.util.Map;

public abstract class Coffee {
    private CoffeeType coffeeType;
    private Map<IngrediantsType, Integer> ingrediants;

    public Coffee(CoffeeType coffeeType, Map<IngrediantsType, Integer> ingrediants)
    {
        this.coffeeType = coffeeType;
        this.ingrediants = ingrediants;
    }

    public CoffeeType getCoffeeType() {
        return coffeeType;
    }

    public Map<IngrediantsType, Integer> getIngrediants() {
        return ingrediants;
    }

    public abstract double cost();
}
