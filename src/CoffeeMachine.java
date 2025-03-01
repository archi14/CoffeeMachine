import java.util.*;

public class CoffeeMachine {

    private List<Coffee> coffeeMenu;
    StockManager stockManager;

    public CoffeeMachine()
    {
        coffeeMenu = new ArrayList<>();
        stockManager = new StockManager();
        initializeMenu();
        initializeIngrediants();
    }

    public void initializeIngrediants()
    {
        stockManager.addStock(IngrediantsType.WATER, 100);
        stockManager.addStock(IngrediantsType.MILK, 100);
        stockManager.addStock(IngrediantsType.WHIPPEDCREAM, 100);

    }
    public void initializeMenu()
    {
        // Americano
        Map<IngrediantsType, Integer> ingrediants = new HashMap<>();
        ingrediants.put(IngrediantsType.MILK, 10);
        ingrediants.put(IngrediantsType.WATER, 20);
        Coffee americano = new Americano(ingrediants);


        // Latte
        Map<IngrediantsType, Integer> ingrediants2 = new HashMap<>();
        ingrediants.put(IngrediantsType.MILK, 5);
        ingrediants.put(IngrediantsType.WATER, 2);
        Coffee latte = new Latte(ingrediants2);
        latte = new Milk(latte, 20);
        latte = new Water(latte, 5);

        // Cappucino
        Map<IngrediantsType, Integer> ingrediants3 = new HashMap<>();
        ingrediants.put(IngrediantsType.MILK, 10);
        ingrediants.put(IngrediantsType.WATER, 15);
        Coffee cappucino = new Cappucino(ingrediants3);

        coffeeMenu.add(americano);
        coffeeMenu.add(latte);
        coffeeMenu.add(cappucino);
    }

    public Coffee addIngrediant(Coffee coffee, IngrediantsType ingrediant, int count)
    {
        if(ingrediant == IngrediantsType.MILK)
        {
            coffee = new Milk(coffee, count);
        }
        if(ingrediant == IngrediantsType.WATER)
        {
            coffee = new Water(coffee, count);
        }
        if(ingrediant == IngrediantsType.WHIPPEDCREAM)
        {
            coffee = new WhippedCream(coffee, count);
        }
        return coffee;
    }

    public Coffee prepareCoffee(Coffee coffee) {
        System.out.println("Preparing " + coffee.getCoffeeType());
        Scanner scanner = new Scanner(System.in);
        for (Map.Entry<IngrediantsType, Integer> entry : coffee.getIngrediants().entrySet()) {
            IngrediantsType ingrediant = entry.getKey();
            int count = entry.getValue();
            if (stockManager.useStock(ingrediant, count)) {
                System.out.println("Adding " + count + " " + ingrediant + " to the coffee");

                while (true) {
                    System.out.println("Please 1 if you want to add more " + ingrediant + " to the coffee else press 0");
                    int option = scanner.nextInt();
                    if (option == 1) {
                        if (stockManager.useStock(ingrediant, 1)) {
                            coffee = addIngrediant(coffee, ingrediant, 1);
                        } else {
                            System.out.println("We're out of extra " + ingrediant);
                            break;
                        }
                    } else {
                        break;
                    }
                }
            } else {
                System.out.println("We're out of " + ingrediant + " for the coffee, please try again later");
                break;
            }
        }
        return coffee;
    }


    public void startMachine()
    {
        Scanner scanner = new Scanner(System.in);
        stockManager.printStock();
        System.out.println("what type of coffee do you want?");
        for(int i=0;i<coffeeMenu.size();i++)
        {
            Coffee coffee = coffeeMenu.get(i);
            System.out.println(i + " " + coffee.getCoffeeType() + " price is " + coffee.cost());
        }
        int coffeeOption = scanner.nextInt();
        Coffee coffee = coffeeMenu.get(coffeeOption);
        coffee = prepareCoffee(coffee);
        System.out.println("Total cost is " + coffee.cost());
    }
}
