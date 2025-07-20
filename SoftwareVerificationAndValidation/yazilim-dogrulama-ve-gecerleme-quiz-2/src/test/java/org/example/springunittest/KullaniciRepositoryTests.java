package org.example.springunittest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
public class KullaniciRepositoryTests {

    @Autowired
    private KullaniciRepository kullaniciRepository;

    @Test
    public void veriEklemeTesti() {
        Kullanici kullanici = new Kullanici();
        kullanici.setIsim("Ali Veli");
        kullanici.setePosta("ali.veli@example.com");
        kullaniciRepository.save(kullanici);

        Optional<Kullanici> bulunanKullanici = kullaniciRepository.findByIsim("Ali Veli");
        assertTrue(bulunanKullanici.isPresent());
        assertEquals("ali.veli@example.com", bulunanKullanici.get().getePosta());
    }

    @Test
    public void veriGuncellemeTesti() {
        Optional<Kullanici> bulunanKullanici = kullaniciRepository.findByIsim("Ali Veli");
        assertTrue(bulunanKullanici.isPresent());

        Kullanici kullanici = bulunanKullanici.get();
        kullanici.setePosta("veli.ali@example.com");
        kullaniciRepository.save(kullanici);

        Optional<Kullanici> guncellenmisKullanici = kullaniciRepository.findByIsim("Ali Veli");
        assertTrue(guncellenmisKullanici.isPresent());
        assertEquals("veli.ali@example.com", guncellenmisKullanici.get().getePosta());
    }

    @Test
    public void veriSilmeTesti() {
        Optional<Kullanici> bulunanKullanici = kullaniciRepository.findByIsim("Ali Veli");
        bulunanKullanici.ifPresent(kullaniciRepository::delete);

        Optional<Kullanici> silinmisKullanici = kullaniciRepository.findByIsim("Ali Veli");
        assertFalse(silinmisKullanici.isPresent());
    }
}
