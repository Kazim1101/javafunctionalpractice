package functionalinterface;

import java.util.function.BiConsumer;

public class _BiConsumer {

    public static void main(String[] args) {
        System.out.println("\nImperative approach");
        greetCustomer(new Customer("Maria", "999999"), false);

        System.out.println("\nDeclarative approach");
        greetCustomerByConsumer.accept(new Customer("Maria", "999999"), false);

    }

    static void greetCustomer(Customer customer, Boolean showNumber){
        System.out.println(
                String.format("Hellow %s, thanks to register your number %s"
                        , customer.customerName, showNumber ? customer.customerNumber : "****"));
    }

    static BiConsumer<Customer, Boolean> greetCustomerByConsumer = (customer, showNumber) ->
            System.out.println(String.format("Hellow %s, thanks to register your number %s"
                    , customer.customerName, showNumber ? customer.customerNumber : "****"));


    static class Customer{
        private final String customerName;
        private final String customerNumber;

        public Customer(String customerName, String customerNumber) {
            this.customerName = customerName;
            this.customerNumber = customerNumber;
        }
    }
}
