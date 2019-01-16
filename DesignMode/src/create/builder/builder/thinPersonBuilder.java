package create.builder.builder;

import create.builder.entiy.Body;
import create.builder.entiy.Head;
import create.builder.entiy.Leg;

//创建瘦高的游戏角色
public class thinPersonBuilder extends PersonBuilder{

	@Override
	Head builderHead() {
		
		return new Head("头小的。。。");
	}

	@Override
	Body builderBody() {
		
		return new Body("身体瘦的。。。");
	}

	@Override
	Leg builderLeg() {
		
		return new Leg("腿长的。。。");
	}

	
	
	
}
