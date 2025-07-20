package org.example.DAO;

public class UserDAOFactory {
    public static UserDAO createUserDAO() {
        return new UserDAO(); // Burada ilerleyen zamanda farklı veri kaynakları eklenebilir
    }
}
