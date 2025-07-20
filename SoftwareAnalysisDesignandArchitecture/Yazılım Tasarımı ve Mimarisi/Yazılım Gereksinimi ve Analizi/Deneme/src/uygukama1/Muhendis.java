/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uygukama1;

/**
 *
 * @author cetin
 */
public class Muhendis extends Calisan{

        String uzmanlikAlani;

    public Muhendis(String uzmanlikAlani, int yas, String ad, String departman) {
        super(ad, yas, departman);
        this.uzmanlikAlani = uzmanlikAlani;
    }
    
    @Override
    public void calis(){
        System.out.println("Mühendisimiz problemleri çözer");
    }
    
    void problemleriCoz(){
        System.out.println("Mühendisimizn uzmanlık Alanı: "+uzmanlikAlani);
    }
    
    
}
