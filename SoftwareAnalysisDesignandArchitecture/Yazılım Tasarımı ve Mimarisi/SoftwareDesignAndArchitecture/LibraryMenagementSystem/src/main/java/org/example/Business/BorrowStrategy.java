package org.example.Business;

import org.example.DAO.BorrowDAO;
import org.example.Entity.LibraryItemDto;
import org.example.Entity.Student;

public interface BorrowStrategy {
    boolean borrowItem(Student student, LibraryItemDto item, BorrowDAO borrowDAO);
}
