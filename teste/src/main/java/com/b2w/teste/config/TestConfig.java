package com.b2w.teste.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.b2w.teste.entities.Cargo;
import com.b2w.teste.entities.Trilha;
import com.b2w.teste.repositories.CargoRepository;
import com.b2w.teste.repositories.TrilhaRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

	@Autowired
	private CargoRepository cargoRepository;
	
	@Autowired
	private TrilhaRepository trilhaRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		Trilha t1 = new Trilha(null, "ADMINISTRAÇÃO DE PESSOAL", "G&G", "Planejar, executar e mensurar a administração de pessoal,\\ngarantindo a correta apuração da folha de pagamento, folha de ponto, encargos sociais, cálculo de férias,\\nbenefícios, processos admissionais e demissionais na cia.", "Garantir que as leis trabalhistas estejam sendo cumpridas com eficácia e eficiência.", Instant.parse("2020-05-28T17:03:53.00Z"));
		Trilha t2 = new Trilha(null, "ADMINISTRAÇÃO DE PESSOAL", "G&G", "Planejar, executar e mensurar a administração de pessoal,\\ngarantindo a correta apuração da folha de pagamento, folha de ponto, encargos sociais, cálculo de férias,\\nbenefícios, processos admissionais e demissionais na cia.", "Garantir que as leis trabalhistas estejam sendo cumpridas com eficácia e eficiência.", Instant.parse("2020-05-28T17:03:53.00Z"));
		trilhaRepository.saveAll(Arrays.asList(t1, t2));
		
		Cargo cg1 = new Cargo(null, "Analista de Departamento Pessoal Jr", 1, "Realizar controle e processamento da folha de pagamento, encargos sociais, cálculo de férias,\\nadmissões, demissões e benefícios, preparando documentos para homologação e garantindo o\\ncumprimento dos procedimentos legais.", Instant.parse("2020-05-11T17:03:53.00Z"), t1);
		Cargo cg2 = new Cargo(null, "Analista de Departamento Pessoal Pl", 1, "Realizar controle e processamento da folha de pagamento, encargos sociais, cálculo de férias,\\nadmissões, demissões e benefícios, preparando documentos para homologação e garantindo o\\ncumprimento dos procedimentos legais.", Instant.parse("2020-05-12T17:03:53.00Z"), t1);
		cargoRepository.saveAll(Arrays.asList(cg1, cg2));
	}
}