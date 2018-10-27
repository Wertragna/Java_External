package com.Homework_22_10_18;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        try {
            Scanner in = new Scanner(System.in);
            System.out.println("Введіть вираз");
            while (true) {
            String expresion = in.nextLine();
            Lexer lexer = new Lexer(expresion);
            InToPost inToPost = new InToPost(expresion);
            PostfixCalc postfixCalc = new PostfixCalc(inToPost.doTrans());
            System.out.println(postfixCalc.parse());
            }
        }
        catch (LexerException e) {
            System.out.println(e.getMessage());
        }

    }
}
