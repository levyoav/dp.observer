package observers;

import java.util.Observable;
import java.util.Observer;

import events.TempChangedEvent;

/*
 * A class can implement the Observer interface when it wants to be informed of 
 * changes in observable objects. In this case, a Display object is both an 
 * observer (observes the Thermometer object or another Display object) and
 * an observable (observed by another Display object).
 */
public class Display extends Observable implements Observer {
	private String name;

	public Display(String name) {
		super();
		this.name = name;
	}

	/*
	 * (non-Javadoc)
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 * This method is called whenever the observed object (Thermometer or Display
	 * object) is changed. An application calls an Observable object's 
	 * notifyObservers method to have all the object's observers notified of 
	 * the change. The 'subject' argument is the reference to the observable
	 * object and the 'event' argument is the reference to an object depicting
	 * the event that accrued.
	 */
	@Override
	public void update(Observable subject, Object event) {
		if (event instanceof TempChangedEvent){
			TempChangedEvent tempChangedEvent = (TempChangedEvent) event;
			System.out.println("Display[" + name + "]: " + tempChangedEvent.getNewTemp());
		}


		setChanged(); //Setting this observable as changed.
		notifyObservers(event); //Notifying all of this observable's observers of the change.
	}
}
