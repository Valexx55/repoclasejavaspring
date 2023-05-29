package edu.cas.imcwebprofe.repository.entity;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	private Long id;
	
	//@Column(name = "nombre_paciente")
	@Size(min = 3, max = 20)
	private String nombre;//estos 2 campos, estarán asociados a 
	
	@Min(0)
	@Max(130)
	private int edad;//columnas del mismo nombre en la tabla pacientes
	
	@Lob //Large Object Binary --> Archivo
	@JsonIgnore //el atributo foto, no lo serializes. ignorálo, no se lo damos al cliente en el JSON de respuesta
	private byte[] foto;
	
	//@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "creado_en")
	private LocalDateTime creadoEn;//fecha en que se crea un paciente
	
	@Email
	private String email;
	
	@NotEmpty //que su longuitud sea mayor o igual a 1 . Más restrictivo que null
	private String apellido;
	
	//puedo asociar métodos, antes de que inserte un registro, después
	@PrePersist //este método, se va a ejecutar ANTES de que se inserte el registro (save)
	private void generarFechaCreacion ()
	{
		this.creadoEn = LocalDateTime.now();//fecha actual
	}
	
	public Integer getFotoHashCode ()//fotoHashCode pasa a ser un atributo del JSON devuelto "flag" bandera, indicador, para saber si un registro (Paciente) tiene foto o no
	{
		Integer idev = null;
		
			if (this.foto!=null) //si el paciente actual, trae foto
			{
				idev = this.foto.hashCode();
			}
		
		return idev;
	}
	
	public LocalDateTime getCreadoEn() {
		return creadoEn;
	}
	public void setCreadoEn(LocalDateTime creadoEn) {
		this.creadoEn = creadoEn;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
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
	
	
	
	public byte[] getFoto() {
		return foto;
	}


	public void setFoto(byte[] foto) {
		this.foto = foto;
	}


	public Paciente(Long id, String nombre, int edad) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.edad = edad;
	}
	
	public Paciente(Long id, String nombre, int edad, LocalDateTime creadoEn, String email, String apellido) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.edad = edad;
		this.creadoEn = creadoEn;
		this.email = email;
		this.apellido = apellido;
	}
	
	
	public Paciente() {
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	public String toString() {
		return "Paciente [id=" + id + ", nombre=" + nombre + ", edad=" + edad + ", creadoEn=" + creadoEn + ", email="
				+ email + ", apellido=" + apellido + "]";
	}
	

	
	

}
