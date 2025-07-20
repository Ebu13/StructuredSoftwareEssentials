/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deneme;

/**
 *
 * @author cetin
 */
class Musteri {
    private String ad;
    private String soyad;
    private String telefon;
    private String email;
    public Musteri(String ad, String soyad, String telefon, String email) {
        this.ad = ad;
        this.soyad = soyad;
        this.telefon = telefon;
        this.email = email;
    }
    public String getAd() {
        return ad;
    }
    public String getSoyad() {
        return soyad;
    }
    public String getTelefon() {
        return telefon;
    }
    public String getEmail() {
        return email;
    }
    public void bilgileriGoster() {
        System.out.println("Ad: " + ad);
        System.out.println("Soyad: " + soyad);
        System.out.println("Telefon: " + telefon);
        System.out.println("Email: " + email);
    }
}


