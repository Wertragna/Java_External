package com.OtherRealization;


import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) throws InterruptedException {
        List<Cashier> cashiers = new ArrayList<>();
        List<Customer> customers = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            cashiers.add(new Cashier("Cashier "+ i));
        }

        for (int i = 0; i < 10; i++) {
            customers.add(new Customer("Customer " + i, cashiers, 1 +  (int) (9 * Math.random())));
        }

        for (Customer customer : customers){
           customer.join();
       }

        System.out.println("All customers have been served");
    }
}
