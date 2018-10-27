package com.Homework_22_10_18;

import java.util.ArrayList;

public class PostfixCalc {
    private MyStack stack;
    private ArrayList<String> reversePolishNotation;

    public PostfixCalc(ArrayList<String> reversePolishNotation) {
        this.reversePolishNotation = reversePolishNotation;
    }

    public double parse(){
        stack = new MyStack();
        double leftOperand, rightOperand, answer;
        try {
            for(String current: reversePolishNotation){
                if(isNumber(current))
                    stack.push(current);
                else if(Lexer.isMathFunction(current)){
                    answer = getMathFunctionValue(stack.pop(), current);
                    stack.push(Double.toString(answer));
                }
                else{
                    rightOperand = Double.parseDouble(stack.pop());
                    leftOperand = Double.parseDouble(stack.pop());
                    switch (current){
                        case "+":
                            answer = leftOperand + rightOperand;
                            break;
                        case "-":
                            answer = leftOperand - rightOperand;
                            break;
                        case "*":
                            answer = leftOperand * rightOperand;
                            break;
                        case "/":
                            checkDividor(rightOperand);
                            answer = leftOperand / rightOperand;
                            break;
                        case "^":
                            checkDividor(rightOperand);
                            answer = Math.pow(leftOperand, rightOperand);
                            break;
                        default:
                            answer = 0;
                    }
                    stack.push(Double.toString(answer));
                }
            }
        } catch (NumberFormatException e) {
        } catch (ArithmeticException exc){
        }
        answer = Double.parseDouble(stack.pop());
        return answer;
    }



    void checkDividor(double d){
        final double EPS = 0.00000001;
        if(Math.abs(d)<EPS) throw new ArithmeticException();
    }



    double getMathFunctionValue(String argument, String operation){
        if(operation.equals("sin"))
            return Math.sin(Double.parseDouble(argument));
        else throw new RuntimeException("This operation is not supported. Check allowed operations list for details");

    }



    boolean isNumber(String s){
        try {
            Double.parseDouble(s);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;

    }
}
