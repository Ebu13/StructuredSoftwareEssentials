package com.example;

public class Matematik {
     // Basit toplama fonksiyonu
     public int topla(int a, int b) {
        return a + b;
    }

    // Sıfıra bölme kontrolü yapan bölme fonksiyonu
    public double bol(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Bölen sıfır olamaz");
        }
        return (double) a / b;
    }
}
