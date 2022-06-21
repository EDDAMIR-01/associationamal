package com.example.associationamal.ws;


import com.example.associationamal.bean.Beneficiaire;
import com.example.associationamal.service.BeneficierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("association-amal/beneficiaire/")
public class BeneficiaireProvided {
    @PostMapping()
    public int save(@RequestBody Beneficiaire beneficiaire) {
        return beneficierService.save(beneficiaire);
    }
    @GetMapping("cni/{cni}")
    public Beneficiaire findByCni(@PathVariable String cni) {
        return beneficierService.findByCni(cni);
    }

    @DeleteMapping("cni/{cni}")
    public int deleteByCni(@PathVariable String cni) {
        return beneficierService.deleteByCni(cni);
    }
    @GetMapping("")
    public List<Beneficiaire> findAll() {
        return beneficierService.findAll();
    }

    @Autowired
    private BeneficierService beneficierService;
}
