package ch02_pjt_03;

public class CalAdd implements ICalculator{
	//public CalAdd(){} // Default Constructor
	
	@Override
	public int doOperation(int firstNum, int secondNum) {
		return firstNum + secondNum;
	}

}
