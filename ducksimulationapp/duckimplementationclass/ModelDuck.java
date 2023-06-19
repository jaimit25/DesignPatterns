package ducksimulationapp.duckimplementationclass;


import ducksimulationapp.duckabstractclass.Duck;
import ducksimulationapp.duckimplementationclass.behaviours.fly.FlyNoWay;
import ducksimulationapp.duckimplementationclass.behaviours.quack.Quack;

public class ModelDuck extends Duck{

	public ModelDuck(){
		flyBehaviour = new FlyNoWay();
		quackBehaviour = new Quack();
	}

	
 	@Override
	public void display(){
		System.out.println("This is Model Duck");
	}
	
}