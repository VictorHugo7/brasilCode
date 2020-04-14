package com.spring.codeBrasil.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.codeBrasil.Service.BrazilService;
import com.spring.codeBrasil.model.Brazil;

@RestController
@RequestMapping("brazil")
public class BrazilController {
   @Autowired
    private BrazilService service;

    @GetMapping
    public ResponseEntity<?> listAll() {
        return service.findAll();
    }
    
    @PostMapping
    public ResponseEntity<?> add(@RequestBody Brazil brazil) {
        return service.add(brazil);
    }
    

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getStateById(@PathVariable("id") Long id){
        return service.findById(id);
    }
    
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> deleteStateById(@PathVariable("id") Long id){
        return service.deleteStateById(id);
    }


}
