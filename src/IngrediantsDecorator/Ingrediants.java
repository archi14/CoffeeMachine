package IngrediantsDecorator;

import Coffee.Coffee;

public abstract class Ingrediants extends Coffee {
    private Coffee coffee;
    public Ingrediants(Coffee coffee) {
        super(coffee.getCoffeeType(), coffee.getIngrediants());
        this.coffee = coffee;
    }
    public Coffee getCoffee() {
        return coffee;
    }
}
