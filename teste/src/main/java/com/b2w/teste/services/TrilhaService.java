package com.b2w.teste.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.b2w.teste.entities.Trilha;
import com.b2w.teste.repositories.TrilhaRepository;
import com.b2w.teste.services.exceptions.ResourceNotFoundException;

@Service
public class TrilhaService {

	@Autowired
	private TrilhaRepository repository;
	
	public List<Trilha> findAll() {
		return repository.findAll();
	}
	
	public Trilha findById(Integer id) {
		Optional<Trilha> crg = repository.findById(id);
		return crg.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Trilha insert(Trilha trilha) {
		return repository.save(trilha);
	}
	
	private void updateData(Trilha entity, Trilha trilha) {
		entity.setTrilhaNome(trilha.getTrilhaNome());
		entity.setDiretoria(trilha.getDiretoria());
		entity.setMissaoFormal(trilha.getMissaoFormal());
		entity.setMissaoAlternativa(trilha.getMissaoAlternativa());
		entity.setDataAtualizacao(trilha.getDataAtualizacao());
	}
	
	public Trilha update(Integer id, Trilha trilha) {
		try {
			Trilha entity = repository.getOne(id);
			updateData(entity, trilha);
			
			return repository.save(entity);
		} 
		catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}
}
