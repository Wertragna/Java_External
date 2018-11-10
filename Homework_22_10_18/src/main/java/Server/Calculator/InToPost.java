package Server.Calculator;



import java.util.ArrayList;

public class InToPost {
    private MyStack stack;
    private String input;
    private ArrayList<String> output;
    ArrayList<String> in;

    public InToPost(String input) {
        this.input = input;
        Lexer lexer = new Lexer(input);
        in = lexer.getArrayOfToken();
        stack = new MyStack();
        output = new ArrayList<>();
    }

    public ArrayList<String> doTrans() {
        for(String s: in){

            switch (s){
                case "+":
                case "-":
                    gotOperator(s, 1);
                    break;
                case "*":
                case "/":
                    gotOperator(s, 2);
                    break;
                case "sin":
                case "^":
                    gotOperator(s, 3);
                    break;
                case "(":
                    stack.push(s);
                    break;
                case ")":
                    gotClosingParentheses();
                    break;
                default:
                    output.add(s);
                    break;
            }
        }
        while(!stack.isEmpty()){

            output.add(stack.pop());

        }
        return output;
    }

    void gotOperator(String currentOp, int priority1) {
        while(!stack.isEmpty()){
            String operatorTop = stack.pop();
            if(operatorTop.equals("(")){
                stack.push(operatorTop);
                break;
            }else {
                int priority2;
                if(operatorTop.equals("+")||operatorTop.equals("-")){
                    priority2 = 1;
                } else if(operatorTop.equals("*")||operatorTop.equals("/"))
                    priority2 = 2;
                else priority2 = 3;
                if(priority2<priority1||currentOp.equals("^")&&priority2<=priority1){
                    stack.push(operatorTop);
                    break;
                }else {
                    output.add(operatorTop);
                }
            }
        }
        stack.push(currentOp);
    }
    void gotClosingParentheses() {
        if (!stack.isEmpty()){
            String top = stack.pop();
            if(top.equals("(")&&output.isEmpty()){
                throw new ArithmeticException("() in expression");
            }
            else if(top.equals("("))
                return;
            else
                output.add(top);
        }
        while (!stack.isEmpty()){
            String top = stack.pop();
            if(top.equals("("))
                break;
            else output.add(top);
        }
    }
}
