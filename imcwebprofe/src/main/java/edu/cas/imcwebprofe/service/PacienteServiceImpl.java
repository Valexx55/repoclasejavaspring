package edu.cas.imcwebprofe.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import edu.cas.imcwebprofe.repository.entity.Paciente;

@Service
public class PacienteServiceImpl implements PacienteService{

	@Override
	public Iterable<Paciente> consultarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Paciente> consultarPacientePorId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void borrarPacientePorId(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Optional<Paciente> modificarPaciente(Paciente paciente, Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Paciente insertarPaciente(Paciente paciente) {
		// TODO Auto-generated method stub
		return null;
	}

}
