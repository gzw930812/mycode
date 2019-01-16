package create.builder.builder;

import create.builder.entiy.Body;
import create.builder.entiy.Head;
import create.builder.entiy.Leg;

//矮胖的游戏角色
public class FatPersonBuilder extends PersonBuilder{

	@Override
	Head builderHead() {
		
		return new Head("头大的。。。");
	}

	@Override
	Body builderBody() {
		
		return new Body("身体胖的。。。");
	}

	@Override
	Leg builderLeg() {
		
		return new Leg("腿短的。。。");
	}

}
