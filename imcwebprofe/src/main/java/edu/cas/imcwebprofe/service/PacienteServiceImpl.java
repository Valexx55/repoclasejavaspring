package edu.cas.imcwebprofe.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import edu.cas.imcwebprofe.model.FraseChuckNorris;
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
	
	//IDEA Transacción - Conversación
	//comprarBillete
		//marcar el Asiento rservado
		//hacer un apunte contable
		//pago 
	
	@Override
	@Transactional(readOnly = true) //permitiendo acceso concurrente a la tabla - Operaciones de consulta
	public Iterable<Paciente> consultarTodos() {
		
		Iterable<Paciente> listaPacientes = null;
		
			listaPacientes = this.pacienteRepository.findAll();
		
		return listaPacientes;
	}
	

	@Override
	@Transactional(readOnly = true)
	public Optional<Paciente> consultarPacientePorId(Long id) {
		Optional<Paciente> optionalPaciente = null;
		
			optionalPaciente = this.pacienteRepository.findById(id);
		
		return optionalPaciente;
	}

	
	
	@Override
	@Transactional
	public void borrarPacientePorId(Long id) {
		
		this.pacienteRepository.deleteById(id);
		
	}
	

	@Override
	@Transactional
	public Paciente insertarPaciente(Paciente paciente) {
		Paciente pacienteNuevo = null;
			
			pacienteNuevo = this.pacienteRepository.save(paciente);
			
		return pacienteNuevo;
	}
	
	@Override
	@Transactional
	public Optional<Paciente> modificarPaciente(Paciente paciente, Long id) {
		Optional<Paciente> optionalPaciente = Optional.empty();//"me creo el huevo vacío"
		
				//1 leer
				optionalPaciente =  this.pacienteRepository.findById(id);
				if (optionalPaciente.isPresent())
				{
					Paciente pacienteLeido = optionalPaciente.get();//en este momento, este paciente sí está asociado a un registro de la tabla
					//actualizar las propiedades //en estado de Persitente. Si yo modifico un atributo, estoy modificando la columna asociada
					
					BeanUtils.copyProperties(paciente, pacienteLeido, "id");
					//void org.springframework.beans.BeanUtils.copyProperties(Object source, Object target, String... ignoreProperties) throws BeansException
					
					//pacienteLeido.setNombre(paciente.getNombre());
					//pacienteLeido.setEdad(paciente.getEdad()); //HIBERNATE JPA
					
					optionalPaciente = Optional.of(pacienteLeido);
					//this.pacienteRepository.save(pacienteLeido); //no es necesario, ya que pacienteLeido está en Persisnte (dentro de una conexion @Transactional)
				}
				//2 modificar
		
		return optionalPaciente;
	}


	@Override
	@Transactional(readOnly = true)
	public Iterable<Paciente> consultarPacientesPorRangoEdad(int edadmin, int edadmax) {
		Iterable<Paciente> listaPacientes = null;
		
			listaPacientes = this.pacienteRepository.findByEdadBetween(edadmin, edadmax);
		
		return listaPacientes;
	}


	@Override
	@Transactional(readOnly = true)
	public Iterable<Paciente> consultarPacientesPorNombreApellido(String nombre, String apellido) {
		Iterable<Paciente> listaPacientes = null;
		
			listaPacientes = this.pacienteRepository.findByNombreAndApellidoIgnoreCase(nombre, apellido);
		
		return listaPacientes;
	}
	
	
	@Override
	@Transactional(readOnly = true)
	public Iterable<Paciente> findByCreadoEnBetween(LocalDateTime fechamin, LocalDateTime fechamax) {
		Iterable<Paciente> listaPaciente = null;
		
			listaPaciente = this.pacienteRepository.findByCreadoEnBetween(fechamin, fechamax);

		return listaPaciente;
}


	@Override
	@Transactional(readOnly = true)
	public Iterable<Paciente> busquedaPorNombreOApellidoNativa(String patron) {
		
		return this.pacienteRepository.busquedaPorNombreOApellidoNativa(patron);
	}


	@Override
	@Transactional(readOnly = true)
	public Iterable<Paciente> consultarPacientesPorPaginas(Pageable pagina) {
		return this.pacienteRepository.findAll(pagina);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Iterable<Paciente> consultarPacientesPorRangoEdadPaginado (int edadmin, int edadmax, Pageable pageable)
	{
		return this.pacienteRepository.findByEdadBetween(edadmin, edadmax, pageable);
	}


	@Override
	public Optional<FraseChuckNorris> obtenerFraseAleatoriaChuck() {
		RestTemplate restTemplate = null; 
		Optional<FraseChuckNorris> optionalFc = Optional.empty();
		FraseChuckNorris fraseChuckNorris = null;
		
			restTemplate = new RestTemplate();
			fraseChuckNorris =  restTemplate.getForObject(FraseChuckNorris.URL_CHUCK_NORRIS, FraseChuckNorris.class);
			optionalFc = Optional.of(fraseChuckNorris);
		
		return optionalFc;
	}

}
