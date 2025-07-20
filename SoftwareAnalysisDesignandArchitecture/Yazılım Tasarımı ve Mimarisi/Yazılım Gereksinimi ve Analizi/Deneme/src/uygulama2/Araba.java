/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uygulama2;

/**
 *
 * @author cetin
 */
public class Araba extends Cansiz{
    
    String marka;

    public Araba(String marka, String malzeme, String ad, int yas) {
        super(malzeme, ad, yas);
        this.marka = marka;
    }
    
    public void arabaBilgileri(){
        System.out.println("Marka: "+marka);
    }
    
    
}
