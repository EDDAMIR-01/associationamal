package com.example.associationamal.ws;

import com.example.associationamal.bean.Beneficiaire;
import com.example.associationamal.bean.Membre;
import com.example.associationamal.service.BeneficierService;
import com.example.associationamal.service.MembreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("association-amal/membre/")
public class MembreProvided {
    @PostMapping()
    public int save(@RequestBody Membre membre) {
        return membreService.save(membre);
    }
    @GetMapping("cni/{cni}")
    public Membre findByCni(@PathVariable String cni) {
        return membreService.findByCni(cni);
    }

    @DeleteMapping("cni/{cni}")
    public int deleteByCni(@PathVariable String cni) {
        return membreService.deleteByCni(cni);
    }

    @GetMapping("")
    public List<Membre> findAll() {
        return membreService.findAll();
    }
    @Autowired
    private MembreService membreService;
}
