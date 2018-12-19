package action.strategy;

public class Test {

	public static void main(String[] args) throws Exception {
		
		OperationContext context = new OperationContext(OperationEnum.ADD);
		double result = context.getResult(15, 12);
		System.out.println(result);
	}
	
}
