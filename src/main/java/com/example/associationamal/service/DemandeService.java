package com.example.associationamal.service;

import com.example.associationamal.bean.Beneficiaire;
import com.example.associationamal.bean.Chambre;
import com.example.associationamal.bean.Demande;
import com.example.associationamal.bean.User;
import com.example.associationamal.dao.BeneficiaireDao;
import com.example.associationamal.dao.ChambreDao;
import com.example.associationamal.dao.DemandeDao;
import com.example.associationamal.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class DemandeService {

    public int save(Demande demande){
        Beneficiaire beneficiaire = beneficiaireDao.findByCni(demande.getBeneficiaire().getCni());
        Chambre chambre = chambreDao.findByRef(demande.getChambre().getRef());
        if(findByRef(demande.getRef())!= null){
            return -1;
        }
        else {
            demande.setBeneficiaire(beneficiaire);
            demande.setAccepter(false);
            demande.setChambre(chambre);
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

    @Autowired
    private DemandeDao demandeDao;
    @Autowired
    private BeneficiaireDao beneficiaireDao;

    @Autowired
    private ChambreDao chambreDao;
}
