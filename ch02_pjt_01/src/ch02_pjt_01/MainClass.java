package ch02_pjt_01;

import java.util.Scanner;

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

            switch (operation) {
                case "+":
                    calculator.calAdd(num1, num2);
                    break;
                case "-":
                    calculator.calSub(num1, num2);
                    break;
                case "*":
                    calculator.calMul(num1, num2);
                    break;
                case "/":
                    if (num2 == 0) {
                        System.out.println("0으로 나눌 수 없습니다.");
                    } else {
                        calculator.calDiv(num1, num2);
                    }
                    break;
                default:
                    System.out.println("잘못된 연산입니다. +, -, *, / 중 하나를 선택해주세요.");
                    break;
            }
        }

        scanner.close();
    }
}
