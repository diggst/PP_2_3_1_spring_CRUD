package main.service;

import main.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import main.dao.UserDAO;

import java.util.List;

@Service
public class UserServiceImp implements UserService{

    @Autowired
    private UserDAO userDAO;

    @Override
    public List<User> index() {
        return userDAO.index();
    }

    @Override
    public void saveUser(User newUser) {
        userDAO.saveUser(newUser);
    }

    @Override
    public void deleteUser(long id) {
        userDAO.deleteUser(id);
    }

    @Override
    public void updateUser(User updUser) {
        userDAO.updateUser(updUser);
    }

    @Override
    public User getUser(long id) {
        return userDAO.getUser(id);
    }
}