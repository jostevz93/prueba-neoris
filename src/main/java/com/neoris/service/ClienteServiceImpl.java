package com.neoris.service;

import com.neoris.domain.Cliente;
import com.neoris.dto.ClienteDTO;
import com.neoris.dto.RespuestaGenericaDTO;
import com.neoris.mapper.ClienteMapper;
import com.neoris.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClienteServiceImpl implements ClienteService{

    @Autowired
    ClienteRepository clienteRepository;
    @Autowired
    ClienteMapper clienteMapper;

    @Override
    public RespuestaGenericaDTO findAll() {
        RespuestaGenericaDTO respuestaGenericaDTO = new RespuestaGenericaDTO();
        try{
            List<ClienteDTO>clienteDTOList = clienteRepository.findAll().stream()
                    .map(cliente -> clienteMapper.clienteToClienteDTO(cliente)).collect(Collectors.toList());
            respuestaGenericaDTO.setExitoso(true);
            respuestaGenericaDTO.setData(clienteDTOList);
        }catch (Exception e){
            e.printStackTrace();
            respuestaGenericaDTO.setExitoso(false);
        }
        return respuestaGenericaDTO;
    }

    @Override
    public RespuestaGenericaDTO findById(Long idCliente) {
        RespuestaGenericaDTO respuestaGenericaDTO = new RespuestaGenericaDTO();
        try{
            Optional<Cliente> cliente = clienteRepository.findById(idCliente);
            if(cliente.isPresent()){
                ClienteDTO clienteDTO = clienteMapper.clienteToClienteDTO(cliente.get());
                respuestaGenericaDTO.setData(clienteDTO);
            }
            respuestaGenericaDTO.setExitoso(true);
        }catch (Exception e){
            e.printStackTrace();
            respuestaGenericaDTO.setExitoso(false);
        }
        return respuestaGenericaDTO;
    }

    @Override
    public RespuestaGenericaDTO save(ClienteDTO entity) throws Exception {
        RespuestaGenericaDTO  respuestaGenericaDTO = new RespuestaGenericaDTO();
        try{
            Cliente cliente = clienteMapper.clienteDtoToCliente(entity);
            clienteRepository.save(cliente);
            respuestaGenericaDTO.setExitoso(true);
        }catch (Exception e){
            e.printStackTrace();
            respuestaGenericaDTO.setExitoso(false);
        }
        return respuestaGenericaDTO;
    }

    @Override
    public RespuestaGenericaDTO update(ClienteDTO entity) throws Exception {
        RespuestaGenericaDTO  respuestaGenericaDTO = new RespuestaGenericaDTO();
        try{
            Optional<Cliente> cliente = clienteRepository.findById(entity.getClienteId());
            if(cliente.isPresent()){
                Cliente clienteUpdate = clienteMapper.clienteDtoToCliente(entity);
                clienteRepository.save(clienteUpdate);
            }
            respuestaGenericaDTO.setExitoso(true);
        }catch (Exception e){
            e.printStackTrace();
            respuestaGenericaDTO.setExitoso(false);
        }
        return respuestaGenericaDTO;
    }


    @Override
    public RespuestaGenericaDTO deleteById(Long idCliente) throws Exception {
        RespuestaGenericaDTO  respuestaGenericaDTO = new RespuestaGenericaDTO();
        try{
            Optional<Cliente> cliente = clienteRepository.findById(idCliente);
            if(cliente.isPresent()){
                clienteRepository.deleteById(idCliente);
            }
            respuestaGenericaDTO.setExitoso(true);
        }catch (Exception e){
            e.printStackTrace();
            respuestaGenericaDTO.setExitoso(false);
        }
        return respuestaGenericaDTO;
    }

    @Override
    public RespuestaGenericaDTO validate(ClienteDTO entity) throws Exception {
        return null;
    }
}
