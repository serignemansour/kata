public class FooBarQix {

    public static String compute(String input) {
        StringBuilder result = new StringBuilder();
        int number = Integer.parseInt(input);

        // Step 1: Check divisibility
        if (number % 3 == 0) {
            result.append("Foo");
        }
        if (number % 5 == 0) {
            result.append("Bar");
        }
        if (number % 7 == 0) {
            result.append("Qix");
        }

        // Step 1: Process each digit and add Foo/Bar/Qix for 3/5/7
        for (char digit : input.toCharArray()) {
            if (digit == '3') {
                result.append("Foo");
            } else if (digit == '5') {
                result.append("Bar");
            } else if (digit == '7') {
                result.append("Qix");
            } 
        }
		
		result.toString();

    }

	

}