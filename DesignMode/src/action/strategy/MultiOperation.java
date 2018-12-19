package action.strategy;

public class MultiOperation implements Operation{

	@Override
	public Double getResult(double num1, double num2) {
		
		return num1*num2;
	}

}
