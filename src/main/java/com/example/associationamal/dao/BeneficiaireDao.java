package com.example.associationamal.dao;

import com.example.associationamal.bean.Beneficiaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BeneficiaireDao extends JpaRepository<Beneficiaire,Long> {
    Beneficiaire findByCni(String cni);
    int deleteByCni(String cni);

    int deleteByChambreRef(String ref);
}
