package com.neoris.repository;

import com.neoris.domain.Cliente;
import com.neoris.domain.Movimientos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MovimientoRepository extends JpaRepository<Movimientos,Long>, JpaSpecificationExecutor<Movimientos> {
}
