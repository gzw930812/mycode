package create.factory.falali;

import create.factory.Car;
import create.factory.CarFactoryAbstract;

public class FalaliCarFactory extends CarFactoryAbstract{

	@Override
	public Car createCar() {
		
		Car car = new Car();
		car.setName("法拉利");
		car.setColor("blue");
		car.setSale(6000000);
		return car;
	}

}
