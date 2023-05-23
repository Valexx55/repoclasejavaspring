package edu.cas.imcwebprofe.controller;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Marcando esta clase con esta anotación, configuro en Spring esta clase
 * como "sumidero" de fallos/excepciones
 * 
 * Cualquier expcepción que ocurra en la aplición, va a ser derivada aquí
 * 
 * Es como un "catch GLOBAL"
 * @author valer
 *
 */

//
////TB FUNCIONA @ControllerAdvice(basePackages = {"edu.cas.imcwebprofe"})//todas las execpciones, en este paquete (sub), derivará aquí
@RestControllerAdvice(basePackages = {"edu.cas.imcwebprofe"})//todas las execpciones, en este paquete (sub), derivará aquí
public class GestionExcepciones {
	
	//para cada tipo de excepción, puedo configurar/mapear/asociar un método
	@ExceptionHandler(EmptyResultDataAccessException.class)//spring, si ocurre una excepción de este tipo, llamas a este método
	public ResponseEntity<?> gestionErrorBorrarIdNoExiste (EmptyResultDataAccessException excepcion)
	{
		ResponseEntity<?> responseEntity = null;
		String mensajeError = null;
				
				mensajeError =	excepcion.getMessage();
				responseEntity = ResponseEntity.internalServerError().body(mensajeError);//500
		
		return responseEntity;
	}

	//java.lang.StringIndexOutOfBoundsException
	@ExceptionHandler(StringIndexOutOfBoundsException.class)//spring, si ocurre una excepción de este tipo, llamas a este método
	public ResponseEntity<?> gestionStringOutBoundsException (StringIndexOutOfBoundsException excepcion)
	{
		ResponseEntity<?> responseEntity = null;
		String mensajeError = null;
				
				mensajeError =	excepcion.getMessage();
				responseEntity = ResponseEntity.internalServerError().body(mensajeError);//500
		
		return responseEntity;
	}
	
	@ExceptionHandler(Throwable.class)//spring, si ocurre una excepción de este tipo, llamas a este método
	public ResponseEntity<?> gestionErroGenerico (Throwable excepcion)
	{
		ResponseEntity<?> responseEntity = null;
		String mensajeError = null;
				
				mensajeError =	excepcion.getMessage();
				responseEntity = ResponseEntity.internalServerError().body(mensajeError);//500
		
		return responseEntity;
	}
}
