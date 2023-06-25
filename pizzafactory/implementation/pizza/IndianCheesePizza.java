package pizzafactory.implementation.pizza;
import pizzafactory.interfaces.Pizza;


public class IndianCheesePizza extends Pizza {
	public IndianCheesePizza(){
		name = "Indian Cheese Pizza";
		dough = "Regular";
		sauce = "Tomato";
		toppings.add("Paneer");		
	}
	
}