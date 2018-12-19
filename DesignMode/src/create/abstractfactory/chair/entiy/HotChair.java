package create.abstractfactory.chair.entiy;

import create.abstractfactory.chair.Chair;

public class HotChair implements Chair{

	@Override
	public void run() {
		System.out.println("加热的椅子。。。");
		
	}

}
