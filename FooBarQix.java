import java.util.HashMap;
import java.util.Map;

public class FooBarQix {

    public static String compute(String input) {
        StringBuilder result = new StringBuilder();
        int number = Integer.parseInt(input);

        // Check divisibility
        checkDivisibility(number, result);

        // Check occurences of 3/5/7 and handling 0
        verifyOccurences(input, result);
		
	// If nothing was appended in result, return the input with * for 0
        return result.length() > 0 ? result.toString() : input.replace('0', '*');

    }

    // Method to check the divisibility by 3, 5, 7
    private static void checkDivisibility(int number, StringBuilder result) {
        Map<Integer, String> multiplesMap = new HashMap<>();
        multiplesMap.put(3, "Foo");
        multiplesMap.put(5, "Bar");
        multiplesMap.put(7, "Qix");

        for (Map.Entry<Integer, String> entry : multiplesMap.entrySet()) {
            if (number % entry.getKey() == 0) {
                result.append(entry.getValue());
            }
        }
    }

   // Method to verify occurrences of 3, 5, 7 and handle 0
    private static void verifyOccurences(String input, StringBuilder result) {
        for (char digit : input.toCharArray()) {
            switch (digit) {
                case '3':
                    result.append("Foo");
                    break;
                case '5':
                    result.append("Bar");
                    break;
                case '7':
                    result.append("Qix");
                    break;
                case '0':
                    result.append("*");
                    break;
                default:
                    break;
            }
        }
    }
	
	public static void main(String[] args) {
        // Some test cases
        System.out.println(compute("3"));    // FooFoo
        System.out.println(compute("105"));  // FooBarQix*Bar
        System.out.println(compute("10101"));// FooQix**
    }

	
}