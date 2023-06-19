package weatherstationapp.implementationclass;

import java.util.*;
import weatherstationapp.abstractclass.Observer;
import weatherstationapp.abstractclass.Subject;

public class WeatherStation implements Subject{

	float temperature;
	float humidity;
	float pressure;
	ArrayList<Observer> observers;

	public WeatherStation(){
		observers = new ArrayList<Observer>();
	}


 @Override
	public void registerObserver(Observer o){
		observers.add(o);
	}
	
 @Override
	public void removeObserver(Observer o){
		int i = observers.indexOf(o);
		if (i >= 0) {
			observers.remove(i);
		 }
	}

 @Override
	public void notifyObservers(){
		for(int i = 0 ; i < observers.size() ; i++){
			observers.get(i).update(temperature,humidity,pressure);
		}
	}

	public void measurementsChanged() { 
		notifyObservers();
	}

	public void setMeasurements(float temperature, float humidity, float pressure) { 
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;
		measurementsChanged(); 
	}
	

}