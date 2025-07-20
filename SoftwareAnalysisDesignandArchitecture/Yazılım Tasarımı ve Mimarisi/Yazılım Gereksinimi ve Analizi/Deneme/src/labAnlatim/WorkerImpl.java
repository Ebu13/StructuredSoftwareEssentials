package labAnlatim;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author cetin
 */
// Yetersiz bir arayüz
interface Worker {
    void work();
    void eat();
}

// Çalışan sınıfı, sadece work metodu kullanır
public class WorkerImpl implements Worker {
    @Override
    public void work() {
        System.out.println("Working");
    }

    @Override
    public void eat() {
        // Boş implementasyon, ancak bu sınıf eat metoduyla ilgilenmiyor
    }
}

// Yeniden düzenlenmiş arayüz
interface Workable {
    void work();
}

interface Eatable {
    void eat();
}

// İki ayrı arayüzü uygulayan sınıf
class WorkerWithSeparateInterfaces implements Workable, Eatable {
    @Override
    public void work() {
        System.out.println("Working");
    }

    @Override
    public void eat() {
        System.out.println("Eating");
    }
}

class ISPExample {
    public static void main(String[] args) {
        WorkerImpl worker = new WorkerImpl();
        worker.work(); // Working

        WorkerWithSeparateInterfaces newWorker = new WorkerWithSeparateInterfaces();
        newWorker.work(); // Working
        newWorker.eat();  // Eating
    }
}

