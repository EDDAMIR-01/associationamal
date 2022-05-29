package com.example.associationamal.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.List;

@Entity
public class Etage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String ref;
    private int numero;
    private String nbrchambre;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "etage")
    private List<Chambre> chambre;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNbrchambre() {
        return nbrchambre;
    }

    public void setNbrchambre(String nbrchambre) {
        this.nbrchambre = nbrchambre;
    }

    public List<Chambre> getChambre() {
        return chambre;
    }

    public void setChambre(List<Chambre> chambre) {
        this.chambre = chambre;
    }
}
