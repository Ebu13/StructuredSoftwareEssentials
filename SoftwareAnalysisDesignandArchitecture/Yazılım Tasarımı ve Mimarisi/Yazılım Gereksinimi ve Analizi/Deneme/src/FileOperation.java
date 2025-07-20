/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author cetin
 */

// İlk olarak, bir işlemi gerçekleştirecek olan arayüzü tanımlayalım.
interface Operation {
    void execute();
}

// Ardından, bu arayüzü uygulayan ve yalnızca belirli bir işlemi gerçekleştiren bir sınıf oluşturalım.
public class FileOperation implements Operation {
    private String fileName;

    public FileOperation(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void execute() {
        // Dosya ile ilgili işlemleri gerçekleştir
        System.out.println("Dosya işlemi yapılıyor: " + fileName);
    }
}

// Şimdi, kullanıcıya dosya işlemlerini yönetme sorumluluğunu ekleyen bir sınıf oluşturalım.
class FileManager {
    private Operation operation;

    public FileManager(Operation operation) {
        this.operation = operation;
    }

    public void performFileOperation() {
        // Diğer dosya yönetimi işlemleri (örneğin, yetkilendirme kontrolü, loglama, istisna yönetimi, vb.) yapılabilir
        System.out.println("Dosya yönetimi işlemleri yapılıyor.");

        // Ardından, belirli bir işlemi gerçekleştiren sınıfı çağırın
        operation.execute();
    }
}

class Main {
    public static void main(String[] args) {
        // Single Responsibility Principle'a uygun şekilde kullanım
        Operation fileOperation = new FileOperation("example.txt");
        FileManager fileManager = new FileManager(fileOperation);
        fileManager.performFileOperation();
    }
}

