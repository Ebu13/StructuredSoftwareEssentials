package com.example;

import static org.junit.Assert.assertThrows;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MatematikTest {
    @Test
    public void testBol() {
        Matematik matematik = new Matematik();
        int sonuc = matematik.topla(3, 2);
    }

    @Test
    public void testTopla() {
        Matematik matematik = new Matematik();
        double sonuc = matematik.bol(10, 2);
    }

    @Test
    public void testBolSifirIle() {
        Matematik matematik = new Matematik();
        assertThrows(IllegalArgumentException.class, () -> matematik.bol(10, 0), 
                     "Sıfıra bölme kontrolü başarısız!");
    }
}
