package pizzafactory.interfaces;

import java.util.*;

public abstract class Pizza {
	public String name,dough,sauce;
	public ArrayList<String> toppings = new ArrayList<>();

	void prepare(){
		System.out.println("Preparing "+name);
		System.out.println("Dough "+dough);
		System.out.println("Sauce "+sauce);
		System.out.println("Toppings");

		for(int i = 0 ; i < toppings.size() ; i++){
			System.out.println(" " +toppings.get(i));
		}
	}

	void bake(){
		System.out.println("Baking... ");
	}

	public void cut(){
		System.out.println("Cutting... ");
	}

	void box(){
		System.out.println("Boxing... ");
	}

	public String getName(){
		return name;
	}
}