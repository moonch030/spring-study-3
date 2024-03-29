package ch03_pjt_03;

public class CalAdd implements ICalculator{
	//public CalAdd(){} // Default Constructor
	public CalAdd() {
		System.out.println("CalAdd 기본 생성자 호출됨");
		 // System.out.println("CalAdd 기본 생성자 호출됨");
        // CalAdd 기본 생성자 호출됨 메시지 주석 처리
	}
	
	@Override
	public int doOperation(int firstNum, int secondNum) {
		return firstNum + secondNum;
	}
}
