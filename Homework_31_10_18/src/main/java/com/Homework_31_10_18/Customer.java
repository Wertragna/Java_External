package com.Homework_31_10_18;

import java.util.List;

public class Customer extends Thread {

    volatile List<Cashier> cashiers;
    int numberOfTasks;
    Cashier currentCashier;
    volatile boolean isServed;

    public Customer(String name, List<Cashier> cashiers, int numberOfTasks) {
        super(name);
        this.cashiers = cashiers;
        this.numberOfTasks = numberOfTasks;
        isServed = false;
        start();
    }

    public int getNumberOfTasks() {
        return numberOfTasks;
    }


    public void serve() {
        this.isServed = true;
    }

    @Override
    public void run() {
        currentCashier = findShortestQueue();
        currentCashier.addCustomer(this);
        while (!isServed){
                if (this != currentCashier.getCustomerQueue().peek()) {
                    synchronized (this){
                        Cashier oldCashier = currentCashier;
                        Cashier bufferCashier = findFreeQueue();
                        if (bufferCashier != null) {
                            currentCashier = bufferCashier;
                            oldCashier.removeCustomer(this);
                            currentCashier.addCustomer(this);
                        }
                    }
                }
            }
        }

    private  Cashier  findShortestQueue() {
        Cashier cashier = cashiers.get(1);
        int shortestQueueLength = Integer.MAX_VALUE;
        for (Cashier c:cashiers) {
            int currentQueueLength = c.getCustomerQueue().size();
            if (currentQueueLength == 0) {
                return c;
            }
            else {
                if (currentQueueLength < shortestQueueLength) {
                    cashier =c;
                    shortestQueueLength = currentQueueLength;
                }
            }
        }
        return  cashier;
    }
    private Cashier findFreeQueue () {
        for (Cashier c: cashiers) {
            int currentQueueLength = c.getCustomerQueue().size();
            if (currentQueueLength == 0) {
                return c;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return getName();
    }
}
