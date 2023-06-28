package pizzaabstractfactory.implementations.store;

import pizzaabstractfactory.implementations.pizza.*;
import pizzaabstractfactory.interfaces.Pizza;
import pizzaabstractfactory.interfaces.PizzaStore;

import pizzaabstractfactory.interfaces.PizzaIngredientFactory;
import pizzaabstractfactory.implementations.NyPizzaIngredientFactory;


public class NyPizzaStore extends PizzaStore {
	Pizza pizza = null;
	PizzaIngredientFactory ingredientFactory = new NyPizzaIngredientFactory();

 @Override
	public Pizza createPizza(String type){
		
		if(type.equals("cheese")){
			pizza = new CheesePizza(ingredientFactory);
			pizza.setName("New YorkCheese Pizza");
		}
		else if(type.equals("clam")){
			pizza = new ClamPizza(ingredientFactory);
			pizza.setName("New York Clam Pizza");
		}
		return pizza;
	}

}