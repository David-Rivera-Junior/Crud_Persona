package com.ajax.services;

import java.util.List;

import com.ajax.model.Consulta;
import com.ajax.model.Doctor;
import com.ajax.repository.IConsultaRepository;
import com.ajax.repository.IDoctorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ConsultaService
 */
@Service
public class ConsultaService {

    @Autowired
    IConsultaRepository rConsulta;

    @Autowired
    IDoctorRepository rDoctor;

    public List<Consulta> getAll() {
        return (List<Consulta>) rConsulta.findAll();
    }
    
    public Boolean saveOrUpdate(Consulta entity) {
        try {
            rConsulta.save(entity);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Boolean delete(Consulta entity) {
        try {
            rConsulta.delete(entity);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Consulta getConsulta(Integer id) {
        return rConsulta.findById(id).get();
    }

    public Doctor getDoctor(Integer id) {
        return rDoctor.findById(id).get();
    }
}