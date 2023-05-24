package edu.cas.imcwebprofe.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.expression.spel.ast.OpAnd;

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

	Optional<Paciente> consultarPacientePorId(Long id);

	void borrarPacientePorId(Long id);

	Optional<Paciente> modificarPaciente(Paciente paciente, Long id);

	Paciente insertarPaciente(Paciente paciente);

	Iterable<Paciente> consultarPacientesPorRangoEdad(int edadmin, int edadmax);

	Iterable<Paciente> consultarPacientesPorNombreApellido(String nombre, String apellido);

	Iterable<Paciente> findByCreadoEnBetween(LocalDateTime fechamin, LocalDateTime fechamax);

	Iterable<Paciente> busquedaPorNombreOApellidoNativa (String patron);
}
