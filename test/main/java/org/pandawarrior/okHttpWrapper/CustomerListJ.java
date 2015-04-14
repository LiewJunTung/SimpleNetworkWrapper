package main.java.org.pandawarrior.okHttpWrapper;

import java.util.ArrayList;

/**
 * Created by jtliew on 4/14/15.
 */
public class CustomerListJ {
    private ArrayList<Customer> customers;

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(ArrayList<Customer> customers) {
        this.customers = customers;
    }

    public class Customer{
        private int customerId;
        private int customerAge;
        private String customerName;

        public int getCustomerId() {
            return customerId;
        }

        public void setCustomerId(int customerId) {
            this.customerId = customerId;
        }

        public int getCustomerAge() {
            return customerAge;
        }

        public void setCustomerAge(int customerAge) {
            this.customerAge = customerAge;
        }

        public String getCustomerName() {
            return customerName;
        }

        public void setCustomerName(String customerName) {
            this.customerName = customerName;
        }
    }
}
