package create.factory;

import create.factory.bmw.BmwCarFactory;
import create.factory.constant.CarConstant;
import create.factory.falali.FalaliCarFactory;
import create.factory.lanbo.LanboCarFactory;

public abstract class CarFactoryAbstract {
	
	
	public static  Car getCar(int type){
		CarFactoryAbstract carFactory = getCarFactory(type);
		return carFactory.createCar();
	};
	
	private static CarFactoryAbstract getCarFactory(int type){
		if(type == CarConstant.BMW){
			return new BmwCarFactory();
		}else if(type == CarConstant.FA_LA_LI){
			return new FalaliCarFactory();
		}else{
			return new LanboCarFactory();
		}
	}
	
	public abstract Car createCar();
	
	
	
}
