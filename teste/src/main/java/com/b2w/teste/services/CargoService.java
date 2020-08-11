package com.b2w.teste.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.b2w.teste.entities.Cargo;
import com.b2w.teste.entities.Trilha;
import com.b2w.teste.repositories.CargoRepository;
import com.b2w.teste.repositories.TrilhaRepository;
import com.b2w.teste.services.exceptions.ResourceNotFoundException;

@Service
public class CargoService {

	@Autowired
	private CargoRepository repository;
	
	@Autowired
	private TrilhaRepository trilhaRepository;
	
	public List<Cargo> findAll() {
		return repository.findAll();
	}
	
	public Cargo findById(Integer id) {
		Optional<Cargo> cargo = repository.findById(id);
		Trilha trilha = trilhaRepository.getOne(cargo.orElseThrow(() -> new ResourceNotFoundException(id)).getTrilhaId());
		cargo.orElseThrow(() -> new ResourceNotFoundException(id)).setTrilha(trilha);		
		return cargo.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Cargo insert(Cargo cargo) {
		Optional<Trilha> trilha = trilhaRepository.findById(cargo.getTrilhaId());
		cargo.setTrilha(trilha.orElseThrow(() -> new ResourceNotFoundException(cargo.getTrilhaId())));
		return repository.save(cargo);
	}
	
	private void updateData(Cargo entity, Cargo cargo) {
		entity.setCargoMissao(cargo.getCargoMissao());
		entity.setTrilhaId(cargo.getTrilhaId());
		entity.setCargoNome(cargo.getCargoNome());
		entity.setDataAtualizacao(cargo.getDataAtualizacao());
		
		Optional<Trilha> trilha = trilhaRepository.findById(cargo.getTrilhaId());
		cargo.setTrilha(trilha.orElseThrow(() -> new ResourceNotFoundException(cargo.getTrilhaId())));
		entity.setTrilha(cargo.getTrilha());
	}
	
	public Cargo update(Integer id, Cargo cargo) {
		try {
			Cargo entity = repository.getOne(id);
			updateData(entity, cargo);
			
			return repository.save(entity);
		} 
		catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}
}
