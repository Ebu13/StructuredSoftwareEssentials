package labAnlatim;

import .*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author cetin
 */
public class AppConfig {

    // Tek örnek için static değişken
    private static AppConfig instance;

    // Private constructor ile dışarıdan erişimi engelliyoruz
    private AppConfig() {
        // Yapıcı metot içeriği isteğe bağlı olarak doldurulabilir
    }

    // Tek bir AppConfig örneğini döndüren metot
    public static AppConfig getInstance() {
        // Eğer henüz bir örnek oluşturulmamışsa, oluşturup instance değişkenine atıyoruz
        if (instance == null) {
            instance = new AppConfig();
        }
        return instance;
    }

    // Uygulamanın genelinde kullanılacak ayarları içeren metot
    public void setApplicationName(String appName) {
        // Uygulama adını ayarlara set etmek için kullanılabilir
        System.out.println("Uygulama adı ayarlandı: " + appName);
    }

    // Diğer ayarları içeren metotlar da eklenebilir
}

                                                                                