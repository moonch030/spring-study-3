package ch03_pjt_03;

public class CalSub implements ICalculator{

	@Override
	//두 정수를 빼는 연산 수행
	public int doOperation(int firstNum, int secondNum) {
		return firstNum - secondNum;
	}

}
