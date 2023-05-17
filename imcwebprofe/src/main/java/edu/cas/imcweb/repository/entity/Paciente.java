package edu.cas.imcweb.repository.entity;

//ENTIDAD --> RELACIÓN CON LA BD
//CLASE ENTITY --> ASOCIADA A UNA TABLA
//ATRIBUTO --> COLUMNA

//JPA - HIBERNATE
//HIBERNATE - ORM Object Relational Mapping - Forma de Relacionar Clases con Tablas de la base de datos
public class Paciente {
	
	private int id;
	private String nombre;
	private int edad;
	
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
