package create.abstractfactory.chair.entiy;

import create.abstractfactory.chair.Chair;

public class NotHotChair implements Chair{

	@Override
	public void run() {
		System.out.println("不加热的椅子。。。");
		
	}

}
