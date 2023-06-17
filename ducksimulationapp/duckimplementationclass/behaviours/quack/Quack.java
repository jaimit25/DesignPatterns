package ducksimulationapp.duckimplementationclass.behaviours.quack;

import ducksimulationapp.duckabstractclass.interfaces.QuackBehaviour;



public class Quack implements QuackBehaviour {
    @Override
    public void quack() {
        System.out.println("Quack");
    }
}