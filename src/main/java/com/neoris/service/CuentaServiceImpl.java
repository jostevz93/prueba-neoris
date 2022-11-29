package com.neoris.service;

import com.neoris.domain.Cliente;
import com.neoris.domain.Cuenta;
import com.neoris.dto.ClienteDTO;
import com.neoris.dto.CuentaDTO;
import com.neoris.dto.RespuestaGenericaDTO;
import com.neoris.mapper.ClienteMapper;
import com.neoris.mapper.CuentaMapper;
import com.neoris.repository.ClienteRepository;
import com.neoris.repository.CuentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CuentaServiceImpl implements CuentaService{

    @Autowired
    CuentaRepository cuentaRepository;
    @Autowired
    ClienteRepository clienteRepository;
    @Autowired
    CuentaMapper cuentaMapper;
    @Autowired
    ClienteMapper clienteMapper;

    @Override
    public RespuestaGenericaDTO findAll() {
        RespuestaGenericaDTO respuestaGenericaDTO = new RespuestaGenericaDTO();
        try{
            List<CuentaDTO> clienteDTOList = cuentaRepository.findAll().stream()
                    .map(cuenta -> llenarCuenta(cuenta)).collect(Collectors.toList());
            respuestaGenericaDTO.setExitoso(true);
            respuestaGenericaDTO.setData(clienteDTOList);
        }catch (Exception e){
            e.printStackTrace();
            respuestaGenericaDTO.setExitoso(false);
        }
        return respuestaGenericaDTO;
    }

    @Override
    public RespuestaGenericaDTO findById(Long idCuenta) {
        RespuestaGenericaDTO respuestaGenericaDTO = new RespuestaGenericaDTO();
        try{
            Optional<Cuenta> cuenta = cuentaRepository.findById(idCuenta);
            if(cuenta.isPresent()){
                CuentaDTO cuentaDTO = llenarCuenta(cuenta.get());
                respuestaGenericaDTO.setData(cuentaDTO);
            }
            respuestaGenericaDTO.setExitoso(true);
        }catch (Exception e){
            e.printStackTrace();
            respuestaGenericaDTO.setExitoso(false);
        }
        return respuestaGenericaDTO;
    }

    @Override
    public RespuestaGenericaDTO save(CuentaDTO entity) throws Exception {
        RespuestaGenericaDTO  respuestaGenericaDTO = new RespuestaGenericaDTO();
        try{
            Cuenta cuenta = cuentaMapper.cuentaDtoToCuenta(entity);
            Optional<Cliente> cliente = clienteRepository.findById(entity.getClienteDTO().getClienteId());
            if(cliente.isPresent()){
                cuenta.setCliente(cliente.get());
                cuenta.setSaldoActual(entity.getSaldoInicial());
                cuentaRepository.save(cuenta);
            }

            respuestaGenericaDTO.setExitoso(true);
        }catch (Exception e){
            e.printStackTrace();
            respuestaGenericaDTO.setExitoso(false);
        }
        return respuestaGenericaDTO;
    }

    @Override
    public RespuestaGenericaDTO update(CuentaDTO entity) throws Exception {
        RespuestaGenericaDTO  respuestaGenericaDTO = new RespuestaGenericaDTO();
        try{
            Optional<Cuenta> cuenta = cuentaRepository.findById(entity.getCuentaId());
            if(cuenta.isPresent()){
                Cuenta cuentaUpdate = cuentaMapper.cuentaDtoToCuenta(entity);
                Optional<Cliente> cliente = clienteRepository.findById(entity.getClienteDTO().getClienteId());
                if(cliente.isPresent()){
                    cuentaUpdate.setCliente(cliente.get());
                    cuentaUpdate.setSaldoActual(cuenta.get().getSaldoActual());
                    cuentaRepository.save(cuentaUpdate);
                }

            }


            respuestaGenericaDTO.setExitoso(true);
        }catch (Exception e){
            e.printStackTrace();
            respuestaGenericaDTO.setExitoso(false);
        }
        return respuestaGenericaDTO;
    }

    @Override
    public RespuestaGenericaDTO deleteById(Long idcuenta) throws Exception {
        RespuestaGenericaDTO  respuestaGenericaDTO = new RespuestaGenericaDTO();
        try{
            Optional<Cuenta> cuenta = cuentaRepository.findById(idcuenta);
            if(cuenta.isPresent()){
                cuentaRepository.deleteById(idcuenta);
            }
            respuestaGenericaDTO.setExitoso(true);
        }catch (Exception e){
            e.printStackTrace();
            respuestaGenericaDTO.setExitoso(false);
        }
        return respuestaGenericaDTO;
    }

    @Override
    public RespuestaGenericaDTO validate(CuentaDTO entity) throws Exception {
        return null;
    }

    private CuentaDTO llenarCuenta(Cuenta cuenta){
        CuentaDTO cuentaDTO = cuentaMapper.ccuentaToCuentaDTO(cuenta);
        ClienteDTO clienteDTO = clienteMapper.clienteToClienteDTO(cuenta.getCliente());
        cuentaDTO.setClienteDTO(clienteDTO);
        return cuentaDTO;
    }
}
