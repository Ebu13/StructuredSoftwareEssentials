/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uygukama1;

/**
 *
 * @author cetin
 */
public class Main {
    
    public static void main(String [] Args){
        Calisan calisan=new Calisan("Ali",25,"İnsan Kaynakları");
        Muhendis muhendis=new Muhendis("Yapay Zeka", 28, "Çetin", "Yapay Zeka");
        Muzisyen muzisyen=new Muzisyen("Yusuf",26,"Şarkıcı");
       
        muzisyen.bilgileriGoster();
        muzisyen.calis();
        muzisyen.enstrumanCal();
        
        
    }
}
