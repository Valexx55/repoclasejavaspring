package edu.cas.imcwebprofe.repository;

import org.springframework.stereotype.Repository;

//AQUÍ HAREMOS LOS ACCESOS A LA BASE DE DATOS
//esta anotación cumple 2 funciones
//1 la deja marcada para spring --> le dice, instánciame: soy un COMPONENT!
//2 a mí, como programador, tiene una semántica: en esta clase hay acceso a datos MYSQL
@Repository
public interface PacienteRepository {

}
