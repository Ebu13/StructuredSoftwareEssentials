/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author cetin
 */
// Yüksek seviyeli modül - Veritabanına kayıt ekleyen servis
interface DatabaseService {
    void addToDatabase(String data);
}

// Düşük seviyeli modül - PostgreSQL veritabanına kayıt ekleyen servis
public class PostgreSQLDatabaseService implements DatabaseService {
    @Override
    public void addToDatabase(String data) {
        // PostgreSQL'a veri ekleme işlemleri
        System.out.println("PostgreSQL veritabanına eklendi: " + data);
    }
}

// Düşük seviyeli modül - MongoDB veritabanına kayıt ekleyen servis
class MongoDBDatabaseService implements DatabaseService {
    @Override
    public void addToDatabase(String data) {
        // MongoDB'ye veri ekleme işlemleri
        System.out.println("MongoDB veritabanına eklendi: " + data);
    }
}

// Yüksek seviyeli modül - Veritabanına kayıt ekleyen işlem
class DataProcessor {
    private DatabaseService databaseService;

    // Dependency Inversion Principle uygulaması: Arayüze (interface) bağımlı
    public DataProcessor(DatabaseService databaseService) {
        this.databaseService = databaseService;
    }

    public void processData(String data) {
        // Veriyi işleme işlemleri...
        System.out.println("Veri işleniyor: " + data);

        // Veriyi veritabanına ekleme işlemi
        databaseService.addToDatabase(data);
    }
}

// Kullanım örneği
class Main {
    public static void main(String[] args) {
        // PostgreSQL veritabanı kullanımı
        DatabaseService postgreSQLService = new PostgreSQLDatabaseService();
        DataProcessor dataProcessorPostgreSQL = new DataProcessor(postgreSQLService);
        dataProcessorPostgreSQL.processData("Örnek veri PostgreSQL");

        System.out.println();

        // MongoDB veritabanı kullanımı
        DatabaseService mongoDBService = new MongoDBDatabaseService();
        DataProcessor dataProcessorMongoDB = new DataProcessor(mongoDBService);
        dataProcessorMongoDB.processData("Örnek veri MongoDB");
    }
}

