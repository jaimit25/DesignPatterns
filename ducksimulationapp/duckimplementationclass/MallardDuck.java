package ducksimulationapp.duckimplementationclass;

import ducksimulationapp.duckabstractclass.Duck;
import ducksimulationapp.duckimplementationclass.behaviours.fly.FlyWithWings;
import ducksimulationapp.duckimplementationclass.behaviours.quack.MuteQuack;

public class MallardDuck extends Duck {
    public MallardDuck() {
        flyBehaviour = new FlyWithWings();
        quackBehaviour = new MuteQuack();
    }

    @Override
    public void display() {
        System.out.println("Mallard Duck");
    }
}
