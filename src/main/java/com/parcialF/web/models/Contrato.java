package com.parcialF.web.models;

import java.sql.Date;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Contrato")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Contrato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
