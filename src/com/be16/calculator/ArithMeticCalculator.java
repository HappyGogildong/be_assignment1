package com.be16.calculator;
import java.util.*;
import java.util.stream.Collectors;

enum Operator{
    SUM("+"), SUB("-"), MUL("*"), DIV("/");

    private final String symbol;

    Operator(String symbol){
        this.symbol = symbol;
    }

    public String getSymbol(){
        return symbol;
    }
}

public class ArithMeticCalculator<T extends Number>{
    private List<Double> list = new ArrayList<>();
    //enum에서 연산기호에 맞는 값 가져오기
    public Operator getOperator(String operator) {
        return switch (operator) {
            case "+" -> Operator.SUM;
            case "-" -> Operator.SUB;
            case "*" -> Operator.MUL;
            case "/" -> Operator.DIV;
            default -> throw new IllegalArgumentException("잘못된 연산기호: " + operator);
        };
    }

    //연산기호에 맞게 계산
    private void sum(T a, T b){list.add((a.doubleValue() + b.doubleValue()));}
    private void sub(T a, T b){list.add((a.doubleValue() - b.doubleValue()));}
    private void mul(T a, T b){list.add((a.doubleValue() * b.doubleValue()));}
    private void div(T a, T b){
        if(b.doubleValue() == 0.0){
            System.out.println("0으로 나눌 수 없습니다");
            return;
        }
        list.add((a.doubleValue() / b.doubleValue()));
    }

    //적절한 계산 고르기
    public void calculate(T a, T b, String operator){
        switch(getOperator(operator)){
            case SUM -> sum(a, b);
            case SUB -> sub(a, b);
            case MUL -> mul(a, b);
            case DIV -> div(a, b);
        }
    }

    //람다, 스트림으로 입력값과 크기 비교
    public void compare(T a){
        List<Double> comparisonResult = list.stream().filter(value -> value > a.doubleValue()).collect(Collectors.toList());
        for (Double value : comparisonResult) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
    //리스트 비우기
    public void flush(){
        list.clear();
    }
    //모든 결과 확인하기
    public void viewAll(){
        for(Double value : list){
            System.out.print(value + " ");
        }
        System.out.println();
    }
}