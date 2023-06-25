package pizzafactory;
import pizzafactory.implementation.store.*;
import pizzafactory.interfaces.*;



public class PizzaClient{
		public static void main(String[] args){

			PizzaStore myStore = new MyPizzaStore();
			PizzaStore nyStore = new NyPizzaStore();

			Pizza pizza = myStore.orderPizza("cheese");
			Pizza pizza2 = nyStore.orderPizza("cheese");

			System.out.println(pizza.getName());
			System.out.println(pizza2.getName());


	}
}