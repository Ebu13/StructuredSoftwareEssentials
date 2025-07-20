package org.example.springunittest;

import org.springframework.stereotype.Component;

@Component
public class ModulC {
    public String hosGeldinizMesajiGonder(String ePosta) {
        return "Hoş Geldiniz " + ePosta;
    }
}

