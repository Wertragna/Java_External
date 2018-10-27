package com.Homework_22_10_18;

import java.util.ArrayList;

public class Lexer {
    private int pos;
    private final String text;
    private char curentChar;
    private  ArrayList<String> ArrayOfToken;

    {
        pos=0;
        ArrayOfToken =new ArrayList<>();
    }

    public Lexer(String text) {
        this.text = text;
        if (text.length()!=0)
            curentChar = this.text.charAt(pos);

    }
    boolean Advance()
    {
        if (pos >= text.length() - 1){
            pos = text.length();
            return false;
        }
        else {
            pos++;
            curentChar = this.text.charAt(pos);
            return true;
        }
    }

    boolean isEnd(){
        return pos == text.length();
    }

    int SkipWhitespace() {
        int count=0;
        while (!isEnd()&&Character.isWhitespace(curentChar)) {
            Advance();
            count++;
        }
        return count;
    }

    String Integer() {
        StringBuilder temp = new StringBuilder();
        while (!isEnd()&&Character.isDigit(curentChar)) {
            temp.append(curentChar);
            Advance();
        }
        return temp.toString();
    }

    String Letter() {
        StringBuilder temp = new StringBuilder();
        while (!isEnd()&& Character.isLetter(curentChar)) {
            temp.append(curentChar);
            Advance();
        }
        return temp.toString();
    }

    String getNextToken()   {
        //тут повертаються значення
         while (!isEnd()) {
            if (Character.isWhitespace(curentChar)) {
                SkipWhitespace();
                continue;
            }
            if (Character.isDigit(curentChar)) {
                return Integer();
            }
            if ("()*+-^/".indexOf(curentChar)!=-1) {
                String temp=""+curentChar;
                Advance();
                return temp;
            }
            if (Character.isLetter(curentChar)) {
                String temp = Letter();
                System.out.println("s");
                if (isMathFunction(temp)){
                    return temp;
                }
                else {
                    throw new LexerException(pos + "InvalidCharacter");
                }
            }
            throw new LexerException(pos + "InvalidCharacter");
        }
        return "";
//        throw new LexerException("empty");
    }

    public ArrayList<String> getArrayOfToken(){
        if(ArrayOfToken.size()==0) {
            String nextToken =getNextToken();
            while (nextToken.length()!=0){
                ArrayOfToken.add(nextToken);
                nextToken =getNextToken();
            }
        }
        return ArrayOfToken;
    }
    static boolean isMathFunction(String s){
        return s.equals("sin") || s.equals("log");
    }

}
