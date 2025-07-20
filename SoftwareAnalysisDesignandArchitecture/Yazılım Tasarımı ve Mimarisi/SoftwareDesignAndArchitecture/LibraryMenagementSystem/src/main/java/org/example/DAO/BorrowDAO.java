package org.example.DAO;

import org.example.Core.Database;
import org.example.Entity.LibraryItemDto;
import org.example.Entity.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BorrowDAO {

    private static final String INSERT_BORROWED_ITEM_QUERY = "INSERT INTO BorrowedItems (student_id, item_id, borrowed_date) VALUES (?, ?, CURRENT_TIMESTAMP)";
    private static final String CHECK_ITEM_EXISTENCE = "SELECT COUNT(*) FROM LibraryItem WHERE id = ?";
    private static final String CHECK_STUDENT_EXISTENCE = "SELECT COUNT(*) FROM Student WHERE user_id = ?";

    public boolean borrowItem(Student student, LibraryItemDto item) {
        try (Connection connection = Database.getInstance();
             PreparedStatement statement = connection.prepareStatement(INSERT_BORROWED_ITEM_QUERY)) {
            statement.setInt(1, Integer.parseInt(student.getUserId()));  // Student ID
            statement.setInt(2, Integer.parseInt(item.getId()));         // Item ID

            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean checkItemExistence(LibraryItemDto item) {
        return checkExistence(CHECK_ITEM_EXISTENCE, item.getId());
    }

    public boolean checkStudentExistence(Student student) {
        return checkExistence(CHECK_STUDENT_EXISTENCE, student.getUserId());
    }

    private boolean checkExistence(String query, String id) {
        try (Connection connection = Database.getInstance();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, Integer.parseInt(id));
            ResultSet resultSet = stmt.executeQuery();
            resultSet.next();
            return resultSet.getInt(1) > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
