package pizzaabstractfactory.implementations.store;

import pizzaabstractfactory.implementations.ChicagoPizzaIngredientFactory;
import pizzaabstractfactory.implementations.pizza.*;
import pizzaabstractfactory.interfaces.Pizza;
import pizzaabstractfactory.interfaces.PizzaIngredientFactory;
import pizzaabstractfactory.interfaces.PizzaStore;



public class ChicagoPizzaStore extends PizzaStore {
	Pizza pizza = null;
	PizzaIngredientFactory ingredientFactory = new ChicagoPizzaIngredientFactory();

 @Override
	public Pizza createPizza(String type){
		
		if(type.equals("cheese")){
			pizza = new CheesePizza(ingredientFactory);
			pizza.setName("Chicago Cheese Pizza");
		}
		else if(type.equals("clam")){
			pizza = new ClamPizza(ingredientFactory);
			pizza.setName("Chicago Clam Pizza");
		}
		return pizza;
	}

}