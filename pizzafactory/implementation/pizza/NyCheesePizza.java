package pizzafactory.implementation.pizza;
import pizzafactory.interfaces.Pizza;

public class NyCheesePizza  extends Pizza {
    
    public NyCheesePizza(){
	name = "Ny Cheese Pizza";
	dough = "Large";
	sauce = "Tomato & Onion";
	toppings.add("Extra Cheese");
    }

    @Override
    public void cut(){
	System.out.println("Cutting... Squares");
    }
}