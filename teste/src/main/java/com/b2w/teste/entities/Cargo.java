package com.b2w.teste.entities;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "cargo")
public class Cargo implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 11)
	private Integer id;
	
	@Column(name = "cargo_nome", length = 53)
	private String cargoNome;
	
	@Column(name = "trilha_id")
	@JsonProperty("trilha_id")
	private Integer trilhaId;
	
	@Column(name = "cargo_missao", length = 492)
	private String cargoMissao;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT")
	@Column(name = "data_atualizacao")
	private Instant dataAtualizacao;
	
	@ManyToOne
	@JoinColumn(name = "trilha_id", insertable = false, updatable = false)	
	private Trilha trilha;
	
	public Cargo() {
	}

	public Cargo(Integer id, String cargoNome, Integer trilhaId, String cargoMissao, Instant dataAtualizacao, Trilha trilha) {
		super();
		this.id = id;
		this.cargoNome = cargoNome;
		this.trilhaId = trilhaId;
		this.cargoMissao = cargoMissao;
		this.dataAtualizacao = dataAtualizacao;
		this.trilha = trilha;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getTrilhaId() {
		return trilhaId;
	}

	public void setTrilhaId(Integer trilhaId) {
		this.trilhaId = trilhaId;
	}

	public String getCargoNome() {
		return cargoNome;
	}

	public void setCargoNome(String cargoNome) {
		this.cargoNome = cargoNome;
	}

	public String getCargoMissao() {
		return cargoMissao;
	}

	public void setCargoMissao(String cargoMissao) {
		this.cargoMissao = cargoMissao;
	}

	public Instant getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(Instant dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

	public Trilha getTrilha() {
		return trilha;
	}

	public void setTrilha(Trilha trilha) {
		this.trilha = trilha;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cargo other = (Cargo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}	
}