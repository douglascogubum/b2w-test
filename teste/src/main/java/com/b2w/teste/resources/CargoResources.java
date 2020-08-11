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

import com.b2w.teste.entities.Cargo;
import com.b2w.teste.services.CargoService;

@RestController
@RequestMapping(value = "/cargos")
public class CargoResources {

	@Autowired
	private CargoService service;
	
	@GetMapping
	public ResponseEntity<List<Cargo>> findAll() {
		List<Cargo> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Cargo> findById(@PathVariable Integer id) {
		Cargo crg = service.findById(id);
		return ResponseEntity.ok().body(crg);
	}	
	
	@PostMapping
	public ResponseEntity<Cargo> insert(@RequestBody Cargo cargo) {
		cargo = service.insert(cargo);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/id").buildAndExpand(cargo.getId()).toUri();
		return ResponseEntity.created(uri).body(cargo);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Cargo> update(@PathVariable Integer id, @RequestBody Cargo cargo) {
		cargo = service.update(id, cargo);
		return ResponseEntity.ok().body(cargo);
	}
}