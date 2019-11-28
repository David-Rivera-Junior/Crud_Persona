package com.ajax.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.print.attribute.HashAttributeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ajax.model.Consulta;
import com.ajax.services.ConsultaService;

@Controller
@RequestMapping(value = "consulta")
public class ConsultaController {

	@Autowired
	ConsultaService daoConsulta;

	@GetMapping(value = "all", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Consulta> getAllDoctor() {
		return (List<Consulta>) daoConsulta.getAll();
	}

	// GUARDAR//
	@GetMapping(value = "save")
	@ResponseBody
	public HashMap<String, String> save(@RequestParam @DateTimeFormat(pattern = "dd/MM/yy") Date fecha,
			@RequestParam String sintomas, @RequestParam String diagnostico, @RequestParam Integer idDoctor) {

		Consulta consulta = new Consulta();
		HashMap<String, String> jsonReturn = new HashMap<>();

		consulta.setFecha(fecha);
		consulta.setSintomas(sintomas);
		consulta.setDiagnostico(diagnostico);
		consulta.setDoctor(daoConsulta.getDoctor(idDoctor));

		try {
			daoConsulta.saveOrUpdate(consulta);

			jsonReturn.put("Estado", "OK");
			jsonReturn.put("Mensaje", "Registro guardado");

			return jsonReturn;
		} catch (Exception e) {

			jsonReturn.put("Estado", "Error");
			jsonReturn.put("Mensaje", "Registro no guardado" + e.getMessage());

			return jsonReturn;
		}
	}

	// Eliminar//
	@GetMapping(value = "delete/{id}")
	@ResponseBody
	public HashMap<String, String> delete(@PathVariable Integer id) {

		HashMap<String, String> jsonReturn = new HashMap<>();

		try {
			Consulta consulta = daoConsulta.getConsulta(id);
			daoConsulta.delete(consulta);

			jsonReturn.put("Estado", "OK");
			jsonReturn.put("Mensaje", "Registro eliminado");

			return jsonReturn;
		} catch (Exception e) {

			jsonReturn.put("Estado", "Error");
			jsonReturn.put("Mensaje", "Registro no eliminado" + e.getMessage());

			return jsonReturn;
		}
	}
	// Actualizar//

	 @GetMapping(value = "update/{id}")
	    @ResponseBody
	    public HashMap<String, String> save(@RequestParam Integer id, @RequestParam Date fecha,
	            @RequestParam String sintomas, @RequestParam String diagnostico, @RequestParam Integer idDoctor) {

	        Consulta consulta = new Consulta();
	        HashMap<String, String> jsonReturn = new HashMap<>();

	        consulta.setFecha(fecha);
	        consulta.setSintomas(sintomas);
	        consulta.setDiagnostico(diagnostico);
	        consulta.setDoctor(daoConsulta.getDoctor(idDoctor));

	        try {
	            daoConsulta.saveOrUpdate(consulta);

	            jsonReturn.put("Estado", "OK");
	            jsonReturn.put("Mensaje", "Registro actualizado");

	            return jsonReturn;
	        } catch (Exception e) {

	            jsonReturn.put("Estado", "Error");
	            jsonReturn.put("Mensaje", "Registro no actualizado" + e.getMessage());

	            return jsonReturn;
	        }
	    }
	}
