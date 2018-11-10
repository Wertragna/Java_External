package com.OtherRealization;


import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Customer extends Thread {

    private List<Cashier> cashiers;
    private int numberOfTasks;
    private Cashier currentCashier;
    public Lock lock = new ReentrantLock();
    private volatile boolean isServed;

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
        while (!isServed) {
            Cashier oldCashier = currentCashier;
            Cashier bufferCashier = findFreeQueue();
            if (bufferCashier != null) {
                if(oldCashier.removeCustomer(this)){
                    currentCashier = bufferCashier;
                    currentCashier.addCustomer(this);
                }
            }
        }
    }
    private  Cashier  findShortestQueue() {
        Cashier cashier = cashiers.get(0);
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
