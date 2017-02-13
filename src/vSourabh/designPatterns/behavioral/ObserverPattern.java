/**
 * 
 */
package vSourabh.designPatterns.behavioral;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Behavioural  design pattern
 * 
 * Observer design pattern is useful when you are interested in the state of an object 
 * and want to get notified whenever there is any change. In observer pattern, the object 
 * that watch on the state of another object are called Observer and the object that is being 
 * watched is called Subject.
 * 
 * Used in cases like:
 * Define a one-to-many dependency between objects so that when one object changes state, 
 * all its dependents are notified and updated automatically.
 * 
 * @author Sourabh
 *
 */

abstract class Observer {

	protected Subject subject;
	public abstract void update();
}

interface Subject {

	public void attach(Observer observer);
	public void notifyAllObservers();
	public int getState();
	public void setState(int state);
}

class SubjectImpl implements Subject {
	
	private List<Observer> observers = new ArrayList<Observer>();
	private int state;
	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
		notifyAllObservers();
	}

	public void attach(Observer observer) {
		observers.add(observer);
	}

	public void notifyAllObservers() {
		for (Observer observer : observers) {
			observer.update();
		}
	}	
}

class BinaryObserver extends Observer {

	public BinaryObserver(Subject subject) {
		this.subject = subject;
		this.subject.attach(this);
	}

	@Override
	public void update() {
		System.out.println("Binary Observer String: " 
				+ Integer.toBinaryString(subject.getState()));
	}
}

class OctalObserver extends Observer {

	public OctalObserver(Subject subject) {
		this.subject = subject;
		this.subject.attach(this);
	}

	@Override
	public void update() {
		System.out.println("Octal Observer String: " 
				+ Integer.toOctalString(subject.getState()));
	}
}

class HexaObserver extends Observer {

	public HexaObserver(Subject subject) {
		this.subject = subject;
		this.subject.attach(this);
	}

	@Override
	public void update() {
		System.out.println("Hex Observer String: " 
				+ Integer.toHexString(subject.getState()).toUpperCase());
	}
}

public class ObserverPattern {

	public static void main(String[] args) {
		Subject subject = new SubjectImpl();

		new HexaObserver(subject);
		new OctalObserver(subject);
		new BinaryObserver(subject);

		System.out.println("First state change: 15");
		subject.setState(15);
		System.out.println("Second state change: 10");
		subject.setState(10);
	}
}
