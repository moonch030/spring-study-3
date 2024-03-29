package ch02_pjt_02;


//계산기 프로그램을 DI 방식으로 변경하기
public class MainClass {
	public static void main(String[]args) {
		MyCalculator calculator = new MyCalculator();
		calculator.calculate(15,5, new CalAdd());
		calculator.calculate(15,5, new CalSub());
		calculator.calculate(15,5, new CalMul());
		calculator.calculate(15,5, new CalDiv());
	}
}
