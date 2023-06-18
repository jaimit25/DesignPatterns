package ducksimulationapp;

import ducksimulationapp.duckabstractclass.Duck;
import ducksimulationapp.duckimplementationclass.MallardDuck;


// STRATEGY PATTERN
public class DuckSimApp {
    public static void main(String[] args) {
        Duck duck = new MallardDuck();
        duck.display();
        duck.performFly();
        duck.performQuack();
    }
}
