package org.example.Business;

import org.example.DAO.StudentDAO;
import org.example.Entity.Student;

import java.util.List;

public class StudentService {

    private StudentDAO studentDAO;

    // Constructor
    public StudentService() {
        studentDAO = new StudentDAO();
    }

    // Öğrenci ekleme metodu
    public void addStudent(Student student) {
        if (student != null) {
            studentDAO.addStudent(student);
            System.out.println("Öğrenci servis tarafından başarıyla eklendi: " + student.getName());
        } else {
            System.out.println("Geçersiz öğrenci bilgisi.");
        }
    }

    // Öğrenci silme metodu
    public void deleteStudent(String userId) {
        if (userId != null && !userId.isEmpty()) {
            studentDAO.deleteStudent(userId);
            System.out.println("Öğrenci servis tarafından başarıyla silindi.");
        } else {
            System.out.println("Geçersiz kullanıcı ID.");
        }
    }

    // Öğrenci bilgilerini alma metodu
    public Student getStudentById(String userId) {
        if (userId != null && !userId.isEmpty()) {
            return studentDAO.getStudentById(userId);
        } else {
            System.out.println("Geçersiz kullanıcı ID.");
            return null;
        }
    }

    // İsmine göre öğrencileri listeleme metodu
    public List<Student> getStudentsByName(String name) {
        if (name != null && !name.isEmpty()) {
            return studentDAO.getStudentsByName(name);
        } else {
            System.out.println("Geçersiz isim.");
            return null;
        }
    }
}
