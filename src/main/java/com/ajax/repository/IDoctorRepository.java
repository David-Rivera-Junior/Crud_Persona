package com.ajax.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ajax.model.Doctor;

@Repository
public interface IDoctorRepository extends CrudRepository<Doctor, Integer> {

}
