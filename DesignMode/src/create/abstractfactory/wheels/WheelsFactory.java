package create.abstractfactory.wheels;

import create.abstractfactory.wheels.constant.WheelsConstant;
import create.abstractfactory.wheels.entiy.WheelsA;
import create.abstractfactory.wheels.entiy.WheelsB;

public class WheelsFactory {
	
	public static Wheels createWheels(WheelsConstant type){
		
		if(type == WheelsConstant.GOOD){
			return new WheelsA();
		}else if(type == WheelsConstant.NORMAL){
			return new WheelsB();
		}else{
			return null;
		}
		
	}

}
