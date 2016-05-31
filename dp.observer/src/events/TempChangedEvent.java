package events;

/*
 * A class representing an event accruing in the Observable object. When ever
 * an event occurs, the observers of the observable object are being notified 
 * about the event. 
 */
public class TempChangedEvent {
	private double oldTemp;
	private double newTemp;

	public TempChangedEvent(double oldTemp, double newTemp) {
		super();
		this.oldTemp = oldTemp;
		this.newTemp = newTemp;
	}

	public double getOldTemp() {
		return oldTemp;
	}

	public double getNewTemp() {
		return newTemp;
	}

	@Override
	public String toString() {
		return "TempChangedEvent [oldTemp=" + oldTemp + ", newTemp=" + newTemp + "]";
	}
}
