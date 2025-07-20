package org.example.DAO;

import org.example.Core.Database;
import org.example.Entity.Student;
import org.example.Entity.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    public void addStudent(Student student) {
        String checkEmailSql = "SELECT COUNT(*) FROM Person WHERE email = ?";
        String insertSql = "INSERT INTO Person (name, email, password, person_type) VALUES (?, ?, ?, ?)";

        try (Connection connection = Database.getInstance();
             PreparedStatement checkEmailStmt = connection.prepareStatement(checkEmailSql)) {

            checkEmailStmt.setString(1, student.getEmail());
            ResultSet resultSet = checkEmailStmt.executeQuery();
            resultSet.next();
            int count = resultSet.getInt(1);

            if (count > 0) {
                System.out.println("Bu e-posta adresi zaten kayıtlı.");
                return;  // E-posta zaten varsa, ekleme işlemini sonlandır
            }

            try (PreparedStatement insertStmt = connection.prepareStatement(insertSql, Statement.RETURN_GENERATED_KEYS)) {
                insertStmt.setString(1, student.getName());
                insertStmt.setString(2, student.getEmail());
                insertStmt.setString(3, student.getPassword());
                insertStmt.setString(4, "Student");  // Öğrenci türü

                int rowsAffected = insertStmt.executeUpdate();
                if (rowsAffected > 0) {
                    ResultSet generatedKeys = insertStmt.getGeneratedKeys();
                    if (generatedKeys.next()) {
                        int userId = generatedKeys.getInt(1);
                        student.setUserId(String.valueOf(userId));
                        System.out.println("Öğrenci başarıyla eklendi: " + student.getName());
                    }
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Öğrenci silme metodu
    public void deleteStudent(String userId) {
        String deleteBorrowedItemsSql = "DELETE FROM BorrowedItems WHERE student_id = ?";
        String deleteStudentSql = "DELETE FROM Person WHERE user_id = ?";

        try (Connection connection = Database.getInstance()) {
            // İlk olarak, öğrenciye ait ödünç alınan kitapları silelim
            try (PreparedStatement deleteBorrowedItemsStmt = connection.prepareStatement(deleteBorrowedItemsSql)) {
                deleteBorrowedItemsStmt.setInt(1, Integer.parseInt(userId));
                deleteBorrowedItemsStmt.executeUpdate();
            }

            // Öğrenciyi silelim
            try (PreparedStatement deleteStudentStmt = connection.prepareStatement(deleteStudentSql)) {
                deleteStudentStmt.setInt(1, Integer.parseInt(userId));
                int rowsAffected = deleteStudentStmt.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Öğrenci başarıyla silindi.");
                } else {
                    System.out.println("Öğrenci bulunamadı.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Öğrenci bilgilerini getirme metodu
    public Student getStudentById(String userId) {
        String sql = "SELECT * FROM Person WHERE user_id = ? AND person_type = 'Student'";
        Student student = null;

        try (Connection connection = Database.getInstance();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, Integer.parseInt(userId));
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");

                student = new Student(userId, name, email, password, new ArrayList<>());
            } else {
                System.out.println("Öğrenci bulunamadı.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return student;
    }

    // Öğrencileri isme göre getirme metodu
    public List<Student> getStudentsByName(String name) {
        String sql = "SELECT * FROM Person WHERE name LIKE ? AND person_type = 'Student'";
        List<Student> students = new ArrayList<>();

        try (Connection connection = Database.getInstance();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, "%" + name + "%");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String userId = resultSet.getString("user_id");
                String studentName = resultSet.getString("name");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");

                students.add(new Student(userId, studentName, email, password, new ArrayList<>()));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return students;
    }
}
