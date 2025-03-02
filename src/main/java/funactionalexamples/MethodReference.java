package funactionalexamples;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class MethodReference {

    public static void main(String[] args) {

        Student student = new Student();
        // reference instance method of existing object
        Consumer<Object> consumer1 = student::displayAuthor;
        consumer1.accept("Kazim is the author");

        // reference instance method of existing object
        BiFunction <String, String, String> biFunction = Student::displayCoAuthors;
        System.out.println(biFunction.apply("Kazim", "Kaleem"));

        // reference static class method of existing object
        Supplier supplier1 = Math::random;
        System.out.println(supplier1.get());

        // reference instance method of arbitrary object
        Function<String, Integer> function = String::length;
        System.out.println(function.apply("Kazim"));



    }

    static class Student{

        public void displayAuthor(Object name){
            System.out.println(name);
        }

        public static String displayCoAuthors(String name1, String name2){
            return name1 + " : " + name2;
        }
    }
}
