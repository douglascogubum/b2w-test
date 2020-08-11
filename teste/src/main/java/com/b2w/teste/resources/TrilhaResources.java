package com.b2w.teste.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.b2w.teste.entities.Trilha;
import com.b2w.teste.services.TrilhaService;

@RestController
@RequestMapping(value = "/trilhas")
public class TrilhaResources {

	@Autowired
	private TrilhaService service;
	
	@GetMapping
	public ResponseEntity<List<Trilha>> findAll() {
		List<Trilha> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Trilha> findById(@PathVariable Integer id) {
		Trilha crg = service.findById(id);
		return ResponseEntity.ok().body(crg);
	}	
	
	@PostMapping
	public ResponseEntity<Trilha> insert(@RequestBody Trilha trilha) {
		trilha = service.insert(trilha);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/id").buildAndExpand(trilha.getId()).toUri();
		return ResponseEntity.created(uri).body(trilha);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Trilha> update(@PathVariable Integer id, @RequestBody Trilha trilha) {
		trilha = service.update(id, trilha);
		return ResponseEntity.ok().body(trilha);
	}
}