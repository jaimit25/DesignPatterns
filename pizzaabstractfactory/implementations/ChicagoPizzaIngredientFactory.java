package pizzaabstractfactory.implementations;



import java.util.*;
import pizzaabstractfactory.ingredients.*;
import pizzaabstractfactory.ingredients.implementations.cheese.*;
import pizzaabstractfactory.ingredients.implementations.clams.*;
import pizzaabstractfactory.ingredients.implementations.dough.*;
import pizzaabstractfactory.ingredients.implementations.pepproni.*;
import pizzaabstractfactory.ingredients.implementations.sauce.*;
import pizzaabstractfactory.ingredients.implementations.veggies.*;
import pizzaabstractfactory.interfaces.PizzaIngredientFactory;




public class ChicagoPizzaIngredientFactory implements PizzaIngredientFactory{
	
 @Override
	public Dough createDough(){
		return new ThickCrust();
	}
 @Override
	public Sauce createSauce(){
		return new TomatoSauce();
	}
 @Override
	public Cheese createCheese(){
		return new GoatCheese();
	}
 @Override
	public ArrayList<Veggies> createVeggies(){
		ArrayList<Veggies> veggies = new ArrayList<>();
		veggies.add(new Veggie("Veggies_chicago1"));
		veggies.add(new Veggie("Veggies_chicago2"));
		return veggies;
	}
 @Override
	public Pepproni createPepperoni(){
		return new PorkPepproni();
	}
 @Override
	public Clams createClams(){
		return new FreshClams();
	}
}