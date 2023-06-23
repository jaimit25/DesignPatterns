package starbuzz.components;

import starbuzz.abstracts.Beverage;

public class Espresso extends Beverage {

    public Espresso() {
        desc = "Espresso";
    }

    @Override
    public double cost() {
       return 1.99;
    }
}