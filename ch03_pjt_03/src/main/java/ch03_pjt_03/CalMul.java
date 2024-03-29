package ch03_pjt_03;

public class CalMul implements ICalculator{

	@Override
	// 두 정수를 곱하는 연산 수행
	public int doOperation(int firstNum, int secondNum) {
		return firstNum * secondNum;
	}

}
