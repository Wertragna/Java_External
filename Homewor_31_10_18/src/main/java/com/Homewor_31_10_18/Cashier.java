package com.Homewor_31_10_18;

import java.util.LinkedList;
import java.util.Queue;

public class Cashier extends Thread {

    private volatile LinkedList<Customer> customerQueue = new LinkedList<>();
    volatile Customer currentCustomer;

    public Cashier(String name) {
        super(name);
        this.setDaemon(true);
        start();
    }

    public LinkedList<Customer> getCustomerQueue() {
        return customerQueue;
    }

    public synchronized void addCustomer(Customer customer){
        customerQueue.addLast(customer);
        this.notify();
    }

    public  void removeCustomer(Customer customer){
        synchronized ( customer) {
            customerQueue.remove(customer);
       }
    }

    @Override
    public void run() {
        while (true) {
            try {
                synchronized (this) {
                    while (customerQueue.size() == 0) {
                        wait();
                    }
                }
                synchronized ( customerQueue.peek()) {
                    currentCustomer = customerQueue.peek();
                    System.out.println(this + " have start to serve " + currentCustomer);
                    currentCustomer.serve();
                    Thread.sleep(100 * currentCustomer.getTaskQty());
                    System.out.println( this.getName()+" served " +currentCustomer.getTaskQty()+ " tasks of " + currentCustomer.getName() );
                    customerQueue.pop();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String toString() {
        return getName();
    }
}
