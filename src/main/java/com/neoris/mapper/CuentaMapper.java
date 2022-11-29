package com.neoris.mapper;

import com.neoris.domain.Cliente;
import com.neoris.domain.Cuenta;
import com.neoris.dto.ClienteDTO;
import com.neoris.dto.CuentaDTO;
import org.mapstruct.Mapper;

@Mapper
public interface CuentaMapper {

    Cuenta cuentaDtoToCuenta(CuentaDTO clienteDTO);

    CuentaDTO ccuentaToCuentaDTO(Cuenta cuenta);
}
