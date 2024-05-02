package ch02_pjt_02;

import java.util.Scanner;
//DI
public class MainClass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MyCalculator calculator = new MyCalculator();

        while (true) {
            System.out.println("첫 번째 숫자를 입력하세요 (종료하려면 0을 입력):");
            int num1 = scanner.nextInt();
            if (num1 == 0) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }

            System.out.println("두 번째 숫자를 입력하세요:");
            int num2 = scanner.nextInt();

            System.out.println("수행할 연산을 선택하세요 (+, -, *, /):");
            String operation = scanner.next();
            ICalculator op;

            try {
                switch (operation) {
                    case "+":
                        op = new CalAdd();
                        break;
                    case "-":
                        op = new CalSub();
                        break;
                    case "*":
                        op = new CalMul();
                        break;
                    case "/":
                        op = new CalDiv();
                        break;
                    default:
                        System.out.println("잘못된 연산입니다. +, -, *, / 중 하나를 선택해주세요.");
                        continue;
                }

                calculator.calculate(num1, num2, op);
            } catch (ArithmeticException e) {
                System.out.println(e.getMessage());
            }
        }

        scanner.close();
    }
}
