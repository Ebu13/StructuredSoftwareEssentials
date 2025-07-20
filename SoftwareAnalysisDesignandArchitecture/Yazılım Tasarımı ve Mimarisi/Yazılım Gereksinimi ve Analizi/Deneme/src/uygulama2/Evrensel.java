/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uygulama2;

/**
 *
 * @author cetin
 */
public class Evrensel {
    String ad;
    int yas;

    public Evrensel(String ad, int yas) {
        this.ad = ad;
        this.yas = yas;
    }
    
    public void bigileriGoster(){
        System.out.println("Ad: "+ad);
        System.out.println("Yaş: "+yas);
    }
    
}
