package starbuzz;

import starbuzz.abstracts.Beverage;
import starbuzz.components.Espresso;
import starbuzz.decorators.Mocha;

public class StarBuzz {
    public static void main(String[]args){
        Beverage beverage = new Espresso();

        beverage = new Mocha(beverage);
        beverage = new Mocha(beverage);

        System.out.println(beverage.getDescription() + " $" + beverage.cost());

    }
}