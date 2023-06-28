package pizzaabstractfactory.ingredients.implementations.veggies;
import pizzaabstractfactory.ingredients.*;

public class Veggie extends Veggies{

	public Veggie(String name){
		setDesc(name);
	}

	public String getVeggie(){
		return getDesc();
	}
	
}