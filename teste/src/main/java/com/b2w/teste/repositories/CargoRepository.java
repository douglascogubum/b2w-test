package com.b2w.teste.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.b2w.teste.entities.Cargo;

public interface CargoRepository extends JpaRepository<Cargo, Integer> {
}