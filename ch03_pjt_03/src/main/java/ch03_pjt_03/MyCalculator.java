package ch03_pjt_03;

// 계산기 클래스
public class MyCalculator {
    // 기본 생성자
    //public MyCalculator() {}

    // 숫자 두 개와 계산기 객체를 받아서 연산을 수행하고 결과를 출력하는 메서드
    public void calculate(int fNum, int sNum, ICalculator calculator) {
        int value = calculator.doOperation(fNum, sNum);
        System.out.println("result : " + value);
    }
}