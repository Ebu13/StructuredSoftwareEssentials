package org.example.Entity;

import java.util.List;

public class Student extends Person implements IUser {
    @Override
    public boolean returnItem(LibraryItem item) {
        // Materyali iade etme işlemi
        System.out.println(getName() + " bir materyali iade etti: " + item.getTitle());
        borrowedItems.remove(item);
        return true; // İşlemin başarılı olduğunu belirten true döndürülür
    }

    private List<LibraryItem> borrowedItems;

    public Student(String userId, String name, String email, String password, List<LibraryItem> borrowedItems) {
        super(userId, name, email, password);
        this.borrowedItems = borrowedItems;
    }

    public List<LibraryItem> getBorrowedItems() {
        return borrowedItems;
    }

    public void setBorrowedItems(List<LibraryItem> borrowedItems) {
        this.borrowedItems = borrowedItems;
    }
}
