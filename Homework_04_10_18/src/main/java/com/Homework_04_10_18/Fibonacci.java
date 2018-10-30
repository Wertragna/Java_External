package com.Homework_04_10_18;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Fibonacci {
    private static final int ONE_HUNDRED_PERCENT = 100;
    private static int currentFib;
    private static int nextFib;
    static {
        fibs = new ArrayList<>();
    }

    protected static List<Integer> fibs;
    private static Integer fib(){
        nextFib = nextFib + currentFib;
        currentFib = nextFib - currentFib;
        return Integer.valueOf(nextFib);
    }

    public static void fillOfConsole() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter size of set(N):");
        int sizeOfSet = scanner.nextInt();
        fill(sizeOfSet);
    }
    private static void fill(int N) {
        if(N < 1){
            throw new IllegalArgumentException();
        }
        fibs = new ArrayList<>();
        nextFib =0;
        currentFib =1;
        for (int i = 0; i < N; i++) {
            fibs.add(fib());
        }
    }

    public static int maxEven( int N){
        fill(N);
        for(int i = fibs.size() - 1; i >= 0; --i){
            if(Number.isEven(fibs.get(i))) {
                return fibs.get(i);
            }
        }
        return -1;
    }
    public  static int maxOdd(int N){
        fill(N);
        for(int i = fibs.size() - 1; i >= 0; --i){
            if(!Number.isEven(fibs.get(i))) {
                return fibs.get(i);
            }
        }
        return -1;
    }

    public static void printMaxOddAndEvenFib(int N) {
        fill(N);
        System.out.println("The biggest even fibonacci number:" + maxEven(N));
        System.out.println("The biggest odd fibonacci number:" + maxOdd(N));
    }
    public static double percentageOfEven(int N){
        fill(N);
        int numOfEven = 0;
        for(Integer i:fibs){
            if(Number.isEven(i)){
                numOfEven++;
            }
        }
        return (double)numOfEven/fibs.size()*ONE_HUNDRED_PERCENT;
    }

    public static void printPercentageOfOddAndEven(int N){
        double oddPercentage = percentageOfEven(N);
        double evenPercentage = ONE_HUNDRED_PERCENT-oddPercentage;
        System.out.println("Percentage of even:"+evenPercentage);
        System.out.println("Percentage of odd:"+oddPercentage);
    }

}

