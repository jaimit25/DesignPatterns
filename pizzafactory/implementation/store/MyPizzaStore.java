package pizzafactory.implementation.store;

import pizzafactory.implementation.pizza.*;
import pizzafactory.interfaces.*;

public class MyPizzaStore extends PizzaStore{
 @Override
	public  Pizza createPizza(String type){
		Pizza pizza ;
		if(type.equals("cheese")){
			return new IndianCheesePizza();
		}else 
		return new IndianCheesePizza();
	}
	
}