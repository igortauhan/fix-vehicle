package com.igortauh.crudpoo;

import com.igortauh.crudpoo.entities.Veiculo;
import com.igortauh.crudpoo.repositories.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class CrudpooApplication implements CommandLineRunner {

	@Autowired
	VeiculoRepository veiculoRepository;

	public static void main(String[] args) {
		SpringApplication.run(CrudpooApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception{

		Veiculo v1 = new Veiculo(null, 2, "Corolla", 2016, "Preto", 0.0, 70000.0, "ABC-1231");
		Veiculo v2 = new Veiculo(null, 3, "Civic", 2016, "Prata", 0.0, 100000.0, "ABC-1232");
		veiculoRepository.saveAll(Arrays.asList(v1, v2));
	}
}
