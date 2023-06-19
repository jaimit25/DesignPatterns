package weatherstationapp;
import weatherstationapp.abstractclass.*;
import weatherstationapp.implementationclass.CurrentConditionDisplay;
import weatherstationapp.implementationclass.WeatherStation;


public class WeatherStationApp{
	
	public static void main(String[] args) {
		WeatherStation ws = new WeatherStation();
		Observer currentDisplay = new CurrentConditionDisplay(ws); //subscribing 
		
		ws.setMeasurements(80, 65, 30.4f);
		ws.setMeasurements(81, 65, 30.4f);
		ws.setMeasurements(82, 65, 30.4f);
		
	}
}