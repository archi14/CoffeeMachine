import java.util.HashMap;
import java.util.Map;

public class StockManager {
    private Map<IngrediantsType, Integer> ingrediants;

    public StockManager()
    {
        ingrediants = new HashMap<>();
    }

    public void addStock(IngrediantsType ingrediantsType, int count)
    {
        ingrediants.put(ingrediantsType, ingrediants.getOrDefault(ingrediants, 0) + count);
    }

    public boolean useStock(IngrediantsType ingrediantsType, int count)
    {
        if(count <= ingrediants.get(ingrediantsType))
        {
            ingrediants.put(ingrediantsType, ingrediants.get(ingrediantsType)-count);
            return true;
        }else {
            return false;
        }
    }

    public void printStock()
    {
        for(Map.Entry<IngrediantsType, Integer> entry : ingrediants.entrySet())
        {
            System.out.println("Stock of " + entry.getKey() + ": " + entry.getValue());
        }
    }
}
