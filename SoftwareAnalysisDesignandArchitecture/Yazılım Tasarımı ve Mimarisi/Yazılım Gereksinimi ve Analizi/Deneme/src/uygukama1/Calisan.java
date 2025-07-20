/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uygukama1;

/**
 *
 * @author cetin
 */
public class Calisan {
    String ad;
    int yas;
    String departman;

    public Calisan(String ad, int yas, String departman) {
        this.ad = ad;
        this.yas = yas;
        this.departman = departman;
    }
    

    
    public void calis(){
        System.out.println("Kişi çalışıyor");
    }
    public void bilgileriGoster(){
        System.out.println("Ad: "+ad);
        System.out.println("Yaş: "+yas);
        System.out.println("Departman: "+departman);
    }
}
