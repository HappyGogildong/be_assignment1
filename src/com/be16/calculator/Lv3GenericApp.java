package com.be16.calculator;
import java.util.*;

public class Lv3GenericApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArithMeticCalculator<Double> calc = new ArithMeticCalculator<>();
        //while 문 돌면서 입력받기
        //마지막에 exit 하면 반복문 종료하기
        //입력 validation 연산기호는 저기에서
        while(true){
            System.out.print("숫자 숫자 연산기호 입력 : ");
            double op1 = Double.parseDouble(sc.next());
            double op2 = Double.parseDouble(sc.next());
            String oper = sc.next();

            calc.calculate(op1, op2, oper);

            System.out.println("모든 결과 확인: 1  n보다 큰 결과 확인: 2  초기화: 3 나가기: exit  입력");

            String commnd = sc.next();
            if(commnd.equals("1")){
                calc.viewAll();
            }
            else if(commnd.equals("2")){
                double a = sc.nextDouble();
                sc.nextLine(); //enter 버퍼에서 빼기
                calc.compare(a);
            }
            else if(commnd.equals("3")){
                calc.flush();
            }
            else{
                break;
            }
        }
    }
}
