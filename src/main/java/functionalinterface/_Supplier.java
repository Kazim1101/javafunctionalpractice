package functionalinterface;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class _Supplier {

    public static void main(String[] args) {

        System.out.println("\nImperative approach");
        System.out.println(getConnectionUrl());

        System.out.println("\nDeclarative approach");
        System.out.println(getConnectionUrlSupplier.get());
        getListOfUsers.get().stream()
                .filter(n -> n.name.equals("Goku"))
                .collect(Collectors.toList())
                .forEach(System.out::println);

    }

    static String getConnectionUrl(){
        return "jdbc://localhost:5432/test";
    }

    static Supplier<String> getConnectionUrlSupplier = () ->
            "jdbc://localhost:5432/test";

    static Supplier<List<User>> getListOfUsers = () ->
            List.of(new User("Kazim"),
                    new User("John"),
                    new User("Goku"),
                    new User("Goku"));

    static class User{
        private final String name;

        User(String name){
            this.name = name;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }
}


