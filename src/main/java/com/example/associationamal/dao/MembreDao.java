package com.example.associationamal.dao;

import com.example.associationamal.bean.Membre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MembreDao extends JpaRepository<Membre,Long> {
    Membre findByCni(String cni);
    int deleteByCni(String cni);

}
