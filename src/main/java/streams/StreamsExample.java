package streams;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
public class StreamsExample {

    public static void main(String[] args) {
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5); // Stream from values
        Stream<String> emptyStream = Stream.empty(); // Empty stream
        Stream<Integer> arrayStream = Arrays.stream(new Integer[]{1, 2, 3}); // From array
        Stream<String> listStream = List.of("A", "B", "C").stream(); // From List
;
        List<String> lowerCase = listStream.map(String::toLowerCase).collect(Collectors.toList());
        lowerCase.forEach(log::info);

        // TODO:Read more about parallelStream
//        Stream<String> parallelStream = list.parallelStream(); // Parallel processing


        // Note: Filter and transform Employee data
        List<Employee> employees = List.of(
                new Employee(1, "GINA", 34000, "IT"),
                new Employee(2, "WAD", 12000, "HR"),
                new Employee(3, "John", 30000, "Finance"),
                new Employee(4, "Goku", 60000, "IT")
        );

        Map<Integer, String> filteredEmployees = employees.stream()
                .filter(e -> e.salary > 50000)
                .collect(Collectors.toMap(Employee::getId, Employee::getName));

        filteredEmployees.forEach((id, name) -> log.info("Employee id: {}, name: {}", id, name));

        // Note: Group and Counts words form sentence
        String sentence = "java streams are powerful and streams are useful";
        Map<String, Long> wordCount = Arrays.stream(sentence.split(" "))
                .collect(Collectors.groupingBy(String::toLowerCase, Collectors.counting()));

        wordCount.forEach((word, count) -> log.info("Word: {}, Count: {}", word, count));

        // Note: Sort and limit Employees based on there salary in descending order
        List<Employee> sortedEmployees = employees.stream()
                .sorted((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()))
                .limit(3)
                .collect(Collectors.toList());

        sortedEmployees.forEach(employee -> log.info("Employee: {}", employee));


        // Note: find duplicates in a list
        List<Integer> numbers = Arrays.asList(3, 5, 7, 3, 5, 9, 11, 9);

        List<Integer> duplicateNumbers = numbers.stream()
                .filter(number -> numbers.stream().filter(n -> n.equals(number)).count() > 1)
                .distinct()
                .collect(Collectors.toList());

        duplicateNumbers.forEach(number -> log.info("Distinct Number: {}", number));


        List<List<Integer>> listOfLists = Arrays.asList(
                Arrays.asList(3, 8, 1),
                Arrays.asList(9, 2, 4),
                Arrays.asList(6, 5, 7)
        );

        List<Integer> flatList = listOfLists.stream()
                .flatMap(l -> l.stream())
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());

        log.info("Flat List: {}", flatList);

        flatList.stream()
                .min(Integer::compareTo)
                .ifPresent(min -> log.info("Min: {}", min));


        List<Order> orders = List.of(
                new Order(1, List.of(new Item("Laptop", 1000), new Item("Mouse", 20))),
                new Order(2, List.of(new Item("Monitor", 300), new Item("Keyboard", 50))),
                new Order(3, List.of(new Item("Headphones", 100), new Item("Mouse", 20)))
        );

        double totalPriceOfItems = orders.stream()
                .flatMap(order -> order.getItems().stream())
                .mapToDouble(Item::getPrice)
                .sum();
        log.info("Total Price of Items: {}", totalPriceOfItems);


        orders.stream()
                .flatMap(order -> order.getItems().stream())
                .sorted((i1, i2) -> Double.compare(i2.getPrice(), i1.getPrice()))
                .limit(3)
                .forEach(item -> log.info("Item name: {}, price: {}", item.name, item.price));


    }


    @Data
    static class Employee {
        private final int id;
        private final String name;
        private final double salary;
        private final String department;

    }

    @Data
    @AllArgsConstructor
    static class Order {
        private int orderId;
        private List<Item> items;
    }

    @Data
    @AllArgsConstructor
    static class Item {
        private String name;
        private double price;
    }
}
