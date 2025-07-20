/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uygulama2;

/**
 *
 * @author cetin
 */
public class Bitki extends Canli{
    
    String yetistiğiBolge;

    public Bitki(String yetistiğiBolge, String cins, String ad, int yas) {
        super(cins, ad, yas);
        this.yetistiğiBolge = yetistiğiBolge;
    }
    
    public void bitkiBilgileri(){
        System.out.println("Yetistiği Bölge: "+yetistiğiBolge);
    }
}
