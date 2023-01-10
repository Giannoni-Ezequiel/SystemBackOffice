package com.Crisalis.demo.controller;

import com.Crisalis.demo.model.DTO.ImpuestoDTO;
import com.Crisalis.demo.model.Impuesto;
import com.Crisalis.demo.service.ImpuestoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("impuestos")
public class ImpuestoController {

    private final ImpuestoService impuestoService;
    @Autowired
    public ImpuestoController(ImpuestoService impuestoService)
    {
        this.impuestoService = impuestoService;
    }

    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Impuesto saveImpuesto(@RequestBody ImpuestoDTO impuestoDTO)
    {
        return this.impuestoService.saveImpuesto(impuestoDTO);
    }
}
