package ducksimulationapp.duckimplementationclass.behaviours.fly;
import ducksimulationapp.duckabstractclass.interfaces.FlyBehaviour;

class FlyRocketPowered implements FlyBehaviour{

 @Override
	public void fly(){
		System.out.println("I can Fly like IRON MAN");
	}
}