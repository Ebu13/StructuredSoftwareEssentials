package org.example.Entity;

public class Staff extends Person implements IUser { // IUser'ı implement et
    public Staff(String userId, String name, String email, String password) {
        super(userId, name, email, password);
    }

    @Override
    public boolean borrow() {
        // Staff özelinde ödünç alma işlemi
        System.out.println(getName() + " (Staff) bir materyal ödünç aldı.");
        return true; // İşlemin başarılı olduğunu belirtmek için true döndürülür
    }

    @Override
    public boolean returnItem(LibraryItem item) {
        // Staff özelinde materyal iade işlemi
        System.out.println(getName() + " (Staff) bir materyali iade etti.");
        return true; // İşlemin başarılı olduğunu belirtmek için true döndürülür
    }
}
