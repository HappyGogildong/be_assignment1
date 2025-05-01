package com.be16.calculator;

import java.util.*;

class Calculator{
    private List<Integer> result = new ArrayList<>();

    public void calculate(int num1, int num2, char oper) {
        try {
            if (oper == '+') {
                result.add(num1 + num2);
            } else if (oper == '-') {
                result.add(num1 - num2);
            } else if (oper == '*') {
                result.add(num1 * num2);
            } else {
                if (num2 == 0) {
                    throw new ArithmeticException();
                } else result.add(num1 / num2);
            }
        } catch (ArithmeticException e) {
            System.out.println("0으로 나눌 수 없습니다. 다시 입력해주세요.");
        }
    }

    public int getResult(int idx){
        if(idx >= result.size()){
            System.out.println("유효한 범위가 아닙니다");
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

    public void delFirst(){
        if(result.isEmpty()){
            System.out.print("계산 결과가 아직 없습니다");
        }
        else result.remove(0);
    }
    public int size(){
        return result.size();
    }

}

public class Lv2App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calculator cal = new Calculator();

        while(true){
            int operand1 = sc.nextInt();
            int operand2 = sc.nextInt();
            char operator = sc.next().charAt(0);

            cal.calculate(operand1, operand2, operator); // 계산

            if(cal.size() == 0){ // 계산 식이 틀리거나, 분모가 0인 경우
                continue;
            }
            System.out.println(cal.getResult(0));
            cal.delFirst();

            System.out.println("더 계산하려면 아무 키나 입력 후 엔터, 종료를 원하면 exit 입력"); // exit 물어보기
            String exitString = sc.next();
            if(exitString.equals("exit")) break;
        }

    }
}
