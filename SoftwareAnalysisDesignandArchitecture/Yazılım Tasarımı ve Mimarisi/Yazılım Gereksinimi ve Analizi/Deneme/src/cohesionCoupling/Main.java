/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cohesionCoupling;

/**
 *
 * @author cetin
 */
public class Main {
    public static void main(String[] args) {
        Cohesion ch = new Cohesion("Çetin","Erçelik", "cetinercelik@gmail.com");
        ch.sendMail();
        ch.reciveEmail();
        ch.saveEmail();
        ch.deleteEmail();
        System.out.println("--------------------------------------------------------------------------------------------------------------------");
        Coupling cp = new Coupling("Yunus", "Topuz", "tpzyns@gmail.com", "http://localhost", Boolean.TRUE);
        cp.sendMail();
        cp.reciveEmail();
        cp.saveEmail();
        cp.deleteEmail();
        cp.dbConnector();
        cp.passValidation();
    }
}
