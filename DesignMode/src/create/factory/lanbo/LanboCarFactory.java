package create.factory.lanbo;

import create.factory.Car;
import create.factory.CarFactoryAbstract;

public class LanboCarFactory extends CarFactoryAbstract{

	@Override
	public Car createCar() {
		Car car = new Car();
		car.setName("兰博基尼");
		car.setColor("black");
		car.setSale(7000000);
		return car;
	}

}
