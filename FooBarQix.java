public class FooBarQix {

    public static String compute(String input) {
        StringBuilder result = new StringBuilder();
        int number = Integer.parseInt(input);

        if (number % 3 == 0) {
            result.append("Foo");
        }
        if (number % 5 == 0) {
            result.append("Bar");
        }
        if (number % 7 == 0) {
            result.append("Qix");
        }
		
		result.toString();

    }

}