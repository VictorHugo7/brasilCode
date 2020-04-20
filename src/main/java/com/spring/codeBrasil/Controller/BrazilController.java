package com.spring.codeBrasil.Controller;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.spring.codeBrasil.Service.BrazilService;
import com.spring.codeBrasil.model.Brazil;
import javax.validation.Valid;


@Api(value="API Rest Estados Brasileiros")
@RestController("/brazil")
@RequestMapping

public class BrazilController {
   @Autowired
    private BrazilService service;

    @GetMapping("/brazil")
    @ApiOperation(value="Retorna liste de Estados do Brasil")
    public ResponseEntity<?> listAll() {
        return service.findAll();
    }

    @PostMapping("/brazil")
    @ApiOperation(value="Adiciona um novo Estado")
    public ResponseEntity<?> add(@RequestBody Brazil brazil){
        return service.add(brazil);
    }


    @GetMapping("/brazil/{id}")
    @ApiOperation(value="Retorna um Estado específico buscando por ID")
    public ResponseEntity<?> getStateById(@PathVariable(value = "id") @Valid Long id){
        return service.findById(id);
    }

    @DeleteMapping("/brazil/{id}")
    @ApiOperation(value="Exluir um Estado")
    public ResponseEntity<?> deleteStateById(@PathVariable(value ="id") @Valid Long id){
        return service.deleteStateById(id);
    }


    @PutMapping("/brazil/{id}")
    @ApiOperation(value="Atualiza um Estado")
    public ResponseEntity<?> putStateById(@RequestBody @Valid Brazil brazil){
        return service.putStateById(brazil);
    }

}
