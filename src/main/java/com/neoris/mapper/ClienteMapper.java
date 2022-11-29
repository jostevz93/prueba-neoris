package com.neoris.mapper;

import com.neoris.domain.Cliente;
import com.neoris.dto.ClienteDTO;
import org.mapstruct.Mapper;

@Mapper
public interface ClienteMapper {

    Cliente clienteDtoToCliente(ClienteDTO clienteDTO);

    ClienteDTO clienteToClienteDTO(Cliente cliente);
}
