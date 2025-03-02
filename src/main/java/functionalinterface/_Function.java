package functionalinterface;

import java.util.function.Function;

public class _Function {

    public static void main(String[] args) {

        System.out.println("\nImperative approach");
        int incrememt1 = incrementByOneFunction(1);
        System.out.println(incrememt1);

        System.out.println("\nDeclarative approach");
        int increment2 = incrementByOneFunction.apply(3);
        System.out.println(increment2);
        int multiply = multiplyBy10Function.apply(increment2);
        System.out.println(multiply);

        // chain function together
        int incrementAndMultiply = incrementByOneFunction.andThen(multiplyBy10Function).apply(3);
        System.out.println(incrementAndMultiply);
    }

    static int incrementByOneFunction(int number){
        return number+1;
    }

    static Function<Integer, Integer> incrementByOneFunction = number -> number+1;

    static Function<Integer, Integer> multiplyBy10Function = number -> number*10;



}