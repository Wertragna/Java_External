package com.OtherRealization;



import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Cashier extends Thread {

    private BlockingQueue<Customer> customerQueue = new LinkedBlockingQueue<>();
    Customer currentCustomer;

    public Cashier(String name) {
        super(name);
        this.setDaemon(true);
        start();
    }

    public BlockingQueue<Customer> getCustomerQueue() {
        return customerQueue;
    }

    public  void addCustomer(Customer customer) throws InterruptedException {
        customerQueue.put(customer);
    }

    public  void removeCustomer(Customer customer){
        customerQueue.remove(customer);
    }

    @Override
    public void run() {
        while (true) {
            try {
                currentCustomer = customerQueue.peek();
                System.out.println(this + " have start to serve " + currentCustomer);
                currentCustomer.serve();
                Thread.sleep(100 * currentCustomer.getNumberOfTasks());
                System.out.println( this.getName()+" served " +currentCustomer.getNumberOfTasks()+ " tasks of " + currentCustomer.getName() );
                customerQueue.poll();
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
