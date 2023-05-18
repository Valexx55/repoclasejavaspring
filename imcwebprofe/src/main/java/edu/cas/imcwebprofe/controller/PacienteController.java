package edu.cas.imcwebprofe.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.cas.imcwebprofe.repository.entity.Paciente;


//ESTA ES LA CAPA "SERVLETS"
//AQUÍ HAREMOS LOS MÉTODOS PARA

//ALTA POST --> POST http://localhost:8081/paciente body {JSON paciente con los datos del paciente a insertar}
//BAJA DELETE --> DELETE http://localhost:8081/paciente/1
//MODIFICACIÓN PUT --> DELETE http://localhost:8081/paciente/1 body {paciente con los datos nuevos JSON}
//CONUSLTA DE UN PACIENTE GET  --> GET http://localhost:8081/paciente/1
//CONUSLTA DE TODOS LOS PANCIENTES GET -->  GET http://localhost:8081/paciente


//ESTO VA LIGADO A LA DEPDECNIA DE HTTP

//@Controller //le digo que esta clase, envía y recibe HTTP CON JSONES EN EL CUERPO
@RestController // con esto, digo que lo que envío y recibo es el tipo MIME JSON
@RequestMapping("/paciente") // oye, lo que sea http://localhost:8081/paciente es para esta clase!!
public class PacienteController {
	
	
	//CONUSLTA DE TODOS LOS PANCIENTES GET -->  GET http://localhost:8081/paciente
	@GetMapping
	ResponseEntity<?> obtenerTodosLosPacientes ()
	{
		ResponseEntity<?> responseEntity = null;
		
			List<Paciente> lista_p= List.of(new Paciente(5l, "Sheila", 48), new Paciente(5l, "Sheila", 48), new Paciente(5l, "Sheila", 48));
			responseEntity = ResponseEntity.ok(lista_p);
		
		return responseEntity;
	}
	
	
	//CONUSLTA DE UN PACIENTE GET  --> GET http://localhost:8081/paciente/59
	@GetMapping("/{id}")
	ResponseEntity<?> obtenerPacientePorId (@PathVariable Long id)
	{
		ResponseEntity<?> responseEntity = null;
		
		
		return responseEntity;
	}
	
	
	//BAJA DELETE --> DELETE http://localhost:8081/paciente/1
	@DeleteMapping("/{id}")
	ResponseEntity<?> borrarPacientePorId (@PathVariable Long id)
	{
		ResponseEntity<?> responseEntity = null;
		
		
		return responseEntity;
	}
	
	
	
	//ALTA POST --> POST http://localhost:8081/paciente body {JSON paciente con los datos del paciente a insertar}
	@PostMapping
	ResponseEntity<?> insertarPaciente (@RequestBody Paciente paciente)
	{
		ResponseEntity<?> responseEntity = null;
		
		
		return responseEntity;
	}
	
	
	//MODIFICACIÓN PUT --> DELETE http://localhost:8081/paciente/1 body {paciente con los datos nuevos JSON}
	@PutMapping("/{id}")
	ResponseEntity<?> modificarPaciente (@RequestBody Paciente paciente, @PathVariable Long id)
	{
		ResponseEntity<?> responseEntity = null;
		
		
		return responseEntity;
	}
	
	
	
	
	@GetMapping("/obtener-paciente-test") // GET http://localhost:8081/paciente/obtener-paciente-test
	public Paciente obtenerPacienteTest() {
		Paciente paciente = null;

		paciente = new Paciente(5l, "Sheila", 48);

		return paciente;
	}
	
	
	//http://localhost:8081/paciente/obtenerpaciente?idpaciente=3
	
	@GetMapping("/obtenerpaciente") // GET http://localhost:8081/paciente/obtenerpaciente
	public Paciente obtenerPacienteIdParam(@RequestParam(name = "idpaciente")  Integer idpaciente) {
		Paciente paciente = null;

		System.out.println("ID Paciente recibido = " + idpaciente);
		paciente = new Paciente(5l, "Sheila", 48);

		return paciente;
	}

	@GetMapping("/obtenerpaciente/{id}") // GET http://localhost:8081/paciente/obtenerpaciente/5
	public Paciente obtenerPacienteIdPath(@PathVariable Integer id) {
		Paciente paciente = null;

		System.out.println("ID Paciente recibido = " + id);
		paciente = new Paciente(5l, "Sheila", 48);

		return paciente;
	}
	

}
