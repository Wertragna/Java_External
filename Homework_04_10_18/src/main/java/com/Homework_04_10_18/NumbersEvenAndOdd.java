package com.Homework_04_10_18;
import java.util.ArrayList;
import java.util.List;


public class NumbersEvenAndOdd {
    private static List<Integer> numbers;
    private static void fill(Interval interval){
        numbers = new ArrayList<>();
        for( int j = interval.getStart(); j <= interval.getEnd(); j++){
            numbers.add(j);
        }
    }
    static int  sumEvenNumbers(Interval interval) {
        fill(interval);
        int sum = 0;
        for(Integer i:numbers){
            if(Number.isEven(i)){
                sum+=i;
            }
        }
        return sum;
    }
    static int  sumOddNumbers(Interval interval) {
        fill(interval);
        int sumOdd = 0;
        for(Integer i: numbers) {
            if(!Number.isEven(i)) {
                sumOdd += i;
            }
        }
        return sumOdd;
    }
    public static void printSumOddAndEvenNumbers(Interval interval) {
        fill(interval);
        System.out.print("\nOdd sum:"+sumOddNumbers(interval));
        System.out.print("\nEven sum:"+sumEvenNumbers(interval));
    }
    public static void printEvenFromStart(Interval interval){
        fill(interval);
        System.out.println("\nEven numbers:");
        for(int i=numbers.size() - 1; i >= 0; --i) {
            if(Number.isEven(i)){
                System.out.print(numbers.get(i)+" ");
            }
        }
    }
    public static void printOddFromEnd(Interval interval) {
        fill(interval);
        System.out.println("\nOdd numbers:");
        for(Integer i: numbers) {
            if(!Number.isEven(i)) {
                System.out.print(numbers.get(i)+ " ");
            }
        }
    }

}
