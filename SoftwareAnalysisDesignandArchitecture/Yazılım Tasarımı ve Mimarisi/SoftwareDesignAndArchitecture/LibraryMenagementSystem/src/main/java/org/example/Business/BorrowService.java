package org.example.Business;

import org.example.DAO.BorrowDAO;
import org.example.Entity.LibraryItemDto;
import org.example.Entity.Student;

public class BorrowService {

    private BorrowDAO borrowDAO;
    private BorrowStrategy borrowStrategy;  // Strateji arayüzü

    public BorrowService(BorrowDAO borrowDAO, BorrowStrategy borrowStrategy) {
        this.borrowDAO = borrowDAO;
        this.borrowStrategy = borrowStrategy;  // Stratejiyi DI (Dependency Injection) ile alıyoruz
    }

    public void setBorrowStrategy(BorrowStrategy borrowStrategy) {
        this.borrowStrategy = borrowStrategy;  // Stratejiyi değiştirebilirsiniz
    }

    public boolean borrowItem(Student student, LibraryItemDto item) {
        if (student == null || item == null) {
            System.out.println("Öğrenci veya materyal geçersiz.");
            return false;
        }

        // Stratejiye bağlı olarak ödünç alma işlemi yapılır
        boolean isSuccess = borrowStrategy.borrowItem(student, item, borrowDAO);
        if (isSuccess) {
            item.setAvailable(false);  // Materyal ödünç alındığında mevcut değil hale gelir
            System.out.println(student.getName() + " ödünç almak istediği " + item.getTitle() + " materyalini aldı.");
            return true;
        } else {
            System.out.println("Ödünç alma işlemi başarısız.");
            return false;
        }
    }
}
