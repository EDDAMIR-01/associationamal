package com.example.associationamal.service;

import com.example.associationamal.bean.Beneficiaire;
import com.example.associationamal.bean.Chambre;
import com.example.associationamal.dao.BeneficiaireDao;
import com.example.associationamal.dao.ChambreDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class BeneficierService {

    public int save(Beneficiaire beneficiaire) {
        Chambre chambre = chambreDao.findByRef(beneficiaire.getChambre().getRef());
        if (findByCni(beneficiaire.getCni()) != null) {
            return -1;
        } else if (chambre == null) {
            return -2;
        } else if (!chambre.isDisponible()) {
            return -3;
        } else {
            beneficiaire.setChambre(chambre);
            beneficiaireDao.save(beneficiaire);
            return 1;
        }
    }

    public Beneficiaire findByCni(String cni) {
        return beneficiaireDao.findByCni(cni);
    }

    @Transactional
    public int deleteByCni(String cni) {
        return beneficiaireDao.deleteByCni(cni);
    }

    public List<Beneficiaire> findAll() {
        return beneficiaireDao.findAll();
    }

    @Transactional
    public int deleteByChambreRef(String ref) {
        return beneficiaireDao.deleteByChambreRef(ref);
    }

    @Autowired
    private BeneficiaireDao beneficiaireDao;
    @Autowired
    private ChambreDao chambreDao;
}
