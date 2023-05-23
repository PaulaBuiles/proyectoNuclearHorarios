package co.edu.cue.proyectoNuclear;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

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
