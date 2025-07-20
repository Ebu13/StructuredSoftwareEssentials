/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author cetin
 */

// Şekil sınıfı, genişletmeye açık ama değişikliğe kapalı olmalıdır.
abstract class Shape {
    abstract double calculateArea();
}

// Dikdörtgen sınıfı, Shape sınıfını genişletir.
public class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    double calculateArea() {
        return width * height;
    }
}

// Daire sınıfı, Shape sınıfını genişletir.
class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    double calculateArea() {
        return Math.PI * radius * radius;
    }
}

// Kullanıcı, farklı şekillerin alanını hesaplamak için bu yöntemi kullanabilir.
class Main {
    public static void main(String[] args) {
        Shape rectangle = new Rectangle(5, 10);
        Shape circle = new Circle(7);

        // Genişletme yapıldı, ancak mevcut kod değişmedi.
        System.out.println("Dikdörtgen Alanı: " + rectangle.calculateArea());
        System.out.println("Daire Alanı: " + circle.calculateArea());
    }
}

