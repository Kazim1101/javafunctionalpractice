package functionalinterface;

import java.util.function.BiPredicate;

public class _BiPredicate {

    public static void main(String[] args) {
        System.out.println("\nImperative approach");
        System.out.println(isPhoneNumberIsValid("01723467541", 11));

        System.out.println("\nDeclarative approach");
        System.out.println(isPhoneNumberValidPred.test("01723467541", 11));

        System.out.println("Chaining in Predicate");
        System.out.println(isPhoneNumberValidPred.or(isPhoneNumberContain03Pred).test("01723467541", 11));
        System.out.println(isPhoneNumberValidPred.and(isPhoneNumberContain03Pred).test("01703467541", 11));
        System.out.println(isPhoneNumberValidPred.and(isPhoneNumberContain03Pred).test("01723467541", 11));


    }

    static boolean isPhoneNumberIsValid(String number, Integer lenght){
        return number.startsWith("017") && number.length() == lenght;
    }

    static BiPredicate<String, Integer> isPhoneNumberValidPred = (number, lenght) ->
            number.startsWith("017") && number.length() == 11;

    static BiPredicate<String, Integer> isPhoneNumberContain03Pred = (number, lenght) ->
            number.contains("03");


}
