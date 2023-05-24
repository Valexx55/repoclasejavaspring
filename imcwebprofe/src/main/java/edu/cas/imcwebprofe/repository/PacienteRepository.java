package edu.cas.imcwebprofe.repository;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.Query;
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
	
	//SPRING DATA
	
	//A) KEY WORD Queries -- Consultas por palabras clave
	
		//NOTA: no es necesario poner el modificador public en el método de una interfaz
		//ya que por defecto, lo es
	
		//1 Obtener un listado de pacientes, que estén en un rago de edad
	
			public Iterable<Paciente> findByEdadBetween (int edadmin, int edadmax);
			
		//2 Consulta por nombre y apellidos
			
			 Iterable<Paciente> findByNombreAndApellidoIgnoreCase(String nombre, String apellido);
			
			//TODO Partiendo de la guía https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods
			// definir un nuevo servicio web, usando una KeyWordQuery
			// Desarrollar las 3 capas: Repository, Service, Controller
			 
		//3 Conuslta para recuperar Pacientes en un intervalo de fechas de creación 
			 
			 public Iterable<Paciente> findByCreadoEnBetween (LocalDateTime fechamin, LocalDateTime fechamax);
			 
		//4 TODO usar el Containing (key word-palabra clave) para recuperar todos los pacientes cuyo nombre
			 //contengan un patrón dado //https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods
			 //pej: je --> jesús, jessica
			 
	//B) JQPL -HQL - Agnóstico - Como SQL, pero usando el nombre de las Clases/Entitys y sus atributos y no de las tablas/columnas

	//c) NATIVAS - SQL, Mysql
			 
			@Query(value = "SELECT * FROM pacientes p WHERE p.nombre LIKE %?1% OR p.apellido LIKE %?1%", nativeQuery = true)
			Iterable<Paciente> busquedaPorNombreOApellidoNativa (String patron);
			 
			 
    //D) CRITERIA API - SQL, pero con métodos de JAVA  https://www.arquitecturajava.com/jpa-criteria-api-un-enfoque-diferente/
			 
	//E) Stored Procedures / CallableStatment (JDBC) 
}
