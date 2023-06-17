package ducksimulationapp.duckimplementationclass.behaviours.fly;

import ducksimulationapp.duckabstractclass.interfaces.FlyBehaviour;

public class FlyNoWay implements FlyBehaviour {
    @Override
    public void fly() {
	System.out.println("I can't fly!");
    }
}