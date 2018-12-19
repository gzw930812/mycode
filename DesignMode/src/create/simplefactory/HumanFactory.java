package create.simplefactory;

public class HumanFactory {

	public static Human createHuman(HumanConstant h){
		switch (h) {
		case MAN:
			return new ManHuman();
		default:
			return new WomenHuman();
		}
		
	}
	
	
}
