package com.parcialF.web.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

import com.parcialF.web.models.Contrato;

public interface ContratoRepository extends JpaRepository<Contrato, Long> {
    //metodos de consulta
}
