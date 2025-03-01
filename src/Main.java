import Coffee.Americano;
import Coffee.CoffeeType;
import Coffee.Coffee;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
                CoffeeMachine machine = new CoffeeMachine();
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Coffee coffee = new Americano(machine.getReciepe(CoffeeType.AMERICANO).getIngrediants());
                        machine.prepareCoffee(coffee);
                    }
                });

                Thread thread2 = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Coffee coffee2 = new Americano(machine.getReciepe(CoffeeType.AMERICANO).getIngrediants());
                        machine.prepareCoffee(coffee2);
                    }
                });
                thread.start();
                thread2.start();

        }
}