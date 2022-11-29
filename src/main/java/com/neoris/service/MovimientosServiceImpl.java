package com.neoris.service;

import com.neoris.domain.Cliente;
import com.neoris.domain.Cuenta;
import com.neoris.domain.Movimientos;
import com.neoris.dto.ClienteDTO;
import com.neoris.dto.CuentaDTO;
import com.neoris.dto.MovimeintoDTO;
import com.neoris.dto.RespuestaGenericaDTO;
import com.neoris.mapper.MovimientoMapper;
import com.neoris.repository.CuentaRepository;
import com.neoris.repository.MovimientoRepository;
import com.neoris.specification.MovimentoSpecification;
import com.neoris.utility.Constantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MovimientosServiceImpl implements MovimientoService{

    @Autowired
    MovimientoRepository movimientoRepository;
    @Autowired
    CuentaRepository cuentaRepository;
    @Autowired
    MovimientoMapper movimientoMapper;

    @Override
    public RespuestaGenericaDTO findAll() {
        RespuestaGenericaDTO respuestaGenericaDTO = new RespuestaGenericaDTO();
        try{
            List<MovimeintoDTO> clienteDTOList = movimientoRepository.findAll().stream()
                    .map(movimiento -> movimientoMapper.movimientoToMovimientoDTO(movimiento)).collect(Collectors.toList());
            respuestaGenericaDTO.setExitoso(true);
            respuestaGenericaDTO.setData(clienteDTOList);
        }catch (Exception e){
            e.printStackTrace();
            respuestaGenericaDTO.setExitoso(false);
        }
        return respuestaGenericaDTO;
    }

    @Override
    public RespuestaGenericaDTO findById(Long idMovimiento) {
        RespuestaGenericaDTO respuestaGenericaDTO = new RespuestaGenericaDTO();
        try{
            Optional<Movimientos> movimientos = movimientoRepository.findById(idMovimiento);
            if(movimientos.isPresent()){
                MovimeintoDTO movimeintoDTO = movimientoMapper.movimientoToMovimientoDTO(movimientos.get());
                respuestaGenericaDTO.setData(movimeintoDTO);
            }
            respuestaGenericaDTO.setExitoso(true);
        }catch (Exception e){
            e.printStackTrace();
            respuestaGenericaDTO.setExitoso(false);
        }
        return respuestaGenericaDTO;
    }

    @Override
    @Transactional
    public RespuestaGenericaDTO save(MovimeintoDTO entity) throws Exception {
        RespuestaGenericaDTO  respuestaGenericaDTO = new RespuestaGenericaDTO();
        try{
            Movimientos movimientos = movimientoMapper.movimientoDtoToMovimiento(entity);
            Optional<Cuenta> cuenta = cuentaRepository.findById(entity.getCuenta().getCuentaId());
            if(cuenta.isPresent()){

                Long saldoTotal = cuenta.get().getSaldoActual() + entity.getValor();
                if(saldoTotal < 0){
                    respuestaGenericaDTO.setExitoso(false);
                    respuestaGenericaDTO.setMensajeError("No hay saldo suficiente para realizar la operación");
                }

                cuenta.get().setSaldoActual(saldoTotal);
                cuentaRepository.save(cuenta.get());
                movimientos.setSaldo(saldoTotal);
                movimientos.setTipoMovimiento(entity.getValor() < 0? Constantes.TIPO_RETIRO.getValue():Constantes.TIPO_DEPOSITO.getValue());
                movimientos.setCuenta(cuenta.get());
                movimientoRepository.save(movimientos);
            }

            respuestaGenericaDTO.setExitoso(true);
        }catch (Exception e){
            e.printStackTrace();
            respuestaGenericaDTO.setExitoso(false);
        }
        return respuestaGenericaDTO;
    }

    @Override
    public RespuestaGenericaDTO update(MovimeintoDTO entity) throws Exception {
        RespuestaGenericaDTO  respuestaGenericaDTO = new RespuestaGenericaDTO();
        try{
            Optional<Movimientos> movimientos = movimientoRepository.findById(entity.getMovimientoId());
            if(movimientos.isPresent()){
                Movimientos movimientoUpdate = movimientoMapper.movimientoDtoToMovimiento(entity);
                Optional<Cuenta> cuenta = cuentaRepository.findById(entity.getCuenta().getCuentaId());
                if(cuenta.isPresent()){
                    movimientoUpdate.setCuenta(cuenta.get());
                    movimientoRepository.save(movimientoUpdate);
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
    public RespuestaGenericaDTO deleteById(Long idMovimiento) throws Exception {
        RespuestaGenericaDTO  respuestaGenericaDTO = new RespuestaGenericaDTO();
        try{
            Optional<Movimientos> movimientos = movimientoRepository.findById(idMovimiento);
            if(movimientos.isPresent()){
                movimientoRepository.deleteById(idMovimiento);
            }
            respuestaGenericaDTO.setExitoso(true);
        }catch (Exception e){
            e.printStackTrace();
            respuestaGenericaDTO.setExitoso(false);
        }
        return respuestaGenericaDTO;
    }

    @Override
    public RespuestaGenericaDTO validate(MovimeintoDTO entity) throws Exception {
        return null;
    }

    @Override
    public RespuestaGenericaDTO filtrarPorFecha(Date fechaInicio, Date fechaFin) {
        RespuestaGenericaDTO respuestaGenericaDTO = new RespuestaGenericaDTO();
        try{
            Specification<Movimientos> specification = Specification.where(MovimentoSpecification.filtroFechas(fechaInicio,fechaFin));

            List<MovimeintoDTO> clienteDTOList = movimientoRepository.findAll(specification).stream()
                    .map(movimiento -> movimientoMapper.movimientoToMovimientoDTO(movimiento)).collect(Collectors.toList());
            respuestaGenericaDTO.setExitoso(true);
            respuestaGenericaDTO.setData(clienteDTOList);
        }catch (Exception e){
            e.printStackTrace();
            respuestaGenericaDTO.setExitoso(false);
        }
        return respuestaGenericaDTO;
    }
}
