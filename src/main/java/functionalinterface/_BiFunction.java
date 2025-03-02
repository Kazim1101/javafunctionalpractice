package functionalinterface;

import java.util.function.BiFunction;

public class _BiFunction {

    public static void main(String[] args) {
        System.out.println("\nImperative approach");
        System.out.println(incrementByOneAndMultiply(5, 100));
        System.out.println("\nDeclarative approach");
        System.out.println(incrementByOneAndMultiplyBiFunctional.apply(5, 100));
    }

    static int incrementByOneAndMultiply(int number, int multiplyBy){
        return (number + 1) * multiplyBy;
    }

    static BiFunction<Integer, Integer, Integer> incrementByOneAndMultiplyBiFunctional =
            (numberToIncrementByOne, numberToMultiplyBy) -> (numberToIncrementByOne + 1) * numberToMultiplyBy;
}
