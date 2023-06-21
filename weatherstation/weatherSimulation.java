package weatherstation;

import java.util.Observer;
import weatherstation.WeatherData;
import weatherstation.observer.CurrentDisplay;

class weatherSimulation {
	public static void main(String[]args)
	{
		WeatherData wd = new WeatherData();
		Observer currentDisplay = new CurrentDisplay(wd);
		wd.setMeasurements(80, 65, 30.4f);
		wd.setMeasurements(81, 65, 30.4f);
		wd.setMeasurements(82, 65, 30.4f);

	}
}