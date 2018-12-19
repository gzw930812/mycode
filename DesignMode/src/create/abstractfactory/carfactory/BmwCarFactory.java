package create.abstractfactory.carfactory;

import create.abstractfactory.Car;
import create.abstractfactory.CarFactory;
import create.abstractfactory.car.BmwCar;
import create.abstractfactory.chair.ChairFactory;
import create.abstractfactory.chair.constant.ChairConstant;
import create.abstractfactory.engine.EngineFactory;
import create.abstractfactory.engine.constant.EngineConstant;
import create.abstractfactory.wheels.WheelsFactory;
import create.abstractfactory.wheels.constant.WheelsConstant;

public class BmwCarFactory implements CarFactory{


	@Override
	public Car createCar() {
		Car car = new BmwCar();
		car.setChair(ChairFactory.createChair(ChairConstant.HOT));
		car.setEngine(EngineFactory.createEngine(EngineConstant.FAST));
		car.setWheels(WheelsFactory.createWheels(WheelsConstant.GOOD));
		return car;
	}

}
