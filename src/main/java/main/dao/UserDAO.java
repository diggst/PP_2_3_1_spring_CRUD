package main.dao;

import main.models.User;

import java.util.List;

public interface UserDAO {
    public List<User> index();

    public void saveUser(User newUser);

    public void deleteUser(long id);

    public void updateUser(User updUser);

    public User getUser(long id);
}
