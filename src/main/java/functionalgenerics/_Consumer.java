package functionalgenerics;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

public class _Consumer {

    public static void main(String[] args) {

        Consumer consumer = s -> {
            System.out.println("process started for :" + s);
        };

        System.out.println(printOnlyValidProcesses(List.of("Kazim", "Kaleem", ""), consumer));

        // Object method referencing in Consumer
        Student s1 = new Student();
        Consumer consumer1 = s1::displayAuthor;
        consumer1.accept("Kazim is the Author");

    }

    public static <T> boolean printOnlyValidProcesses(List<T> list, Consumer consumer){

        list.stream()
                .forEach(consumer);
        return false;
    }

    static class Student{

        public void displayAuthor(Object name){
            System.out.println(name);
        }
    }

}

