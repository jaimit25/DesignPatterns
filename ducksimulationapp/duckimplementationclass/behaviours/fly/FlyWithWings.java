package ducksimulationapp.duckimplementationclass.behaviours.fly;

import ducksimulationapp.duckabstractclass.interfaces.FlyBehaviour;

public class FlyWithWings implements FlyBehaviour{
    @Override
    public void fly() {
    	System.out.println("I'm flying with Wings!");
    }
}