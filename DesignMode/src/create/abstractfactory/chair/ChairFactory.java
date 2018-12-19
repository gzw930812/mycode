package create.abstractfactory.chair;

import create.abstractfactory.chair.constant.ChairConstant;
import create.abstractfactory.chair.entiy.HotChair;
import create.abstractfactory.chair.entiy.NotHotChair;

public class ChairFactory {

	public static Chair createChair(ChairConstant type){
		if(type == ChairConstant.HOT){
			return new HotChair();
		}else if(type == ChairConstant.NOTHOT){
			return new NotHotChair();
		}else{
			return null;
		}
	};
}
