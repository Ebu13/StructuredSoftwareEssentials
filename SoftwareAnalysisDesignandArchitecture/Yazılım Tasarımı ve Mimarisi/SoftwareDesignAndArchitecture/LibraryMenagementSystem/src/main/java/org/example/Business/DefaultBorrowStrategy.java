package org.example.Business;

import org.example.DAO.BorrowDAO;
import org.example.Entity.LibraryItemDto;
import org.example.Entity.Student;

public class DefaultBorrowStrategy implements BorrowStrategy {

    @Override
    public boolean borrowItem(Student student, LibraryItemDto item, BorrowDAO borrowDAO) {
        // Öğrencinin ve materyalin doğruluğunu kontrol et
        if (borrowDAO.checkStudentExistence(student) && borrowDAO.checkItemExistence(item)) {
            return borrowDAO.borrowItem(student, item);
        }
        return false;
    }
}
