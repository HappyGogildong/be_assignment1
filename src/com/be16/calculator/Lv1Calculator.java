package com.be16.calculator;
import java.util.Scanner;


public class Lv1Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true){
            int num1 = sc.nextInt();
            int num2 = sc.nextInt();
            char oper = sc.next().charAt(0);

            try {
                if (oper == '+') {
                    System.out.println(num1 + num2);
                } else if (oper == '-') {
                    System.out.println(num1 - num2);
                } else if (oper == '*') {
                    System.out.println(num1 * num2);
                } else {
                    if (num2 == 0) {
                        throw new ArithmeticException();
                    } else System.out.println(num1 / num2);
                }
            } catch (ArithmeticException e) {
                System.out.println("0으로 나눌 수 없습니다. 다시 입력해주세요.");
            }

            System.out.println("더 계산하려면 아무 키나 입력 후 엔터, 종료를 원하면 exit 입력"); // exit 물어보기
            String exitString = sc.next();
            if(exitString.equals("exit")) break;
        }
    }
}
