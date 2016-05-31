package main;

import observables.Thermometer;
import observers.Display;

//SOURCE FILE FOR THIS PROJECT: 20151216.01.observer.zip.
public class Main {
	public static void main(String[] args) {
		Thermometer t = new Thermometer(25.0);
		Display d1 = new Display("d1");
		Display d2 = new Display("d2");
		Display d3 = new Display("d3");

		t.addObserver(d1); //Adding an observer to the Thermometer object.
		d1.addObserver(d2); //Adding an observer to the Display object, which is itself an observable .
		d2.addObserver(d3); //Same.

		for (int i = 0; i < 10; i++){
			t.sampleTemp();
		}
	}
}
