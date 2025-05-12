package FP_Assignment.Level8_Function_Composition_And_Pipelines;

import java.util.List;
import java.util.function.Function;

public class Main {

    public static void main(String[] args) {
        // String Pipeline Example
        System.out.println("String Pipeline Example:");
        Function<String, String> stringPipeline = StringPipeline.createPipeline();
        String input = "  Hello, World!  ";
        String processedString = stringPipeline.apply(input);
        System.out.println("Original: " + input);
        System.out.println("Processed: " + processedString);
        System.out.println();

        // Function Composition Example
        System.out.println("Function Composition Example:");
        Function<String, Integer> stringParser = Integer::parseInt;
        Function<Integer, Integer> doubler = i -> i * 2;
        Function<String, Integer> composedFunction = stringParser.andThen(doubler);
        String numberString = "123";
        Integer doubledValue = composedFunction.apply(numberString);
        System.out.println("Original String: " + numberString);
        System.out.println("Composed Result: " + doubledValue);
        System.out.println();

        // Generic List Mapper Example
        System.out.println("Generic List Mapper Example:");
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        Function<Integer, String> toString = Object::toString;
        List<String> stringNumbers = GenericListMapper.mapList(numbers, toString);
        System.out.println("Original Numbers: " + numbers);
        System.out.println("String Numbers: " + stringNumbers);
        System.out.println();

        // Compose and Then Example
        System.out.println("Compose and Then Example:");
        Function<Integer, Integer> increment = x -> x + 1;
        Function<Integer, Integer> square = x -> x * x;
        Function<Integer, Integer> andThenFunction = increment.andThen(square);
        System.out.println("andThen: " + andThenFunction.apply(3));
        Function<Integer, Integer> composeFunction = square.compose(increment);
        System.out.println("compose: " + composeFunction.apply(3));
    }
}