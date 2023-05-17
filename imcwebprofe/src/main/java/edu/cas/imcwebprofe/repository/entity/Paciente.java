package edu.cas.imcwebprofe.repository.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//ENTIDAD --> RELACIÓN CON LA BD
//CLASE ENTITY --> ASOCIADA A UNA TABLA
//ATRIBUTO --> COLUMNA

//JPA - HIBERNATE
//HIBERNATE - ORM Object Relational Mapping - Forma de Relacionar Clases con Tablas de la base de datos

@Entity //esta clase, está asociada a una tabla
@Table(name = "pacientes") //el nombre de la tabla a la que se asocia esta clase
public class Paciente {
	
	@Id //este campo, es la clave primaria, Primary Key
	@GeneratedValue(strategy = GenerationType.IDENTITY)//autoinc en MYSQL
	private int id;
	
	//@Column(name = "nombre_paciente")
	
	private String nombre;//estos 2 campos, estarán asociados a 
	private int edad;//columnas del mismo nombre en la tabla pacientes
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public Paciente(int id, String nombre, int edad) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.edad = edad;
	}
	
	public Paciente() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Paciente [id=" + id + ", nombre=" + nombre + ", edad=" + edad + "]";
	}
	
	

}
