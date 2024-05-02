package com.chuelgi.calculator;

import java.util.Stack;

public class Calculator {

    public double add(double a, double b){
        return a+ b;
    }
    public double sub(double a, double b){
        return a-b;
    }
    public double div(double a, double b){
        if(b == 0){
            throw new IllegalArgumentException("Cannot divide by 0");
        }
        return a/b;
    }
    public double mul(double a, double b){
        return a*b;
    }

    public double evaluateExpression(String expression){

        //split at operators
        String[] tokens = expression.split("\\s+");

        Stack<Double> operandStack = new Stack<>();
        Stack<String> operatorStack = new Stack<>();

        for(String token : tokens){
            if(isNumeric(token)){
                operandStack.push(Double.parseDouble(token));
            }
            else{
                operatorStack.push(token);
            }
        }
        double res = operandStack.pop();
        while(!operatorStack.isEmpty()){

            res = performOperation(operatorStack.pop(), res, operandStack.pop());
        }

        return res;

    }

    private boolean isNumeric(String str){
        try { Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e){
            return false;
        }
    }

    private double performOperation(String operator, double operand1, double operand2){
        switch (operator) {
            case "+":
                return add(operand1, operand2);
            case "-":
                return sub(operand1, operand2);
            case "*":
                return mul(operand1, operand2);
            case "/":
                if (operand2 != 0) {
                    return div(operand1, operand2);
                } else {
                    throw new ArithmeticException("Division by 0");
                }

            default:
                throw new IllegalArgumentException("Invalid operator");
        }

    }


}
