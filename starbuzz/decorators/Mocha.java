package starbuzz.decorators;

import starbuzz.abstracts.Beverage;
import starbuzz.abstracts.CondimentDecorators;

public class Mocha extends CondimentDecorators {
    Beverage beverage;

    public Mocha (Beverage bevarage){
        this.beverage = bevarage;
    }

    @Override
    public double cost() {
        return beverage.cost() + 0.2;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Mocha";
    }
}