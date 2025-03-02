package basics;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class Basic {

    public static void main(String[] args) {
        List<String> fruits = List.of("apple", "banan");

        for (String fruit : fruits) {
            try{
                System.out.println(fruit);
                errorGenerater();
            }catch (Exception e){
                continue;
            }

        }




        try {
            Student student1 = new Student();
            student1.setName("Ashir");

            errorGenerater();

            Student student2 = new Student();
            student2.setName("Ashir");

            System.out.println(student1 == student2);
            System.out.println(student1.equals(student2));
        } catch (NullPointerException e) {
            // Catch and handle NullPointerException
            System.err.println("Caught a NullPointerException: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            // Catch and handle IllegalArgumentException
            System.err.println("Caught an IllegalArgumentException: " + e.getMessage());
        } catch (RuntimeException e) {
            // Catch and handle any other runtime exceptions (if needed)
            System.err.println("Caught a generic RuntimeException: " + e.getMessage());
        }
        catch (Exception e) {
            // Catch and handle any other runtime exceptions (if needed)
            System.err.println("Caught a Exception: " + e.getMessage());
        }


    }


    public static void errorGenerater(){
        throw new IllegalArgumentException("Need to handle");
    }

    static class Student{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Student student)) return false;
            return getName().equals(student.getName());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getName());
        }
    }


}
