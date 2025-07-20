/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uygulama2;

/**
 *
 * @author cetin
 */
public class Main {
    
    public static void main(String [] Args){
        Hayvan hayvan=new Hayvan(4, "Kurt", "Beyaz diş", 3);
        Bitki bitki=new Bitki("Afrika", "Ağaç", "Bambu", 5);
        Esya esya=new Esya("Kesme,Delme", "Bıçak", "Sürmene", 1);
        Araba araba=new Araba("BMW", "metal", "320i", 5);
        
        System.out.println("-----------------Hayvan Bilgileri--------------------------");
        hayvan.bigileriGoster();
        hayvan.canliBilgileri();
        hayvan.hayvanBilgisi();
        System.out.println("-----------------Bitki Bilgileri--------------------------");
        bitki.bigileriGoster();
        bitki.canliBilgileri();
        bitki.bitkiBilgileri();
        System.out.println("-----------------Eşya Bilgileri--------------------------");
        esya.bigileriGoster();
        esya.cansizBilgileri();
        esya.esyaBilgileri();
        System.out.println("-----------------Araba Bilgileri--------------------------");
        araba.bigileriGoster();
        araba.cansizBilgileri();
        araba.arabaBilgileri();
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }
    
    
}
