package ch03_pjt_03;

public class CalDiv implements ICalculator{

	@Override
	// 두 정수를 나누는 연산을 수행하는 메서드
	public int doOperation(int firstNum, int secondNum) {
		 // 두 번째 숫자가 0이 아닌 경우에만 나눗셈 연산을 수행하고, 그렇지 않으면 0을 반환
		return secondNum !=0 ? (firstNum/secondNum) : 0;
	}

}
