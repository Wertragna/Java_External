package com.Homework_04_10_18;

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
        new Interval(start, end);
    }
    public Interval(int start, int end) {
        if (end < start) {
            throw new IllegalArgumentException();
        }
        this.end=end;
        this.start= start;
    }
    public int getStart() {
        return start;
    }
    public int getEnd() {
        return end;
    }

}

