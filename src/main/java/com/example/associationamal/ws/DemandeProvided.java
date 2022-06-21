package com.example.associationamal.ws;


import com.example.associationamal.bean.Demande;
import com.example.associationamal.service.DemandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("association-amal/demande/")
public class DemandeProvided {
    @PostMapping()
    public int save(@RequestBody Demande demande) {
        return demandeService.save(demande);
    }

    @GetMapping("ref/{ref}")
    public Demande findByRef(@PathVariable String ref) {
        return demandeService.findByRef(ref);
    }

    @DeleteMapping("ref/{ref}")
    public int deleteByRef(@PathVariable String ref) {
        return demandeService.deleteByRef(ref);
    }

    @GetMapping("")
    public List<Demande> findAll() {
        return demandeService.findAll();
    }

    @Autowired
    private DemandeService demandeService;
}
