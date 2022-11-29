package com.neoris.service;

import com.neoris.dto.RespuestaGenericaDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface GenericService<T, ID> {


	public RespuestaGenericaDTO findAll();

	public RespuestaGenericaDTO findById(ID id);

	public RespuestaGenericaDTO save(T entity) throws Exception;

	public RespuestaGenericaDTO update(T entity) throws Exception;

	public RespuestaGenericaDTO deleteById(ID id) throws Exception;

	public RespuestaGenericaDTO validate(T entity) throws Exception;

}
