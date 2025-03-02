package funactionalexamples;

import java.util.Optional;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PracticeFuncational {

    public static void main(String[] args) {

        //M1 Using streams and Function
        System.out.println(duplicateCharM1('c', 10));
        //M2 Using BiFunction
        System.out.println(duplicateCharM2.apply('c', 10).get());

        //M1 Using Function also regex
        System.out.println(removePrefixCharsM1.apply("00012345", '0'));
        //M2 Using streams, Function no regex
        System.out.println(removePrefixCharsM2("00012345", '0'));

        System.out.println("sum of even number : " + sumOfEvenNumbers(100));


    }

    static BiFunction<Character, Integer, Optional<String>> duplicateCharM2 = (alphabet, lenght) ->
            Optional.of(String.valueOf(alphabet).repeat(lenght));

    private static String duplicateCharM1(final char alphabet, final int lenght) {
        return Stream.of(alphabet)
                .map((i) -> String.valueOf(i).repeat(lenght))
                .collect(Collectors.joining());
    }

    static BiFunction<String, Character, String> removePrefixCharsM1 = (phoneNumber, prefix) ->
            phoneNumber.stripLeading().replaceFirst("^x+".replace('x', prefix), "");


    private static String removePrefixCharsM2(final String phoneNumber, final char prefix) {
        return Stream.of(phoneNumber)
                .flatMapToInt(String::chars)
                .dropWhile(c -> c == prefix)
                .mapToObj(c -> String.valueOf((char) c))
                .collect(Collectors.joining());
    }

    private static int sumOfEvenNumbers(final int num){
       return IntStream.range(0, num)
                .filter(i -> i % 2 == 0 )
                .reduce((x,y) -> x + y)
                .getAsInt();
    }

}
