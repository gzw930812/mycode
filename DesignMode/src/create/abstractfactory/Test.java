package create.abstractfactory;

import create.abstractfactory.carfactory.BmwCarFactory;

public class Test {

	public static void main(String[] args) {
		CarFactory factory = new BmwCarFactory();
		Car car = factory.createCar();
		car.run();
		car.getChair().run();
		car.getEngine().run();
		car.getWheels().run();
	}
	
}
