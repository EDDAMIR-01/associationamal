package com.example.associationamal.dao;

import com.example.associationamal.bean.Demande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DemandeDao extends JpaRepository<Demande,Long> {
    Demande findByRef(String ref);
    int deleteByRef(String ref);

}
