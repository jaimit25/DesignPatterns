package pizzafactory.implementation.store;

import pizzafactory.implementation.pizza.*;
import pizzafactory.interfaces.*;

public class NyPizzaStore extends PizzaStore{
	@Override
	       public Pizza createPizza(String type){
		       Pizza pizza ;
		       if(type.equals("cheese")){
			       return new NyCheesePizza();
		       }else 
		       return new NyCheesePizza();
	       }
	       
       }