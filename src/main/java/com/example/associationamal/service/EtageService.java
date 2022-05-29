package com.example.associationamal.service;

import com.example.associationamal.bean.Etage;
import com.example.associationamal.dao.ChambreDao;
import com.example.associationamal.dao.EtageDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class EtageService {
    public int save(Etage etage) {
        if (findByRef(etage.getRef()) != null) {
            return -1;
        } else {
            etage.setChambre(null);
            etageDao.save(etage);
            return 1;
        }
    }

    /*
    public int save2(Etage etage){
        //save etage m3a bzzf nta3 les chambre de9a whda
    }*/
    public Etage findByRef(String ref) {
        return etageDao.findByRef(ref);
    }

    @Transactional
    public int deleteByRef(String ref) {
        int resultChambre = chambreService.deleteByEtageRef(ref);
        int resultEtage = etageDao.deleteByRef(ref);
        return resultEtage + resultChambre;
    }

    public List<Etage> findAll() {
        return etageDao.findAll();
    }

    @Autowired
    private EtageDao etageDao;
    @Autowired
    private ChambreDao chambreDao;
    @Autowired
    private ChambreService chambreService;
}
