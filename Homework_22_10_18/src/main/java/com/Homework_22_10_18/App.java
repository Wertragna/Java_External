package com.Homework_22_10_18;

import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args ) {

        Scanner in = new Scanner(System.in);
        String expression = "yes";
        while (expression.equals("yes")) {
            System.out.println("Введіть вираз");
            try {
                expression = in.nextLine();
                InToPost inToPost = new InToPost(expression);
                PostfixCalc postfixCalc = new PostfixCalc(inToPost.doTrans());
                System.out.println(postfixCalc.parse());
            } catch (NumberFormatException
                    | ArithmeticException
                    | LexerException
                    | NoSuchElementException exc) {
                System.out.println("mistake in expression");
            }
            finally {
                System.out.println("Введіть \"yes\",якщо хочете продовжити роботу з калькулятором");
                expression=in.nextLine();

            }
        }
    }
}
