package com.example.associationamal.ws;


import com.example.associationamal.bean.Beneficiaire;
import com.example.associationamal.bean.Chambre;
import com.example.associationamal.service.BeneficierService;
import com.example.associationamal.service.ChambreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("association-amal/chambre/")
public class ChambreProvided {
    @PostMapping()
    public int save(@RequestBody Chambre chambre) {
        return chambreService.save(chambre);
    }
    @PostMapping("refchambre/{refchambre}")
    public int addbeneficier(@RequestBody Beneficiaire bnf, @PathVariable String refchambre) {
        beneficierService.create(bnf);
        return chambreService.addbeneficier(bnf.getCni(), refchambre);
    }
    @GetMapping("refchambre/{refchambre}")
    public List<Beneficiaire> listbeneficier(@PathVariable String refchambre) {
        return chambreService.listbeneficier(refchambre);
    }
    @GetMapping("ref/{ref}")
    public Chambre findByRef(@PathVariable String ref) {
        return chambreService.findByRef(ref);
    }

    @DeleteMapping("ref/{ref}")
    public int deleteByRef(@PathVariable String ref) {
        return chambreService.deleteByRef(ref);
    }
    @GetMapping("")
    public List<Chambre> findAll() {
        return chambreService.findAll();
    }

    @Autowired
    private ChambreService chambreService;
    @Autowired
    private BeneficierService beneficierService;
}
