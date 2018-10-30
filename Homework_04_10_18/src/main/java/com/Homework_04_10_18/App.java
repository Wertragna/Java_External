package com.Homework_04_10_18;

/**
 * Hello Fibonacci!
 *
 */
public final class App {
    private App() {
    }
    public static void main(String[] args) {
        try {
            Interval interval = new Interval();

            NumbersEvenAndOdd.printOddFromEnd(interval);
            NumbersEvenAndOdd.printEvenFromStart(interval);
            NumbersEvenAndOdd.printSumOddAndEvenNumbers(interval);
            Fibonacci.printMaxOddAndEvenFib(6);
            Fibonacci.printMaxOddAndEvenFib(6);
        }
        catch (Exception e){
            System.out.println("Exception");
        }
    }
}
