package edu.cas.imcwebprofe.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.cas.imcwebprofe.repository.entity.Paciente;

//AQUÍ HAREMOS LOS ACCESOS A LA BASE DE DATOS
//esta anotación cumple 2 funciones
//1 la deja marcada para spring --> le dice, instánciame: soy un COMPONENT!
//2 a mí, como programador, tiene una semántica: en esta clase hay acceso a datos MYSQL
@Repository//opcional
public interface PacienteRepository extends CrudRepository<Paciente, Long> {

	//Crud - Create Read Update Delete 
	//CLAB  - Creación Lectura Actualización Borrado
	
	//KEY WORD Queries -- Consultas por palabras clave
	
		//1 Obtener un listado de pacientes, que estén en un rago de edad
	
			public Iterable<Paciente> findByEdadBetween (int edadmin, int edadmax);

}
