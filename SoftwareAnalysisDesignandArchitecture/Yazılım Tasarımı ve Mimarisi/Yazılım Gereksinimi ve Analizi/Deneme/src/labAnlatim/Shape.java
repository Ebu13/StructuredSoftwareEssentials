package labAnlatim;

import .*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author cetin
 */
public class Shape {
    public void draw() {
        System.out.println("Drawing a shape");
    }
}

class Circle extends Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a circle");
    }
}

class Square extends Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a square");
    }
}

 class LSPExample {
    public static void drawShape(Shape shape) {
        shape.draw();
    }

    public static void main(String[] args) {
        Shape circle = new Circle();
        Shape square = new Square();

        drawShape(circle); // Drawing a circle
        drawShape(square); // Drawing a square
    }
}
/*
Bu örnekte, Circle ve Square sınıfları, Shape sınıfından türetilmiştir ve draw metodunu override eder. 
Daha sonra, LSPExample sınıfında, drawShape metodu, bir Shape nesnesi alır ve bu nesnenin hangi alt sınıftan 
türetildiği önemli olmaksızın doğru şekilde davranmasını sağlar. Bu, Liskov'un Substitution Prensibi'ni takip etmektedir.
*/
