package edu.cas.imcwebprofe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@Prueba
@SpringBootApplication//esta antoación, indica que es la clase de arranque Spring Boot
//@EntityScan("edu.cas.imcweb.respository")//Las entitys "clases-tabla" las tienes que buscar en este paquete
//@ComponentScan({"edu.cas.imcweb.componentes", "edu.cas.imcweb.servicios"})//Los componentes (servico, repository o controller)  las tienes que buscar en este paquete
public class ImcwebprofeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ImcwebprofeApplication.class, args);
	}

}
