/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uygulama2;

/**
 *
 * @author cetin
 */
public class Canli extends Evrensel {
    
    String cins;

    public Canli(String cins, String ad, int yas) {
        super(ad, yas);
        this.cins = cins;
    }
    
    public void canliBilgileri(){
        System.out.println("Cinsi: "+cins);
    }

}
