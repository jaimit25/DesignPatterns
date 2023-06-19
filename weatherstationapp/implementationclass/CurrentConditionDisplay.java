package weatherstationapp.implementationclass;
import weatherstationapp.abstractclass.Display;
import weatherstationapp.abstractclass.Observer;
import weatherstationapp.abstractclass.Subject;

public class CurrentConditionDisplay implements Observer, Display {

	float temperature, humidity, pressure;
	Subject ws ;
	public CurrentConditionDisplay(Subject ws) {
		this.ws = ws;
		// TODO Auto-generated constructor stub
		ws.registerObserver(this);
	}

 @Override
	public void update(float temp, float humidity,float pressure){
		this.temperature = temp;
		this.humidity = humidity;
		this.pressure = pressure;
		display();
	}
 @Override
	public void display() {
		System.out.println("Current conditions: " + temperature + " F degrees and " + humidity + "% humidity");	
	}

}