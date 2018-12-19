package action.strategy;

/**
 * 策略模式入口
 * @author gzw
 *
 */
public class OperationContext{
	Operation operation;
	
	public OperationContext(OperationEnum operationEnum) throws Exception{
		switch (operationEnum) {
		case ADD:
			this.operation = new AddOperation();
			break;
		case MULTI:
			this.operation = new MultiOperation();
			break;
		case DIV:
			this.operation = new DivOperation();
			break;
		case SUB:
			this.operation = new SubOperation();
			break;
		default:
			throw new Exception("传入参数错误。。");
		}
		
	}
	
	public Double getResult(double num1,double num2){
		return operation.getResult(num1, num2);
	}

}
