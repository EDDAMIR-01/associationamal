package com.example.associationamal.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.List;

@Entity
public class Chambre {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String ref;
    private boolean disponible;
    private int capacite;
    private int oreiller_de_couchage;
    private int couverture;
    @ManyToOne
    private Etage etage;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "chambre")
    private List<Beneficiaire> beneficiaires;

    public List<Beneficiaire> getBeneficiaires() {
        return beneficiaires;
    }

    public void setBeneficiaires(List<Beneficiaire> beneficiaires) {
        this.beneficiaires = beneficiaires;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public boolean getDisponible() {
        return disponible;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public int getCapacite() {
        return capacite;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

    public int getOreiller_de_couchage() {
        return oreiller_de_couchage;
    }

    public void setOreiller_de_couchage(int oreiller_de_couchage) {
        this.oreiller_de_couchage = oreiller_de_couchage;
    }

    public int getCouverture() {
        return couverture;
    }

    public void setCouverture(int couverture) {
        this.couverture = couverture;
    }

    public Etage getEtage() {
        return etage;
    }

    public void setEtage(Etage etage) {
        this.etage = etage;
    }
}
