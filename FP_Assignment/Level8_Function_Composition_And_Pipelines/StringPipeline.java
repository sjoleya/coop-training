package FP_Assignment.Level8_Function_Composition_And_Pipelines;

import java.util.function.Function;

/*
 * Build a reusable pipeline of 3 functions: trim, lowercase, and remove punctuation from strings.
 */

public class StringPipeline {

    public static Function<String, String> createPipeline() {
        Function<String, String> trim = String::trim;
        Function<String, String> lowercase = String::toLowerCase;
        Function<String, String> removePunctuation = s -> s.replaceAll("\\p{Punct}", "");

        return trim.andThen(lowercase).andThen(removePunctuation);
    }

    public static void main(String[] args) {
        Function<String, String> pipeline = createPipeline();
        String input = "  Hello, World!  ";
        String result = pipeline.apply(input);
        System.out.println("Original: " + input);
        System.out.println("Processed: " + result);
    }
}