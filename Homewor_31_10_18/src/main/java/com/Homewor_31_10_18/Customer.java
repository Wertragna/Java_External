package com.Homewor_31_10_18;

import java.util.List;

public class Customer extends Thread {

    volatile List<Cashier> cashiers;
    int taskQty;
    Cashier currentCashier;
    volatile boolean isServed;

    public Customer(String name, List<Cashier> cashiers, int taskQty) {
        super(name);
        this.cashiers = cashiers;
        this.taskQty = taskQty;
        isServed = false;
        start();
    }

    public int getTaskQty() {
        return taskQty;
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
        for (int i = 0; i < cashiers.size(); i++) {
            int currentQueueLength = cashiers.get(i).getCustomerQueue().size();
            if (currentQueueLength == 0) {
                return cashiers.get(i);
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return getName();
    }
}
