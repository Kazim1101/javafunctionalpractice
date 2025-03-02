package functionalinterface;

import java.util.function.Consumer;

public class _Consumer {

    public static void main(String[] args) {
        System.out.println("\nImperative approach");
        greetCustomer(new Customer("Maria", "999999"));

        System.out.println("\nDeclarative approach");
        greetCustomerByConsumer.accept(new Customer("Maria", "999999"));

    }

    static void greetCustomer(Customer customer){
        System.out.println(String.format("Hellow %s, thanks to register your number %s", customer.customerName, customer.customerNumber));
    }

    static Consumer<Customer> greetCustomerByConsumer = customer ->
            System.out.println(String.format("Hellow %s, thanks to register your number %s", customer.customerName, customer.customerNumber));


    static class Customer{
        private final String customerName;
        private final String customerNumber;

        public Customer(String customerName, String customerNumber) {
            this.customerName = customerName;
            this.customerNumber = customerNumber;
        }
    }
}
