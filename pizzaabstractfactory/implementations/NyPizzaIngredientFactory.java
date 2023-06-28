package pizzaabstractfactory.implementations;


import java.util.*;
import pizzaabstractfactory.ingredients.*;
import pizzaabstractfactory.ingredients.implementations.cheese.*;
import pizzaabstractfactory.ingredients.implementations.clams.*;
import pizzaabstractfactory.ingredients.implementations.dough.*;
import pizzaabstractfactory.ingredients.implementations.pepproni.*;
import pizzaabstractfactory.ingredients.implementations.sauce.*;
import pizzaabstractfactory.ingredients.implementations.veggies.*;


import pizzaabstractfactory.ingredients.implementations.cheese.*;
import pizzaabstractfactory.interfaces.PizzaIngredientFactory;


public class NyPizzaIngredientFactory  implements PizzaIngredientFactory{
	
 @Override
	public Dough createDough(){
		return new ThinCrust();
	}
 @Override
	public Sauce createSauce(){
		return new TomatoSauce();
	}
 @Override
	public Cheese createCheese(){
		return new MozzarellaCheese();
	}
 @Override
	public ArrayList<Veggies> createVeggies(){
		ArrayList<Veggies> veggies = new ArrayList<>();
		veggies.add(new Veggie("Veggies1"));
		veggies.add(new Veggie("Veggies2"));
		return veggies;
	}
 @Override
	public Pepproni createPepperoni(){
		return new BeefPepproni();
	}
 @Override
	public Clams createClams(){
		return new FreshClams();
	}
}