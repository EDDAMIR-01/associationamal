package com.example.associationamal.service;

import com.example.associationamal.bean.Demande;
import com.example.associationamal.bean.User;
import com.example.associationamal.dao.DemandeDao;
import com.example.associationamal.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class DemandeService {

    public int save(Demande demande){
        User user = userDao.findByLoginAndPassword(demande.getUser().getLogin(),demande.getUser().getPassword());
        if(findByRef(demande.getRef())!= null){
            return -1;
        }
        else if(user == null){
            return -2;
        }
        else {
            demande.setUser(user);
            demande.setAccepter(false);
            demandeDao.save(demande);
            return 1;
        }

    }
    public Demande findByRef(String ref) {
        return demandeDao.findByRef(ref);
    }
    @Transactional
    public int deleteByRef(String ref) {
        return demandeDao.deleteByRef(ref);
    }

    public List<Demande> findAll() {
        return demandeDao.findAll();
    }
    @Transactional
    public int deleteByUserLogin(String login) {
        return demandeDao.deleteByUserLogin(login);
    }

    @Autowired
    private DemandeDao demandeDao;
    @Autowired
    private UserDao userDao;
}
