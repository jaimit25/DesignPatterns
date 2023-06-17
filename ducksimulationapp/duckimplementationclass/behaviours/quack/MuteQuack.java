
package ducksimulationapp.duckimplementationclass.behaviours.quack;

import ducksimulationapp.duckabstractclass.interfaces.QuackBehaviour;



public class MuteQuack implements QuackBehaviour {
    @Override
    public void quack() {
        System.out.println("Mute Quack");
    }
}