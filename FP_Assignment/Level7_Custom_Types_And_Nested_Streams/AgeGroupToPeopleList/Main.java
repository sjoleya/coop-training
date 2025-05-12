package FP_Assignment.Level7_Custom_Types_And_Nested_Streams.AgeGroupToPeopleList;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
 * Create a function that takes a list of people and returns a map of age group (<20, 20-40, 40+) → list of people.
 */

public class Main {

    public static void main(String[] args) {
        // Sample data
        Person person1 = new Person("Alice", 18);
        Person person2 = new Person("Bob", 25);
        Person person3 = new Person("Charlie", 45);
        Person person4 = new Person("David", 30);
        List<Person> people = Arrays.asList(person1, person2, person3, person4);

        Map<String, List<Person>> ageGroupToPeople = people.stream()
                .collect(Collectors.groupingBy(person -> {
                    int age = person.getAge();
                    if (age < 20) {
                        return "<20";
                    } else if (age < 40) {
                        return "20-40";
                    } else {
                        return "40+";
                    }
                }));

        System.out.println(ageGroupToPeople);
    }

}
