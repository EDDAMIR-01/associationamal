package com.example.associationamal.ws;


import com.example.associationamal.bean.Etage;
import com.example.associationamal.service.EtageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("association-amal/etage/")
public class EtageProvided {
    @PostMapping()
    public int save(@RequestBody Etage etage) {
        return etageService.save(etage);
    }

    @GetMapping("ref/{ref}")
    public Etage findByRef(@PathVariable String ref) {
        return etageService.findByRef(ref);
    }

    @DeleteMapping("ref/{ref}")
    public int deleteByRef(@PathVariable String ref) {
        return etageService.deleteByRef(ref);
    }

    @GetMapping("")
    public List<Etage> findAll() {
        return etageService.findAll();
    }

    @Autowired
    private EtageService etageService;
}
