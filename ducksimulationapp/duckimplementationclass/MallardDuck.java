package ducksimulationapp.duckimplementationclass;

import ducksimulationapp.duckabstractclass.Duck;

public class MallardDuck extends Duck {
    public MallardDuck() {
        super();
    }

    @Override
    public void display() {
        System.out.println("Mallard Duck");
    }
}
