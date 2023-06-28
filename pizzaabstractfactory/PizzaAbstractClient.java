package pizzaabstractfactory;

import pizzaabstractfactory.implementations.store.*;
import pizzaabstractfactory.interfaces.Pizza;
import pizzaabstractfactory.interfaces.PizzaStore;


public class PizzaAbstractClient{

	public static void main(String[]args){
		System.out.println("PIZZA ABSTRACT FACTORY");

		PizzaStore nyStore = new NyPizzaStore();
		PizzaStore chicagoStore = new ChicagoPizzaStore();

		System.out.println("*********************NEW YORK PIZZA*********************");
		Pizza pizza_ny = nyStore.orderPizza("cheese");
		System.out.println(pizza_ny.getName());

		System.out.println("*********************CHICAGO PIZZA*********************");
		Pizza pizza_c =  chicagoStore.orderPizza("clam");
		System.out.println(pizza_c.getName());

		


	}

}
