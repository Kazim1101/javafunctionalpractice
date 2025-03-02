package functionalinterface;

public class CustomFunctioalInterface {

    public static void main(String[] args) {
        ICustomFunctionalInterface multply = (a, b) -> a * b;
        System.out.println(multply.dmasOperationForTwoNumbers(5,6));
        ICustomFunctionalInterface subtract = (a, b) -> a - b;
        System.out.println(subtract.dmasOperationForTwoNumbers(5,7));

        // Also pass behavior on the fly as method parameter
        int result = doubleAnyNumber((a, b) -> a + b);
        System.out.println(result);

    }

    public static int doubleAnyNumber(ICustomFunctionalInterface add){
        return add.dmasOperationForTwoNumbers(2,4) * 2;
    }
}
