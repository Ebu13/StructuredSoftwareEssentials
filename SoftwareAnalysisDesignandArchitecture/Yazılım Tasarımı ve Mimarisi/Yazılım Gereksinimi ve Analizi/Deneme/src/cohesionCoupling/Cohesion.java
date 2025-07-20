/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cohesionCoupling;

/**
 *
 * @author cetin
 */
public class Cohesion {
    String ad;
    String soyad;
    String mail;

    public Cohesion(String ad, String soyad, String mail) {
        this.ad = ad;
        this.soyad = soyad;
        this.mail = mail;
    }
    
    public void sendMail(){
        System.out.println("Adı: "+ad+" Soyadı: "+soyad+" maili: "+mail+" olan kişiye mail gönderilmiştir");
    }
    
    public void reciveEmail(){
        System.out.println("Adı: "+ad+" Soyadı: "+soyad+" maili: "+mail+" olan kişinin maili alınmıştır");
    }
    
    public void saveEmail(){
         System.out.println("Adı: "+ad+" Soyadı: "+soyad+" belirtilen kişinin mail adresi kaydedilmiştir");
    }
    public void deleteEmail(){
        System.out.println(mail+" Mail adresi silinmiştir");
    }
}   

