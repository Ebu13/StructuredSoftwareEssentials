/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deneme;

import java.util.ArrayList;

/**
 *
 * @author cetin
 */
public class MusteriYonetimi {
    public static void main(String[] args) {
        // Müşteri nesnelerini oluşturup bir liste içinde saklama
        ArrayList<Musteri> musteriler = new ArrayList<>();

        musteriler.add(new Musteri("Ahmet", "Yılmaz", "555-1234567", "ahmet@email.com"));
        musteriler.add(new Musteri("Ayşe", "Demir", "555-9876543", "ayse@email.com"));

        // Müşteri bilgilerini listeleme
        System.out.println("Müşteri Listesi:");
        for (Musteri musteri : musteriler) {
            musteri.bilgileriGoster();
            System.out.println("------------");
        }
    }
}
