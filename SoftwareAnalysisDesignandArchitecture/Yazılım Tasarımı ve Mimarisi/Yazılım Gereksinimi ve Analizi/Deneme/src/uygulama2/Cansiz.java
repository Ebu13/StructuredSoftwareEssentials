/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uygulama2;

/**
 *
 * @author cetin
 */
public class Cansiz extends Evrensel{
    String malzeme;

    public Cansiz(String malzeme, String ad, int yas) {
        super(ad, yas);
        this.malzeme = malzeme;
    }
    
    public void cansizBilgileri(){
        System.out.println("Malzeme: "+malzeme);
    }
    
}
