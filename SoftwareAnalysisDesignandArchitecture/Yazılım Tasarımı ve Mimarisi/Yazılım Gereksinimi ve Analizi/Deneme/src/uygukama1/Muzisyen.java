/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uygukama1;

/**
 *
 * @author cetin
 */
public class Muzisyen extends Calisan{
    
    public Muzisyen(String ad, int yas, String departman) {
        super(ad, yas, departman);
    }
    
    @Override
    public void calis(){
        System.out.println("Müzisyenimiz çalışıyor");
    }
    
    public void enstrumanCal(){
        System.out.println("Müzisyenimiz gitar çalabiliyor");
    }
    
}
