package com.neoris.mapper;

import com.neoris.domain.Cliente;
import com.neoris.domain.Movimientos;
import com.neoris.dto.ClienteDTO;
import com.neoris.dto.MovimeintoDTO;
import org.mapstruct.Mapper;

@Mapper
public interface MovimientoMapper {

    Movimientos movimientoDtoToMovimiento(MovimeintoDTO movimeintoDTO);

    MovimeintoDTO movimientoToMovimientoDTO(Movimientos movimeinto);
}
