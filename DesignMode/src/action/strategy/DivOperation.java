package action.strategy;

public class DivOperation implements Operation{

	@Override
	public Double getResult(double num1, double num2) {
		if(num2 == 0){
			try {
				throw new Exception("被除数不能为0");
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}else{
			return num1/num2;
		}
		
		
	}

}
