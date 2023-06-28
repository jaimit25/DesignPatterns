package pizzaabstractfactory.interfaces;

import java.util.*;

import pizzaabstractfactory.ingredients.*;

public abstract class Pizza {
	
	public String name;
	public Dough dough;
	public Sauce sauce;
	public ArrayList<Veggies> veggies;
	public Pepproni pepproni;
	public Cheese cheese ;
	public Clams clam ;

	public abstract void prepare();

	public void bake(){
		System.out.println("Baking... ");
	}

	public void cut(){
		System.out.println("Cutting... ");
	}

	public void box(){
		System.out.println("Boxing... ");
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

 	@Override
	public String toString(){
		return name;
	}

	
}