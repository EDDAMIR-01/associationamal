package com.example.associationamal.service;

import com.example.associationamal.bean.User;
import com.example.associationamal.dao.DemandeDao;
import com.example.associationamal.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserService {
    public User findByLogin(String login) {
        return userDao.findByLogin(login);
    }

    public int save(User user) {
        if (findByLogin(user.getLogin()) != null) {
            return -1;
        } else {
            user.setRole("Utilisateur");
            user.setBlocked(true);
            userDao.save(user);
            return 1;
        }
    }

    public int change_role(String login, String role) {
        User user1 = findByLogin(login);
        user1.setRole(role);
        userDao.save(user1);
        return 1;
    }

    public int change_status(String login, boolean status) {
        User user1 = findByLogin(login);
        user1.setBlocked(status);
        userDao.save(user1);
        return 1;
    }

    public User findByLoginAndPassword(String login, String password) {
        return userDao.findByLoginAndPassword(login, password);
    }

    @Transactional
    public int deleteByLogin(String Login) {
        return userDao.deleteByLogin(Login);
    }

    public List<User> findAll() {
        return userDao.findAll();
    }

    @Autowired
    private UserDao userDao;
    @Autowired
    private DemandeDao demandeDao;
    @Autowired
    private DemandeService demandeService;

}
