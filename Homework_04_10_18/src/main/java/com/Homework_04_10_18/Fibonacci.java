package com.Homework_04_10_18;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*I don't really know what to fix here, so i'll just leave a comment here ;) */

public class Fibonacci {
    private static final int ONE_HUNDRED_PERCENT = 100;
    private int currentFib;
    private int nextFib;

    private List<Number> fibs;
    private Number fib(){
        nextFib = nextFib + currentFib;
        currentFib = nextFib - currentFib;
        return new Number(currentFib);
    }
    public Fibonacci() {
        fibs = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter size of set(N):");
        int sizeOfSet = scanner.nextInt();
        if(sizeOfSet < 1){
            throw new IllegalArgumentException();
        }
        init(sizeOfSet);
    }
    private  void init(int sizeOfSet) {
        nextFib =0;
        currentFib =1;
        for (int i = 0; i < sizeOfSet; i++) {
            fibs.add(fib());
        }
    }
    public void printMaxOddAndEvenFib() {
        for(int i = fibs.size() - 1; i >= 0; --i){
            if(fibs.get(i).isEven()) {
                System.out.println("The biggest even fibonacci number:"+ fibs.get(i).getValue());
                break;
            }
        }
        for(int i=fibs.size()-1; i>=0; --i){
            if(!fibs.get(i).isEven()){
                System.out.println("The biggest odd fibonacci number:"+ fibs.get(i).getValue());
                break;
            }
        }
    }
    public void printPercentageOfOddAndEven(){
        int numOfOdd = 0, numOfEven = 0;
        for(Number i:fibs){
            if(i.isEven()){
                numOfEven++;
            }
            else {
                numOfOdd++;
            }
        }
        double oddPercentage = (double)numOfOdd/fibs.size()*ONE_HUNDRED_PERCENT;
        double evenPercentage = (double)numOfEven/fibs.size()*ONE_HUNDRED_PERCENT;
        System.out.println("Percentage of even:"+evenPercentage);
        System.out.println("Percentage of odd:"+oddPercentage);
    }

}

