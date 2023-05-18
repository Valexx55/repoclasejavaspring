package edu.cas.imcwebprofe.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.cas.imcwebprofe.repository.PacienteRepository;
import edu.cas.imcwebprofe.repository.entity.Paciente;

@Service
public class PacienteServiceImpl implements PacienteService{

	//La inyección de depedencias permite armar el softweare con componenntes independientes
	//Es la anotación equivalente a Inject de Java EE
	@Autowired //"Oye, ponme aquí, el objecto que has instanciado de PacienteRepository
	PacienteRepository pacienteRepository;//este objeto "encapsula" me ofrece acceso a la base datos /capa persistencia
	
	/**
	 * SPring
	 * pacienteRepository = new PacienteRepository () // inversión de control
	 * pacienteServiceImpl = new PacienteServiceImpl() // // inversión de control
	 * pacienteServiceImpl.setPacienteRepository (pacienteRepository), "INYECCión"
	 * metemos en la instancia de servicio, la instancia de repositorio (propiedad)
	 */
	
	@Override
	public Iterable<Paciente> consultarTodos() {
		
		Iterable<Paciente> listaPacientes = null;
		
			listaPacientes = this.pacienteRepository.findAll();
		
		return listaPacientes;
	}

	@Override
	public Optional<Paciente> consultarPacientePorId(Long id) {
		Optional<Paciente> optionalPaciente = null;
		
			optionalPaciente = this.pacienteRepository.findById(id);
		
		return optionalPaciente;
	}

	@Override
	public void borrarPacientePorId(Long id) {
		
		this.pacienteRepository.deleteById(id);
		
	}


	@Override
	public Paciente insertarPaciente(Paciente paciente) {
		Paciente pacienteNuevo = null;
			
			pacienteNuevo = this.pacienteRepository.save(paciente);
			
		return pacienteNuevo;
	}
	
	@Override
	public Optional<Paciente> modificarPaciente(Paciente paciente, Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
