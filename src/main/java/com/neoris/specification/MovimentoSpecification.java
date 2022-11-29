package com.neoris.specification;

import com.neoris.domain.Movimientos;
import org.springframework.data.jpa.domain.Specification;

import java.util.Date;

public class MovimentoSpecification {

    public static Specification<Movimientos> filtroFechas(Date fechaInicio, Date fechaFin){
        return (root,query,builder)->{
            if(fechaInicio != null && fechaFin != null){
                return builder.between(root.get("fecha"), fechaInicio, fechaFin);
            }
            return null;
        };
    }
}
