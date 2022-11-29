package com.neoris.controller;

import com.neoris.dto.ClienteDTO;
import com.neoris.dto.MovimeintoDTO;
import com.neoris.service.MovimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/movimientos")
@CrossOrigin("*")
public class MovimientosController {

    @Autowired
    MovimientoService movimientoService;

    @PostMapping("save")
    public ResponseEntity<?> save(@RequestBody MovimeintoDTO movimeintoDTO) throws Exception {
        return ResponseEntity.ok().body(movimientoService.save(movimeintoDTO));
    }

    @GetMapping("findAll")
    public ResponseEntity<?> findAll() throws Exception {
        return ResponseEntity.ok().body(movimientoService.findAll());
    }

    @GetMapping("/{idMovimiento}")
    public ResponseEntity<?> findById(@PathVariable Long idMovimiento) throws Exception {
        return ResponseEntity.ok().body(movimientoService.findById(idMovimiento));
    }

    @PutMapping("update")
    public ResponseEntity<?> update(@RequestBody MovimeintoDTO movimeintoDTO) throws Exception {
        return ResponseEntity.ok().body(movimientoService.update(movimeintoDTO));
    }

    @DeleteMapping("/{idMovimiento}")
    public ResponseEntity<?> deleteById(@PathVariable Long idMovimiento) throws Exception {
        return ResponseEntity.ok().body(movimientoService.deleteById(idMovimiento));
    }

    @GetMapping("/{fechaInicio}/{fechaFin}")
    public ResponseEntity<?> filtrarPorFecha(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaInicio, @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaFin) throws Exception {
        return ResponseEntity.ok().body(movimientoService.filtrarPorFecha(fechaInicio,fechaFin));
    }
}
