package com.example.associationamal.service;

import com.example.associationamal.bean.Beneficiaire;
import com.example.associationamal.bean.Chambre;
import com.example.associationamal.bean.Etage;
import com.example.associationamal.dao.BeneficiaireDao;
import com.example.associationamal.dao.ChambreDao;
import com.example.associationamal.dao.EtageDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ChambreService {

    public int save(Chambre chambre) {
        Etage etage = etageDao.findByRef(chambre.getEtage().getRef());
        if (findByRef(chambre.getRef()) != null) {
            return -1;
        } else if (etage == null) {
            return -2;
        } else {
            chambre.setEtage(etage);
            chambre.setBeneficiaires(null);
            chambreDao.save(chambre);
            return 1;
        }
    }

    public int addbeneficier(String cni, String refchambre) {
        Beneficiaire beneficiaire = beneficiaireDao.findByCni(cni);
        Chambre chambre = findByRef(refchambre);
        if (chambre.getCapacite() > chambre.getBeneficiaires().size()) {
            chambre.getBeneficiaires().add(beneficiaire);
            chambreDao.save(chambre);
            return 1;
        } else {
            return -1;
        }
    }
    public List<Beneficiaire> listbeneficier(String refchambre) {
        Chambre chambre = findByRef(refchambre);
        return chambre.getBeneficiaires();
        }
    public Chambre findByRef(String ref) {
        return chambreDao.findByRef(ref);
    }

    public int modifier(String ref) {
        Chambre chambre = chambreDao.findByRef(ref);
        if(chambre.getDisponible()){
            chambre.setDisponible(false);
            chambreDao.save(chambre);
        }else {
            chambre.setDisponible(true);
            chambreDao.save(chambre);
        }
        return 1;
    }

    @Transactional
    public int deleteByRef(String ref) {
        int resultbeneficiaire = beneficierService.deleteByChambreRef(ref);
        int resultchambre = chambreDao.deleteByRef(ref);
        return resultbeneficiaire + resultchambre;
    }

    public List<Chambre> findAll() {
        return chambreDao.findAll();
    }

    public List<Chambre> findAvailabble() {
        List<Chambre> chambres = chambreDao.findAll();
        for (int i = 0 ; i < chambres.size(); i++) {
            if (!chambres.get(i).getDisponible()){
                chambres.remove(i);
                if (chambres.size() == 0) {
                    break;
                }
                i--;
            }
        }
        return chambres;
    }
    @Transactional
    public int deleteByEtageRef(String ref) {
        return chambreDao.deleteByEtageRef(ref);
    }

    @Autowired
    private ChambreDao chambreDao;
    @Autowired
    private EtageDao etageDao;
    @Autowired
    private BeneficiaireDao beneficiaireDao;
    @Autowired
    private BeneficierService beneficierService;

}
