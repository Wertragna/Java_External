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
            NumbersEvenAndOdd numbersEvenAndOdd = new NumbersEvenAndOdd(interval);
            numbersEvenAndOdd.printOddFromEnd();
            numbersEvenAndOdd.printEvenFromStart();
            numbersEvenAndOdd.printSumOddAndEvenNumbers();
            Fibonacci fibonacci = new Fibonacci();
            fibonacci.printMaxOddAndEvenFib();
            fibonacci.printPercentageOfOddAndEven();
        }
        catch (Exception e){
            System.out.println("Exception");
        }
    }
}
