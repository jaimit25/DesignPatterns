package pizzaabstractfactory.implementations.pizza;

import pizzaabstractfactory.interfaces.Pizza;
import pizzaabstractfactory.interfaces.PizzaIngredientFactory;
public class ClamPizza extends Pizza {
		PizzaIngredientFactory ingredientFactory;
		
		public ClamPizza(PizzaIngredientFactory ingredientFactory){
			this.ingredientFactory = ingredientFactory;
			setName("Clam Pizza");
		}
	
		public void prepare(){
			System.out.println("Preparing : " + name);
			dough = ingredientFactory.createDough();
			sauce = ingredientFactory.createSauce();
			veggies = ingredientFactory.createVeggies();
			pepproni = ingredientFactory.createPepperoni();
			cheese = ingredientFactory.createCheese();
		}
	}