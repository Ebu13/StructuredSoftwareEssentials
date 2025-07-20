package org.example.DAO;

import org.example.Core.Database;
import org.example.Entity.User;
import java.sql.*;

public class UserDAO {
    private Connection connection;

    public UserDAO() {
        // Database sınıfını kullanarak bağlantıyı alıyoruz
        this.connection = Database.getInstance();
    }

    public User getUserByEmailAndPassword(String email, String password) {
        User user = null;
        String query = "SELECT * FROM Person WHERE email = ? AND password = ?"; // Tablo adını kontrol edin

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, email);
            stmt.setString(2, password);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String userId = rs.getString("user_id");
                String name = rs.getString("name");
                String personType = rs.getString("person_type");
                user = new User(userId, name, email, password, personType);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}
