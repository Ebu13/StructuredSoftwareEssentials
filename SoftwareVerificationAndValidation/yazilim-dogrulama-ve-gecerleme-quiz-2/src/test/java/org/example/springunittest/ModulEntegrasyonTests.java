package org.example.springunittest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class ModulEntegrasyonTests {

    @Autowired
    private ModulA modulA;

    @Autowired
    private ModulB modulB;

    @Autowired
    private ModulC modulC;

    @Test
    public void modullerArasiEntegrasyonTesti() {
        Kullanici kullanici = modulA.getKullaniciBilgileri();
        assertTrue(modulB.ePostaDogrula(kullanici.getePosta()));

        String mesaj = modulC.hosGeldinizMesajiGonder(kullanici.getePosta());
        assertEquals("Hoş Geldiniz ali.veli@example.com", mesaj);
    }
}

