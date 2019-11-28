package com.ajax.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ajax.model.Consulta;

@Repository
	public interface IConsultaRepository extends CrudRepository<Consulta, Integer>{

}
