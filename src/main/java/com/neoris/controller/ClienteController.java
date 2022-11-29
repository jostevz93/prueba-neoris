package com.neoris.controller;

import com.neoris.dto.ClienteDTO;
import com.neoris.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes")
@CrossOrigin("*")
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @PostMapping("save")
    public ResponseEntity<?> save(@RequestBody ClienteDTO clienteDTO) throws Exception {
        return ResponseEntity.ok().body(clienteService.save(clienteDTO));
    }

    @GetMapping("findAll")
    public ResponseEntity<?> findAll() throws Exception {
        return ResponseEntity.ok().body(clienteService.findAll());
    }

    @GetMapping("/{idCliente}")
    public ResponseEntity<?> findById(@PathVariable Long idCliente) throws Exception {
        return ResponseEntity.ok().body(clienteService.findById(idCliente));
    }

    @PutMapping("update")
    public ResponseEntity<?> update(@RequestBody ClienteDTO clienteDTO) throws Exception {
        return ResponseEntity.ok().body(clienteService.update(clienteDTO));
    }

    @DeleteMapping("/{idCliente}")
    public ResponseEntity<?> deleteById(@PathVariable Long idCliente) throws Exception {
        return ResponseEntity.ok().body(clienteService.deleteById(idCliente));
    }
}
