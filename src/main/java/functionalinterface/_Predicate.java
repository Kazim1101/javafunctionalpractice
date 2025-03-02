package functionalinterface;

import java.util.function.Predicate;

public class _Predicate {

    public static void main(String[] args) {
        System.out.println("\nImperative approach");
        System.out.println(isPhoneNumberIsValid("01723467541"));

        System.out.println("\nDeclarative approach");
        System.out.println(isPhoneNumberValidPred.test("01723467541"));

        System.out.println("Chaining in Predicate");
        System.out.println(isPhoneNumberValidPred.or(isPhoneNumberContain03Pred).test("01723467541"));
        System.out.println(isPhoneNumberValidPred.and(isPhoneNumberContain03Pred).test("01703467541"));
        System.out.println(isPhoneNumberValidPred.and(isPhoneNumberContain03Pred).test("01723467541"));

    }

    static boolean isPhoneNumberIsValid(String number){
        return number.startsWith("017") && number.length() == 11;
    }

    static Predicate<String> isPhoneNumberValidPred = number ->
            number.startsWith("017") && number.length() == 11;

    static Predicate<String> isPhoneNumberContain03Pred = number ->
            number.contains("03");


}
