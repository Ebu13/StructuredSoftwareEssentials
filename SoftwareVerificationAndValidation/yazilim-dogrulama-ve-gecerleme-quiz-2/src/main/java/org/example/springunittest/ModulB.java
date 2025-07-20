package org.example.springunittest;

import org.springframework.stereotype.Component;

@Component
public class ModulB {
    public boolean ePostaDogrula(String ePosta) {
        return ePosta != null && ePosta.contains("@");
    }
}

