package edu.cas.imcwebprofe.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.cas.imcweb.repository.entity.Paciente;

//ESTA ES LA CAPA "SERVLETS"
//AQUÍ HAREMOS LOS MÉTODOS PARA
//ALTA POST
//BAJA DELETE
//MODIFICACIÓN PUT
//CONUSLTA DE UN PACIENTE GET
//CONUSLTA DE TODOS LOS PANCIENTES GET
//ESTO VA LIGADO A LA DEPDECNIA DE HTTP

//@Controller //le digo que esta clase, envía y recibe HTTP CON JSONES EN EL CUERPO
@RestController // con esto, digo que lo que envío y recibo es el tipo MIME JSON
@RequestMapping("/paciente") // oye, lo que sea http://localhost:8081/paciente es para esta clase!!
public class PacienteController {

	@GetMapping("/obtener-paciente-test") // GET http://localhost:8081/paciente/obtener-paciente-test
	public Paciente obtenerPacienteTest() {
		Paciente paciente = null;

		paciente = new Paciente(5, "Sheila", 48);

		return paciente;
	}
	
	//http://localhost:8081/paciente/obtenerpaciente?idpaciente=3
	
	@GetMapping("/obtenerpaciente") // GET http://localhost:8081/paciente/obtenerpaciente
	public Paciente obtenerPacienteIdParam(@RequestParam(name = "idpaciente")  Integer idpaciente) {
		Paciente paciente = null;

		System.out.println("ID Paciente recibido = " + idpaciente);
		paciente = new Paciente(5, "Sheila", 48);

		return paciente;
	}

	@GetMapping("/obtenerpaciente/{id}") // GET http://localhost:8081/paciente/obtenerpaciente/5
	public Paciente obtenerPacienteIdPath(@PathVariable Integer id) {
		Paciente paciente = null;

		System.out.println("ID Paciente recibido = " + id);
		paciente = new Paciente(5, "Sheila", 48);

		return paciente;
	}
	
	@PostMapping // POST http://localhost:8081/paciente
	public Paciente insertarPaciente(@RequestBody Paciente paciente) {
		System.out.println("Post paciente " + paciente);
		paciente.setEdad(paciente.getEdad() + 1);
		return paciente;

	}
}
