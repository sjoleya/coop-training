package Worksheet.Q9_super_keyword;

/*
Create a base class `Animal` with a method `makeSound()`. Extend it with `Cat` and `Dog` classes.
In overridden methods, first call `super.makeSound()` and then add animal-specific sound logic.
 */

class Animal {
    void makeSound(String sound) {
        System.out.println("Animal making sound: " + sound);
    }
}

class Dog extends Animal {
    void makeSound(String sound) {
        super.makeSound(sound);
    }
}

class Cat extends Animal {
    void makeSound(String sound) {
        super.makeSound(sound);
    }
}

public class Problem9 {
    public static void main(String[] args) {
        Animal dog1 = new Dog();
        Animal cat1 = new Cat();
        dog1.makeSound("Bark!");
        cat1.makeSound("Meow!");
    }
}
