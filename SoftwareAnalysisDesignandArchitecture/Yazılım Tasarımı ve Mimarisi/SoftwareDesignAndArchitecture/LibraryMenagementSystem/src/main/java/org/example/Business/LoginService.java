package org.example.Business;

import org.example.DAO.UserDAO;
import org.example.DAO.UserDAOFactory;
import org.example.Entity.User;

public class LoginService {
    private UserDAO userDAO;

    public LoginService() {
        this.userDAO = UserDAOFactory.createUserDAO();
    }

    public User login(String email, String password) {
        return userDAO.getUserByEmailAndPassword(email, password);
    }
}
