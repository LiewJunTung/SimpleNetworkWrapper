package main.java.org.pandawarrior.okHttpWrapper

/**
 * Created by jtliew on 4/14/15.
 */

public class CustomerList {
    public ArrayList<Customer> customers;

    @Override
    public String toString() {
        return "CustomerList{" +
                "customers=" + customers +
                '}';
    }


    public class Customer{
        int reservationId
        String customerName

        @Override
        public String toString() {
            return "Customer{" +
                    "reservationId=" + reservationId +
                    ", customerName='" + customerName + '\'' +
                    '}';
        }
    }
}
