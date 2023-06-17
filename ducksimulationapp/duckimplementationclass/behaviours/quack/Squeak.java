package ducksimulationapp.duckimplementationclass.behaviours.quack;

import ducksimulationapp.duckabstractclass.interfaces.QuackBehaviour;



public class Squeak implements QuackBehaviour {
    @Override
    public void quack() {
        System.out.println("Squeak");
    }
}