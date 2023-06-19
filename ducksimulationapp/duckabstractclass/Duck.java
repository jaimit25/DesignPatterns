package ducksimulationapp.duckabstractclass;
import ducksimulationapp.duckabstractclass.interfaces.FlyBehaviour;
import ducksimulationapp.duckabstractclass.interfaces.QuackBehaviour;

public abstract class Duck {
    // Properties FlyBehaviour and QuackBehaviour
   public  FlyBehaviour flyBehaviour;
    public QuackBehaviour quackBehaviour;

    public abstract void display();

    public void swim() {
        System.out.println("Swimming...");
    }

    public void performFly() {
        flyBehaviour.fly();
    }

    public void performQuack() {
        quackBehaviour.quack(); 
    }

    public void setBehaviour(FlyBehaviour _flyBehaviour, QuackBehaviour _quackBehaviour){
		flyBehaviour = _flyBehaviour;
		quackBehaviour = _quackBehaviour;
	}
}




