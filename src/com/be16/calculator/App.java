package com.be16.calculator;

import java.util.*;

class Calculator{
    private List<Integer> result = new ArrayList<Integer>();

    public int calculate(int num1, int num2, char oper) {
        try {
            if (oper == '+') {
                result.add(num1 + num2);
                return num1 + num2;
            } else if (oper == '-') {
                result.add(num1 - num2);
                return num1 - num2;
            } else if (oper == '*') {
                result.add(num1 * num2);
                return num1 * num2;
            } else {
                if (num2 == 0) {
                    throw new ArithmeticException();
                } else result.add(num1 / num2);
                return num1 / num2;
            }
        } catch (ArithmeticException e) {
            System.out.println(e);
        }
        return 0;
    }

    public int getResult(int idx){
        if(idx >= result.size()){
            System.out.println("유효한 범위가 아닙니다");
            return 0;
        }
        return result.get(idx);
    }
    public void setResult(int idx, int res){
        if(idx >= result.size()){
            System.out.println("유효한 범위가 아닙니다");
            return;
        }
        result.set(idx, res);
    }

}

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calculator cal = new Calculator();

        while(true){
            int operand1 = sc.nextInt();
            int operand2 = sc.nextInt();
            String operatorOrExit = sc.next();
            if (operatorOrExit.equals("exit")) break;
            char operator = operatorOrExit.charAt(0);

            int result = cal.calculate(operand1, operand2, operator);
        }

    }
}
