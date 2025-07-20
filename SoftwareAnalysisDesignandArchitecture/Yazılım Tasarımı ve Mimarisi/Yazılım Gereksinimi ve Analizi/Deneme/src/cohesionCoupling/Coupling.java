/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cohesionCoupling;

/**
 *
 * @author cetin
 */
public class Coupling {
    String ad;
    String soyad;
    String mail;
    String dbConUrl;
    Boolean isPassValid;

    public Coupling(String ad, String soyad, String mail, String dbConUrl, Boolean isPassValid) {
        this.ad = ad;
        this.soyad = soyad;
        this.mail = mail;
        this.dbConUrl = dbConUrl;
        this.isPassValid = isPassValid;
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
    public void dbConnector(){
        System.out.println("Veri tabanı bağlantı adresi :"+dbConUrl+" olan veri tabanına bağlanıldı.");
    }
    public void passValidation(){
        System.out.println("Adı: "+ad+" Soyadı: "+soyad+" olan kişinin giriş bilgilerinin durumu: "+isPassValid);
    }
}
