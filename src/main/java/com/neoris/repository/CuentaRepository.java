package com.neoris.repository;

import com.neoris.domain.Cliente;
import com.neoris.domain.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CuentaRepository extends JpaRepository<Cuenta,Long> {
}
