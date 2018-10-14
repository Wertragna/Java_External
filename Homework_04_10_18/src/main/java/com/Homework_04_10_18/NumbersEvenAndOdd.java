package com.Homework_04_10_18;
import java.util.ArrayList;
import java.util.List;


public class NumbersEvenAndOdd {
    private List<Number> numbers;
    public NumbersEvenAndOdd(Interval interval){
        numbers = new ArrayList<>();
        for( int j = interval.getStart(); j <= interval.getEnd(); j++){
            numbers.add(new Number(j));
        }
    }
    private int sumEvenNumbers() {
        int sum = 0;
        for(Number i:numbers){
            if(i.isEven()){
                sum+=i.getValue();
            }
        }
        return sum;
    }
    private int sumOddNumbers() {
        int sumOdd = 0;
        for(Number i: numbers) {
            if(!i.isEven()) {
                sumOdd += i.getValue();
            }
        }
        return sumOdd;
    }
    public void printSumOddAndEvenNumbers() {
        System.out.print("\nOdd sum:"+sumOddNumbers());
        System.out.print("\nEven sum:"+sumEvenNumbers());
    }
    public void printEvenFromStart(){
        System.out.println("\nEven numbers:");
        for(int i=numbers.size() - 1; i >= 0; --i) {
            if(numbers.get(i).isEven()){
                System.out.print(numbers.get(i).getValue()+" ");
            }
        }
    }
    public void printOddFromEnd() {
        System.out.println("\nOdd numbers:");
        for(Number n: numbers) {
            if(!n.isEven()) {
                System.out.print(n.getValue()+" ");
            }
        }
    }

}
