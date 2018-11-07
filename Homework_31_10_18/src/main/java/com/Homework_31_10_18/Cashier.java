package com.Homework_31_10_18;

import java.util.LinkedList;

public class Cashier extends Thread {

    private  LinkedList<Customer> customerQueue = new LinkedList<>();
    private  Customer currentCustomer;

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

    public synchronized void removeCustomer(Customer customer){
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
                synchronized (customerQueue.peek()) {
                    currentCustomer = customerQueue.peek();
                    System.out.println(this + " have start to serve " + currentCustomer);
                    currentCustomer.serve();
                    Thread.sleep(100 * currentCustomer.getNumberOfTasks());
                    System.out.println( this.getName()+" served " +currentCustomer.getNumberOfTasks()+ " tasks of " + currentCustomer.getName() );
                    customerQueue.poll();
                }
            } catch (InterruptedException e) {
            }
        }
    }

    @Override
    public String toString() {
        return getName();
    }
}
