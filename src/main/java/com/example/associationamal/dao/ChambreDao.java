package com.example.associationamal.dao;

import com.example.associationamal.bean.Chambre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChambreDao extends JpaRepository<Chambre,Long> {
    Chambre findByRef(String ref);
    int deleteByRef(String ref);
    int deleteByEtageRef(String ref);
}
