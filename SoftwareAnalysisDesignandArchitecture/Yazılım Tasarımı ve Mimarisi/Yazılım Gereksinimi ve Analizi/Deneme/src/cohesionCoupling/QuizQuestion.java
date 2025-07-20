/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cohesionCoupling;

/**
 *
 * @author cetin
 *  
 */
// 
/*
Soru 1: Aşağıdaki kod parçasında QuizQuestion sınıfının processData metodu 
içindeki düşük cohesionu giderin

Soru 2: Aşağıdaki kod parçasında QuizQuestion sınıfının processData metodu 
içinde nedende bulunan yüksek couplingi kodlayarak giderin

*/
public class QuizQuestion {
    private DatabaseConnector databaseConnector;
    private FileProcessor fileProcessor;

    public QuizQuestion(DatabaseConnector databaseConnector, FileProcessor fileProcessor) {
        this.databaseConnector = databaseConnector;
        this.fileProcessor = fileProcessor;
    }

    public void processData() {
        // Veritabanından veri okuma işlemi
        String dataFromDatabase = databaseConnector.readData();

        // Dosyadan veri okuma işlemi
        String dataFromFile = fileProcessor.readDataFromFile();

        // Veri işleme adımları
        String processedData = process(dataFromDatabase, dataFromFile);

        // Sonuçları kaydetme işlemi
        databaseConnector.saveData(processedData);
        fileProcessor.writeDataToFile(processedData);
    }

    private String process(String dataFromDatabase, String dataFromFile) {
        // Veri işleme algoritmaları
        return "Processed data";
    }
}
class DatabaseConnector {
    public String readData() {
        // Veritabanından veri okuma işlemleri
        return "Data from database";
    }

    public void saveData(String data) {
        // Veriyi veritabanına kaydetme işlemleri
    }
}

class FileProcessor {
    public String readDataFromFile() {
        // Dosyadan veri okuma işlemleri
        return "Data from file";
    }

    public void writeDataToFile(String data) {
        // Veriyi dosyaya yazma işlemleri
    }
}
