package com.neoris.controller;

import com.neoris.dto.ClienteDTO;
import com.neoris.dto.CuentaDTO;
import com.neoris.service.CuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cuentas")
@CrossOrigin("*")
public class CuentaController {

    @Autowired
    CuentaService cuentaService;

    @PostMapping("save")
    public ResponseEntity<?> save(@RequestBody CuentaDTO cuentaDTO) throws Exception {
        return ResponseEntity.ok().body(cuentaService.save(cuentaDTO));
    }

    @GetMapping("findAll")
    public ResponseEntity<?> findAll() throws Exception {
        return ResponseEntity.ok().body(cuentaService.findAll());
    }

    @GetMapping("/{idCuenta}")
    public ResponseEntity<?> findById(@PathVariable Long idCuenta) throws Exception {
        return ResponseEntity.ok().body(cuentaService.findById(idCuenta));
    }

    @PutMapping("update")
    public ResponseEntity<?> update(@RequestBody CuentaDTO cuentaDTO) throws Exception {
        return ResponseEntity.ok().body(cuentaService.update(cuentaDTO));
    }

    @DeleteMapping("/{idCuenta}")
    public ResponseEntity<?> deleteById(@PathVariable Long idCuenta) throws Exception {
        return ResponseEntity.ok().body(cuentaService.deleteById(idCuenta));
    }
}
