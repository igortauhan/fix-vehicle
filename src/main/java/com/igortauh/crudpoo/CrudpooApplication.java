package com.igortauh.crudpoo;

import com.igortauh.crudpoo.entities.Agenda;
import com.igortauh.crudpoo.entities.Cliente;
import com.igortauh.crudpoo.entities.Veiculo;
import com.igortauh.crudpoo.repositories.AgendaRepository;
import com.igortauh.crudpoo.repositories.ClienteRepository;
import com.igortauh.crudpoo.repositories.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;
import java.util.Arrays;

@SpringBootApplication
public class CrudpooApplication implements CommandLineRunner {

	@Autowired
	private VeiculoRepository veiculoRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private AgendaRepository agendaRepository;

	public static void main(String[] args) {
		SpringApplication.run(CrudpooApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception{

		Veiculo v1 = new Veiculo(null, 2, "Corolla", 2016, "Preto", 0.0, 70000.0, "ABC-1231");
		Veiculo v2 = new Veiculo(null, 3, "Civic", 2016, "Prata", 0.0, 100000.0, "ABC-1232");
		veiculoRepository.saveAll(Arrays.asList(v1, v2));

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		Cliente c1 = new Cliente(null, "João", sdf.parse("30/05/2001") , "12345678910", "joao@email.com", "00999999999", "Rua principal", v1);
		Cliente c2 = new Cliente(null, "Maria", sdf.parse("06/06/2001"), "12335678910", "maria@email.com", "00999999990", "Rua Principal 2", v2);
		clienteRepository.saveAll(Arrays.asList(c1, c2));

		Agenda a1 = new Agenda(null, sdf.parse("10/07/2021"), c1);
		Agenda a2 = new Agenda(null, sdf.parse("15/07/2021"), c2);
		agendaRepository.saveAll(Arrays.asList(a1, a2));
	}
}
