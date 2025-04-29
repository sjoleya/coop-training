package Worksheet.Q4_Polymorphism;

/*
Create a `Shape` class with a method `draw()`. Extend it with `Circle`, `Square`, and `Triangle`
classes. Override `draw()` in each class. In the main method, store shapes in an array and call
`draw()` in a loop.
 */

class Shape {
    public void draw() {
        System.out.println("Drawing a shape.");
    }
}

class Circle extends Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a Circle.");
    }
}

class Square extends Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a Square.");
    }
}

class Triangle extends Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a Triangle.");
    }
}

public class Problem4 {
    public static void main(String[] args) {
        Shape[] shapes = {
                new Circle(),
                new Square(),
                new Triangle()
        };
        for (Shape shape : shapes) {
            shape.draw();
        }
    }
}
