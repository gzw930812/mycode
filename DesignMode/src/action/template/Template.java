package action.template;

public abstract class Template {

	abstract void actionA();
	public void actionB(){
		System.out.println("操作B");
	}
	abstract void actionC();
	
	public void execute(){
		actionA();
		actionB();
		actionC();
	}
}
