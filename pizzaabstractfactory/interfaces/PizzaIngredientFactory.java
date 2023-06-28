package pizzaabstractfactory.interfaces;

import pizzaabstractfactory.ingredients.*;
import java.util.*;
public interface PizzaIngredientFactory {
    public Dough createDough();
    public Sauce createSauce();
    public Cheese createCheese();
    public ArrayList<Veggies> createVeggies();
    public Pepproni createPepperoni();
    public Clams createClams();
}