package com.example.associationamal.dao;

import com.example.associationamal.bean.Chambre;
import com.example.associationamal.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User, Long> {
    User findByLoginAndPassword(String login, String password);

    int deleteByLogin(String Login);

    User findByLogin(String login);
}
