package main.dao;

import main.models.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDAOImp implements UserDAO{

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public List<User> index() {
        String jpql = "SELECT c FROM User c";
        TypedQuery<User> query = entityManager.createQuery(jpql, User.class);
        return query.getResultList();
    }

    @Transactional
    @Override
    public void saveUser(User newUser) {
        entityManager.persist(newUser);
    }

    @Transactional
    @Override
    public void deleteUser(long id) {
        entityManager.remove(getUser(id));
    }

    @Transactional
    @Override
    public void updateUser(User updUser) {
         entityManager.merge(updUser);
    }

    @Transactional
    @Override
    public User getUser(long id) {
        return entityManager.find(User.class, (long)id);
    }
}