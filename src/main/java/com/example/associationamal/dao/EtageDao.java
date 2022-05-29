package com.example.associationamal.dao;

import com.example.associationamal.bean.Chambre;
import com.example.associationamal.bean.Etage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EtageDao extends JpaRepository<Etage,Long> {
    Etage findByRef(String ref);
    int deleteByRef(String ref);
}
