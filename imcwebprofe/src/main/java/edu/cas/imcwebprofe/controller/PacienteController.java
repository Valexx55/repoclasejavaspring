package edu.cas.imcwebprofe.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
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
import edu.cas.imcwebprofe.service.PacienteService;
import edu.cas.imcwebprofe.service.PacienteServiceImpl;


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
	
	
	@Autowired
	PacienteService pacienteService;
	
	//CONUSLTA DE TODOS LOS PANCIENTES GET -->  GET http://localhost:8081/paciente
	@GetMapping
	ResponseEntity<?> obtenerTodosLosPacientes ()
	{
		ResponseEntity<?> responseEntity = null;
		Iterable<Paciente> listaPaciente = null;
		
			listaPaciente=this.pacienteService.consultarTodos();
			responseEntity = ResponseEntity.ok(listaPaciente);
		
		return responseEntity;
	}
	
	
	//optionalPaciente.isEmpty()== true //no hay paciente
	
	//SI HA RECUPERADO UN PACIENTE CON ESE ID,
		//LE DEVUELVO EL PACIENTE Y UN 200
	//SI NO ESTÁL
		//EL CUERPO IRÁ VACÍA
		//STATUS 404 / 400 / 204 no content
	
	
	
	//CONUSLTA DE UN PACIENTE GET  --> GET http://localhost:8081/paciente/59
	@GetMapping("/{id}")
	ResponseEntity<?> obtenerPacientePorId (@PathVariable Long id)
	{
		ResponseEntity<?> responseEntity = null;
		Optional<Paciente> optionalPaciente = null;
		
			optionalPaciente = this.pacienteService.consultarPacientePorId(id);
			if (optionalPaciente.isPresent())
			{
				Paciente pacienteLeido =  optionalPaciente.get();
				responseEntity = ResponseEntity.ok(pacienteLeido);
			} else {
				responseEntity = ResponseEntity.noContent().build();//Build the response entity with no body.
			}
			
		return responseEntity;
	}
	
	
	//BAJA DELETE --> DELETE http://localhost:8081/paciente/1
	@DeleteMapping("/{id}")
	ResponseEntity<?> borrarPacientePorId (@PathVariable Long id)
	{
		ResponseEntity<?> responseEntity = null;
		
				this.pacienteService.borrarPacientePorId(id);
				responseEntity = ResponseEntity.ok().build();
		
		return responseEntity;
	}
	
	
	private ResponseEntity<?> generarRespuestaConErrroesValidacion(BindingResult bindingResult) {
		ResponseEntity<?> responseEntity = null;
		List<ObjectError> listaErrores = null;
			
			listaErrores = bindingResult.getAllErrors();
			responseEntity = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(listaErrores);
		
		return responseEntity;
	}
	
	//ALTA POST --> POST http://localhost:8081/paciente body {JSON paciente con los datos del paciente a insertar} BIND" cargar atributos JSON a las propiedades JAVA (set)
	@PostMapping
	ResponseEntity<?> insertarPaciente (@Valid @RequestBody Paciente paciente, BindingResult bindingResult)
	{
		ResponseEntity<?> responseEntity = null;
		Paciente pacienteNuevo = null;
		
			//Valido Paciente
			//si es valido, inserto
				//si no le contesto con error
		
			if (bindingResult.hasErrors())
			{
				//el paciente NO es valido -400
				responseEntity = generarRespuestaConErrroesValidacion(bindingResult);
				//responseEntity = //ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
			} else {
				//paciente OK
				pacienteNuevo = this.pacienteService.insertarPaciente(paciente);
				responseEntity = ResponseEntity.status(HttpStatus.CREATED).body(pacienteNuevo);
			}
			
			
		
		return responseEntity;
	}
	
	
	//MODIFICACIÓN PUT --> DELETE http://localhost:8081/paciente/1 body {paciente con los datos nuevos JSON}
	@PutMapping("/{id}")
	ResponseEntity<?> modificarPaciente (@RequestBody Paciente paciente, @PathVariable Long id)
	{
		ResponseEntity<?> responseEntity = null;
		Optional<Paciente> optionalPaciente = null;
		
			optionalPaciente = 	this.pacienteService.modificarPaciente(paciente, id);
			//si lo ha podido modifcar, 200 OK + el paciente modificado
			if (optionalPaciente.isPresent())
			{
				Paciente pacienteModificado = optionalPaciente.get();
				responseEntity = ResponseEntity.ok(pacienteModificado);
			} else {
				//si no 404 notFound y el body vacío
				responseEntity = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
				
		
		return responseEntity;
	}
	
	
	
	
	@GetMapping("/obtener-paciente-test") // GET http://localhost:8081/paciente/obtener-paciente-test
	public Paciente obtenerPacienteTest() {
		Paciente paciente = null;

		//paciente = new Paciente(5l, "Sheila", 48); //Este objeto, tiene relación con la base de datos?
		//En este momento, este objeto no guarda relación con la base de datos --> Transient
		//paciente.setEdad(43);//modifico la propiedad/atributo no una columna

		paciente = new Paciente(1l, "Antonio", 30, LocalDateTime.now(), "antonio@porquenotecalles.es", "Lopez");
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
