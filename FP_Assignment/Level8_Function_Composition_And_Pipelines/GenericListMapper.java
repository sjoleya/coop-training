package FP_Assignment.Level8_Function_Composition_And_Pipelines;

import java.util.List;
import java.util.ArrayList;
import java.util.function.Function;

/*
 * Write a generic method that accepts a List<T> and a Function<T, R> 
 * and applies the function to all elements.
 */

public class GenericListMapper {

    public static <T, R> List<R> mapList(List<T> list, Function<T, R> function) {
        List<R> result = new ArrayList<>();
        for (T item : list) {
            result.add(function.apply(item));
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        Function<Integer, String> toString = Object::toString;

        List<String> stringNumbers = mapList(numbers, toString);
        System.out.println("Original Numbers: " + numbers);
        System.out.println("String Numbers: " + stringNumbers);
    }
}