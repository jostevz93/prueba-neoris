package com.neoris.service;

import com.neoris.dto.MovimeintoDTO;
import com.neoris.dto.RespuestaGenericaDTO;

import java.util.Date;

public interface MovimientoService extends GenericService<MovimeintoDTO,Long>{

    public RespuestaGenericaDTO filtrarPorFecha(Date fechaInicio, Date fechaFin);
}
