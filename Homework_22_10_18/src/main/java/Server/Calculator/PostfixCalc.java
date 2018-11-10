package Server.Calculator;

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
        for(String current: reversePolishNotation){
            if(isNumber(current))
                stack.push(current);
            else if(Lexer.isSin(current)){
                answer = Math.sin(Double.parseDouble(stack.pop()));
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
                        answer = leftOperand / rightOperand;
                        break;
                    case "^":
                        answer = Math.pow(leftOperand, rightOperand);
                        break;
                    default:
                        answer = 0;
                    }
                    stack.push(Double.toString(answer));
                }
            }
        answer = Double.parseDouble(stack.pop());
        if (Double.isNaN(answer)||Double.isInfinite(answer)){
            throw new ArithmeticException();
        }
        return answer;
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
