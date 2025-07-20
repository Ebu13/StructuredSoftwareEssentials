/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author cetin
 */
// LowCohesionExample.java
public class LowCohesionExample {
    private String data;

    public LowCohesionExample(String data) {
        this.data = data;
    }

    // Metot 1: Veriyi büyük harfe dönüştür
    public String convertToUpperCase() {
        data = data.toUpperCase();
        return data;
    }

    // Metot 2: Veriyi ters çevir
    public String reverseData() {
        StringBuilder reversed = new StringBuilder(data);
        reversed.reverse();
        data = reversed.toString();
        return data;
    }

    // Metot 3: Veriyi ekrana yazdır
    public void printData() {
        System.out.println(data);
    }

    public static void main(String[] args) {
        LowCohesionExample example = new LowCohesionExample("Hello, World!");

        example.convertToUpperCase();
        example.reverseData();
        example.printData();
    }
}

