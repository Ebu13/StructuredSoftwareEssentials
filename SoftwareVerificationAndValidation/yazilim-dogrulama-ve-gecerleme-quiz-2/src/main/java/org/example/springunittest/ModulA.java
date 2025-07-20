package org.example.springunittest;

import org.springframework.stereotype.Component;

@Component
public class ModulA {
    public Kullanici getKullaniciBilgileri() {
        Kullanici kullanici = new Kullanici();
        kullanici.setIsim("Ali Veli");
        kullanici.setePosta("ali.veli@example.com");
        return kullanici;
    }
}

