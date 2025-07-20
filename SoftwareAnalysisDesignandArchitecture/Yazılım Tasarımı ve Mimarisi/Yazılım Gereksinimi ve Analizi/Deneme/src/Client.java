/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author cetin
 */
// Ürün arayüzü
interface Product {
    void display();
}

// ConcreteProduct1 sınıfı
class ConcreteProduct1 implements Product {
    @Override
    public void display() {
        System.out.println("ConcreteProduct1 gösteriliyor");
    }
}

// ConcreteProduct2 sınıfı
class ConcreteProduct2 implements Product {
    @Override
    public void display() {
        System.out.println("ConcreteProduct2 gösteriliyor");
    }
}

// Factory arayüzü
interface ProductFactory {
    Product createProduct();
}

// ConcreteFactory1 sınıfı
class ConcreteFactory1 implements ProductFactory {
    @Override
    public Product createProduct() {
        return new ConcreteProduct1();
    }
}

// ConcreteFactory2 sınıfı
class ConcreteFactory2 implements ProductFactory {
    @Override
    public Product createProduct() {
        return new ConcreteProduct2();
    }
}

// Kullanıcı sınıfı
public class Client {
    public static void main(String[] args) {
        // Factory kullanarak ConcreteProduct1 oluşturuluyor
        ProductFactory factory1 = new ConcreteFactory1();
        Product product1 = factory1.createProduct();
        product1.display();

        // Factory kullanarak ConcreteProduct2 oluşturuluyor
        ProductFactory factory2 = new ConcreteFactory2();
        Product product2 = factory2.createProduct();
        product2.display();
    }
}
/*
Bu örnekte, Product arayüzü ConcreteProduct1 ve ConcreteProduct2 sınıflarını tanımlamaktadır. Ayrıca, ProductFactory arayüzü, ürünleri oluşturacak olan fabrika sınıflarını tanımlamaktadır. 
ConcreteFactory1 ve ConcreteFactory2 sınıfları ise belirli ürünleri oluşturan fabrika sınıflarıdır.

Client sınıfı, kullanıcının Factory tasarım desenini kullanarak ürünleri oluşturduğu yerdir. Bu şekilde, istemci sınıf, hangi ürünü oluşturmak istediğini belirtir, ancak bu oluşturma sürecini 
gerçekleştiren fabrika sınıflarının detaylarından haberdar olmaz. Bu, kodun daha esnek ve bakımı daha kolay hale gelmesini sağlar.

*/