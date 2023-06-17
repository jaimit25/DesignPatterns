package ducksimulationapp;

import ducksimulationapp.duckabstractclass.Duck;
import ducksimulationapp.duckimplementationclass.MallardDuck;

public class DuckSimApp {
    public static void main(String[] args) {
        Duck duck = new MallardDuck();
        duck.display();
    }
}
