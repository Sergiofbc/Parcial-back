package com.parcialF.web.DTOs;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContratoDTO {
    private Long contratoId;
    private String identificador;
    private Double valor;
    private String nombre_contratante;
    private String documento_contratante;
    private String nombre_contratista;
    private String documento_contratista;
    private Date fecha_inicial;
    private Date fecha_final;
}