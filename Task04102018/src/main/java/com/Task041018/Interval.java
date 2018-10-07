package com.Task041018;

import java.util.Scanner;

public class Interval {
    private int start;
    private int end;
    private int lenght;
    public Interval(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter start of the interval:");
        start = scanner.nextInt();
        System.out.println("Enter end of the interval:");
        end = scanner.nextInt();
        if (end<start){
            throw new IllegalArgumentException();
        }
        lenght = end- start+1;
    }
    public int getStart(){
        return start;
    }
    public int getEnd() {
        return end;
    }

    public int getLenght() {
        return lenght;
    }
}

