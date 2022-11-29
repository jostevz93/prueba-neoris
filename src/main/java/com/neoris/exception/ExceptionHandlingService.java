package com.neoris.exception;


import com.neoris.dto.RespuestaGenericaDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;

import java.util.concurrent.Callable;

public class ExceptionHandlingService {
    private static final Logger logger = LoggerFactory.getLogger(ExceptionHandlingService.class);

    public static ResponseEntity<?> handleControllerException(Callable<?> metodo) {
        RespuestaGenericaDTO respuestaGenericaDTO = new RespuestaGenericaDTO();
        try {
            respuestaGenericaDTO.setData(metodo.call());
            respuestaGenericaDTO.setExitoso(true);
        }catch(NegocioException e) {
            logger.error("Error de negocio", e);
            respuestaGenericaDTO.setExitoso(false);
            respuestaGenericaDTO.setMensajeError(e.getMessage());
        }
        catch (Exception e) {
            logger.error("Error general", e);
            respuestaGenericaDTO.setExitoso(false);
            respuestaGenericaDTO.setMensajeError(NegocioException.ERROR_GENERAL);
        }
        return ResponseEntity.ok(respuestaGenericaDTO);
    }
}
