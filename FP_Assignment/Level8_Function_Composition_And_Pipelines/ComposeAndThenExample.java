package FP_Assignment.Level8_Function_Composition_And_Pipelines;

import java.util.function.Function;

/*
 * Implement compose() and andThen() examples using Function<T, R>.
 */

public class ComposeAndThenExample {

    public static void main(String[] args) {
        Function<Integer, Integer> increment = x -> x + 1;
        Function<Integer, Integer> square = x -> x * x;

        // Using andThen: increment then square
        Function<Integer, Integer> andThenFunction = increment.andThen(square);
        System.out.println("andThen: " + andThenFunction.apply(3)); // Output: 16

        // Using compose: square then increment
        Function<Integer, Integer> composeFunction = square.compose(increment);
        System.out.println("compose: " + composeFunction.apply(3)); // Output: 10
    }
}