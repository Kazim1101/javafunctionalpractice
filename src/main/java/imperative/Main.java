package imperative;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static imperative.Main.Person.Gender.FEMALE;
import static imperative.Main.Person.Gender.MALE;

public class Main {

    public static void main(String[] args) {
        List<Person> people= List.of(
                new Person("Kazim", MALE),
                new Person("John", MALE),
                new Person("Maria", FEMALE),
                new Person("Sarah", FEMALE),
                new Person("Alax", MALE)
        );


        System.out.println("\nImperative approach");
        List<Person> females= new ArrayList<>();
        for(Person person : people){
            if(FEMALE.equals(person.gender)){
                females.add(person);
            }
        }
        for(Person female : females){
            System.out.println(female);
        }

        System.out.println("\nDeclarative approach");
        List<Person> females2 = people.stream()
                .filter(p -> FEMALE.equals(p.gender))  // its takes predicate and return true/false
                .collect(Collectors.toList());
        females2.forEach(System.out::println);




    }


    public static class Person{
        private final String name;
        private final Gender gender;

        public Person(String name, Gender gender) {
            this.name = name;
            this.gender = gender;
        }

        enum Gender{
            MALE, FEMALE
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", gender=" + gender +
                    '}';
        }
    }

}
