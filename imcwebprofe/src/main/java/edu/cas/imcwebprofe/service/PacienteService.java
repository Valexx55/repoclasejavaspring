package edu.cas.imcwebprofe.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.expression.spel.ast.OpAnd;

import edu.cas.imcwebprofe.model.FraseChuckNorris;
import edu.cas.imcwebprofe.repository.entity.Paciente;

//AQUÍ DEFINIMOS LA OPERATIVA
//LA FUNCIONALDIAD DE LA APLICAICÓN
//SIN NINGUNA DEDEPENCIA DE HTTP
//ALTA
//BAJA
//MODICACIÓN
//CONSULTA por iD
//Consuta todos
public interface PacienteService {

	Iterable<Paciente> consultarTodos();
	
	Iterable<Paciente> consultarPacientesPorPaginas(Pageable pagina);

	Optional<Paciente> consultarPacientePorId(Long id);

	void borrarPacientePorId(Long id);

	Optional<Paciente> modificarPaciente(Paciente paciente, Long id);

	Paciente insertarPaciente(Paciente paciente);

	Iterable<Paciente> consultarPacientesPorRangoEdad(int edadmin, int edadmax);
	
	Iterable<Paciente> consultarPacientesPorRangoEdadPaginado (int edadmin, int edadmax, Pageable pageable);

	Iterable<Paciente> consultarPacientesPorNombreApellido(String nombre, String apellido);

	Iterable<Paciente> findByCreadoEnBetween(LocalDateTime fechamin, LocalDateTime fechamax);

	Iterable<Paciente> busquedaPorNombreOApellidoNativa (String patron);
	
	Optional<FraseChuckNorris> obtenerFraseAleatoriaChuck ();
}
