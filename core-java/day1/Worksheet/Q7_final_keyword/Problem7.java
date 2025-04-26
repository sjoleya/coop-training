package Worksheet.Q7_final_keyword;

/*
Create a `BasicCalculator` class with a `final` method `add(int a, int b)`. Extend it in a
`SmartCalculator` class and attempt to override `add()` (it should give an error). Add a new method
`subtract()` in the subclass.
 */

class BasicCalculator {
    public final int add(int a, int b) {
        return a + b;
    }
}

class SmartCalculator extends BasicCalculator {
//    Overriding `add` will give error
//    public int add(int a, int b) {}
    public int subtract(int a, int b) {
        return a - b;
    }
}

public class Problem7 {
    public static void main(String[] args) {
        BasicCalculator c1 = new BasicCalculator();
        SmartCalculator s1 = new SmartCalculator();
        System.out.println(c1.add(5,3));
        System.out.println(s1.subtract(16,7));
    }
}
