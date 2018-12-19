package create.simplefactory;

public class Test {

	
	public static void main(String[] args) {
		HumanFactory.createHuman(HumanConstant.MAN).sex();
		HumanFactory.createHuman(HumanConstant.WOMAN).sex();
	}
}
