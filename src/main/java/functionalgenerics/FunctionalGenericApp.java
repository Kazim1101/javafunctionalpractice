package functionalgenerics;

public class FunctionalGenericApp {

    public static void main(String[] args) {

        /*
        Description: Below we are using the generic interface, With the help of this
        we don't need to create more interface incase the datatypes are changed
         */
        FunctionalGenericInterface<String ,String > fun1 = s -> s.substring(1,3);
        System.out.println(fun1.execute("Kazim"));

        FunctionalGenericInterface<String ,Integer > fun2 = s -> s.length();
        System.out.println(fun2.execute("Kazim"));
    }
}
