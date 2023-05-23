package co.edu.cue.proyectoNuclear;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProyectoNuclearApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProyectoNuclearApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		userGeneralDAO.tryTableList();
	}

}
