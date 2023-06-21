package weatherstation.observer;
import java.util.Observable;
import java.util.Observer;
import weatherstation.WeatherData;

public class CurrentDisplay implements Observer {

    Observable observable;

    private float temperature; private float humidity;

    public CurrentDisplay (Observable observable){
	this.observable = observable;
	observable.addObserver(this);
    }
    
    @Override
    public void update(Observable obs, Object arg) {
	if (obs instanceof WeatherData) {
	    WeatherData wd = (WeatherData) obs;
	    temperature = wd.getTemperature();
	    humidity = wd.getHumidity();
	    display();
	}
    }

    public void display() {
	System.out.println( "Current conditions: " + temperature + "F degrees and " + humidity + "% humidity");
    }
}