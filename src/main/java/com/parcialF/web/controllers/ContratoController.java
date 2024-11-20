package com.parcialF.web.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

//importar DTOs y services
import com.parcialF.web.DTOs.ContratoDTO;
import com.parcialF.web.services.ContratoService;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping( value = "/api/contratos")
public class ContratoController {

    // Inyección de dependencias
    @Autowired
    private ContratoService contratoService;

    // CRUD Endpoints

    //get
    @CrossOrigin
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ContratoDTO> get() {
        return contratoService.get();
    }

    //get por id
    @CrossOrigin
    @GetMapping( value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ContratoDTO obtenerContratoPorId(@PathVariable Long id) {
        return contratoService.obtenerContratoPorId(id);
    }

    // Create
    @CrossOrigin
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ContratoDTO crearContrato(@RequestBody ContratoDTO contratoDTO) {
        return contratoService.crearContrato(contratoDTO);
    }

    // Update
    /// TOCA INCLUIR EN EL BODY DE LA PETICION DE POSTMAN EL ID DEL QUE QUIERO ACTUALIZAR ///
    @CrossOrigin
    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ContratoDTO actualizarContrato(@RequestBody ContratoDTO contratoDTO) {
        return contratoService.actualizarContrato(contratoDTO);
    }

    // Delete
    @CrossOrigin
    @DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public void eliminarContrato(@RequestBody ContratoDTO contratoDTO) {
        contratoService.eliminarContrato(contratoDTO);
    }

    // Delete by id
    @CrossOrigin
    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void eliminarContrato(@PathVariable Long id) {
        contratoService.eliminarContratoPorId(id);
    }
}
