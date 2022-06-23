package com.example.associationamal.service;

import com.example.associationamal.bean.Beneficiaire;
import com.example.associationamal.bean.Chambre;
import com.example.associationamal.bean.Membre;
import com.example.associationamal.dao.BeneficiaireDao;
import com.example.associationamal.dao.ChambreDao;
import com.example.associationamal.dao.MembreDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class MembreService {

    public int save(Membre membre) {

        if (findByCni(membre.getCni()) != null) {
            return -1;
        } else {
            membreDao.save(membre);
            return 1;
        }
    }
    public Membre findByCni(String cni) {
        return membreDao.findByCni(cni);
    }

    @Transactional
    public int deleteByCni(String cni) {
        return membreDao.deleteByCni(cni);
    }

    public List<Membre> findAll() {
        return membreDao.findAll();
    }


    @Autowired
    private MembreDao membreDao;
}
