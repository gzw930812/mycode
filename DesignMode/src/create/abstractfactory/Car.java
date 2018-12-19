package create.abstractfactory;

import create.abstractfactory.chair.Chair;
import create.abstractfactory.engine.Engine;
import create.abstractfactory.wheels.Wheels;

public abstract class Car {
	
	private Engine engine;
	private Chair chair;
	private Wheels wheels;
	
	public abstract void run();
	public Engine getEngine() {
		return engine;
	}
	public void setEngine(Engine engine) {
		this.engine = engine;
	}
	public Chair getChair() {
		return chair;
	}
	public void setChair(Chair chair) {
		this.chair = chair;
	}
	public Wheels getWheels() {
		return wheels;
	}
	public void setWheels(Wheels wheels) {
		this.wheels = wheels;
	}

	
	
}
