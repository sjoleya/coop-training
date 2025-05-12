package FP_Assignment.Level8_Function_Composition_And_Pipelines;

import java.util.function.Function;

/*
 * Compose two functions: one for string parsing (String -> Integer) 
 * and one for doubling the number (Integer -> Integer).
 */

public class FunctionComposition {

    public static void main(String[] args) {
        Function<String, Integer> stringParser = Integer::parseInt;
        Function<Integer, Integer> doubler = i -> i * 2;

        // Compose the functions
        Function<String, Integer> composedFunction = stringParser.andThen(doubler);

        String input = "123";
        Integer result = composedFunction.apply(input);
        System.out.println("Original String: " + input);
        System.out.println("Composed Result: " + result);
    }
}