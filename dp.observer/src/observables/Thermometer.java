package observables;

import java.util.Observable;

import events.TempChangedEvent;
/*
 * An observable object can have one or more observers. An observer may be any
 * object that implements interface Observer. After an observable instance 
 * changes, an application calling the Observable's notifyObservers method causes 
 * all of its observers to be notified of the change by a call to their update method. 
 */
public class Thermometer extends Observable {
	private double temp;

	public Thermometer(double temp) {
		super();
		this.temp = temp;
		System.out.println("Thermometer samples: " + temp);
	}

	public double getTemp() {
		return temp;
	}

	/*
	 * Randomly changes the value of 'temp' (increment, decrement or none) and 
	 * creates a TempChangedEvent object depicting the change and then notifying
	 * all of this object's observers.
	 */
	public void sampleTemp () {
		double rand = Math.random();
		double newTemp = this.temp;

		if (rand < 0.25){
			newTemp = this.temp - 1;
			/*
			 * The setChanged() method marks this Observable object as having 
			 * been changed; the hasChanged method of the object will now return
			 * true.
			 */
			this.setChanged();
		} else if (rand > 0.75){
			newTemp = this.temp + 1;
			this.setChanged();
		}

		TempChangedEvent event = new TempChangedEvent(this.temp, newTemp);
		this.temp = newTemp;

		System.out.println("Thermometer samples: " + this.temp);

		/*
		 * If this object has changed, as indicated by the hasChanged method, 
		 * then notify all of its observers and then call the clearChanged method
		 * to indicate that this object has no longer changed. Each observer has
		 * its update method called with two arguments: this observable object
		 * and the 'event' object as argument.
		 */
		notifyObservers(event);
	}
}
