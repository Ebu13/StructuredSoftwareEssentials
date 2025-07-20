/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author cetin
 */
// Engine.java
public class Engine {
    private String type;

    public Engine(String type) {
        this.type = type;
    }

    public void start() {
        System.out.println(type + " engine started");
    }
}

// Car.java
 class Car {
    private String brand;
    private Engine engine;

    public Car(String brand, Engine engine) {
        this.brand = brand;
        this.engine = engine;
    }

    public void start() {
        System.out.println("Starting the " + brand + " car.");
        engine.start(); // Car class directly calls the start method of the Engine class
    }
}

// Main.java
 class Main {
    public static void main(String[] args) {
        Engine engine = new Engine("V8");
        Car car = new Car("Toyota", engine);

        car.start();
    }
}
