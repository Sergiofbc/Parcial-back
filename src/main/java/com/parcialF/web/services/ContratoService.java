package com.parcialF.web.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parcialF.web.DTOs.ContratoDTO;
import com.parcialF.web.models.Contrato;
import com.parcialF.web.repositories.ContratoRepository;

@Service
public class ContratoService {
    @Autowired
    private ContratoRepository contratoRepository;

    @Autowired
    private ModelMapper modelMapper;

    //se van a retornar DTOs

    //get
    public List<ContratoDTO> get() {
        List<Contrato> contratos = contratoRepository.findAll();
        List<ContratoDTO> contratosDTO = contratos.stream() 
                                       .map(contrato -> modelMapper.map(contrato, ContratoDTO.class))
                                       .collect(Collectors.toList());   
        return contratosDTO;
    }

    //get por id
    public ContratoDTO obtenerContratoPorId(Long id) {
        Optional<Contrato> contrato = contratoRepository.findById(id); 
        ContratoDTO contratoDTO = null;
        if (contrato.isPresent()) {
            contratoDTO = modelMapper.map(contrato.get(), ContratoDTO.class);
        }
        return contratoDTO;
    }

    //post
    public ContratoDTO crearContrato(ContratoDTO contratoDTO) {
        Contrato contrato = modelMapper.map(contratoDTO, Contrato.class);
        contrato = contratoRepository.save(contrato);
        return modelMapper.map(contrato, ContratoDTO.class);
    }

    //put
    public ContratoDTO actualizarContrato(ContratoDTO contratoDTO) {
        Contrato contrato;
        if (contratoDTO.getContratoId() != null && contratoRepository.existsById(contratoDTO.getContratoId())) {
            contrato = contratoRepository.findById(contratoDTO.getContratoId()).orElseThrow(() -> new RuntimeException("Contrato no encontrado"));
            modelMapper.map(contratoDTO, contrato); 
        } else {
            throw new IllegalArgumentException("El ID del contrato es requerido para crear un nuevo contrato.");
        }
        contrato = contratoRepository.save(contrato);
        return modelMapper.map(contrato, ContratoDTO.class);
    }

    //delete
    public void eliminarContrato(ContratoDTO contratoDTO) {
        Contrato contrato = modelMapper.map(contratoDTO, Contrato.class);
        contratoRepository.delete(contrato);
    }

    //delete por id
    public void eliminarContratoPorId(Long id) {
        contratoRepository.deleteById(id);
    }
}
