package create.abstractfactory.engine;

import create.abstractfactory.engine.constant.EngineConstant;
import create.abstractfactory.engine.entiy.EngineA;
import create.abstractfactory.engine.entiy.EngineB;

public class EngineFactory {

	public static Engine createEngine(EngineConstant type){
		
		if(type == EngineConstant.FAST){
			return new EngineA();
		}else if(type == EngineConstant.LOWLY){
			return new EngineB();
		}else{
			return null;
		}
	}
}
