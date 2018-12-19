package create.factory.bmw;

import create.factory.Car;
import create.factory.CarFactoryAbstract;

public class BmwCarFactory extends CarFactoryAbstract{

	@Override
	public Car createCar() {
		Car car = new Car();
		car.setName("宝马");
		car.setColor("red");
		car.setSale(500000000);
		return car;
	}

}
