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
            } else if (digit == '0') {
                // Step 2: Replace 0 with *
                result.append("*");
            }
        }
		
		// If nothing was appended in result, return the input with * for 0
        return result.length() > 0 ? result.toString() : input.replace('0', '*');

    }
	
	public static void main(String[] args) {
        // Test cases
        System.out.println(compute("1"));    // 1
        System.out.println(compute("2"));    // 2
        System.out.println(compute("3"));    // FooFoo
        System.out.println(compute("4"));    // 4
        System.out.println(compute("5"));    // BarBar
        System.out.println(compute("6"));    // Foo
        System.out.println(compute("7"));    // QixQix
        System.out.println(compute("8"));    // 8
        System.out.println(compute("9"));    // Foo
        System.out.println(compute("10"));   // Bar
        System.out.println(compute("13"));   // Foo
        System.out.println(compute("15"));   // FooBarBar
        System.out.println(compute("21"));   // FooQix
        System.out.println(compute("33"));   // FooFooFoo
        System.out.println(compute("51"));   // FooBar
        System.out.println(compute("53"));   // BarFoo
        System.out.println(compute("101"));  // 1*1
        System.out.println(compute("303"));  // FooFoo*Foo
        System.out.println(compute("105"));  // FooBarQix*Bar
        System.out.println(compute("10101"));// FooQix**
    }

	
}