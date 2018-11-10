package com.OtherRealization;



import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Cashier extends Thread {

    private BlockingQueue<Customer> customerQueue = new LinkedBlockingQueue<>();
    private Customer currentCustomer;
    private Lock lock = new ReentrantLock();

    public Cashier(String name) {
        super(name);
        //this.setDaemon(true);
        start();
    }

    public BlockingQueue<Customer> getCustomerQueue() {
        return customerQueue;
    }

    public  void addCustomer(Customer customer)  {
        try {
            customerQueue.put(customer);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public  boolean removeCustomer(Customer customer){
       return customerQueue.remove(customer);
    }

    @Override
    public void run() {
        while (true) {
            try {

                currentCustomer = customerQueue.take();
                System.out.println(this + " have start to serve " + currentCustomer);
                this.sleep(100 * currentCustomer.getNumberOfTasks());
                System.out.println( this.getName()+" served " +currentCustomer.getNumberOfTasks()+ " tasks of " + currentCustomer.getName() );
                currentCustomer.serve();
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
