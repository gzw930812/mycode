package create.abstractfactory.carfactory;

import create.abstractfactory.Car;
import create.abstractfactory.CarFactory;
import create.abstractfactory.car.BydCar;
import create.abstractfactory.chair.ChairFactory;
import create.abstractfactory.chair.constant.ChairConstant;
import create.abstractfactory.engine.EngineFactory;
import create.abstractfactory.engine.constant.EngineConstant;
import create.abstractfactory.wheels.WheelsFactory;
import create.abstractfactory.wheels.constant.WheelsConstant;

public class BydCarFactory implements CarFactory{

	@Override
	public Car createCar() {
		Car car = new BydCar();
		car.setChair(ChairFactory.createChair(ChairConstant.NOTHOT));
		car.setEngine(EngineFactory.createEngine(EngineConstant.LOWLY));
		car.setWheels(WheelsFactory.createWheels(WheelsConstant.NORMAL));
		return car;
	}

}
