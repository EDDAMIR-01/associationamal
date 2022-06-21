package com.example.associationamal.ws;


import com.example.associationamal.bean.Chambre;
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
    @GetMapping("cni/{cni}/refchambre/{refchambre}")
    public int addbeneficier(@PathVariable String cni, @PathVariable String refchambre) {
        return chambreService.addbeneficier(cni, refchambre);
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
}
