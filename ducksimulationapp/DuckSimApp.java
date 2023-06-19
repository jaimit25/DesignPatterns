package ducksimulationapp;

import ducksimulationapp.duckabstractclass.Duck;
import ducksimulationapp.duckimplementationclass.MallardDuck;
import ducksimulationapp.duckimplementationclass.ModelDuck;
import ducksimulationapp.duckimplementationclass.behaviours.fly.FlyWithWings;
import ducksimulationapp.duckimplementationclass.behaviours.quack.Quack;


// STRATEGY PATTERN
public class DuckSimApp {
    public static void main(String[] args) {
        Duck duck = new MallardDuck();
        duck.display();
        duck.performFly();
        duck.performQuack();

        Duck duck2 = new ModelDuck();
        duck2.setBehaviour(new FlyWithWings(),new Quack());
        duck2.display();
        duck2.performFly();
        duck2.performQuack();
    }   
}
