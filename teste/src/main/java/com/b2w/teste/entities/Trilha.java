package com.b2w.teste.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "trilha")
public class Trilha implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "trilha_nome", length = 35)
	private String trilhaNome;
	
	@Column( length = 30)
	private String diretoria;
	
	@Column(name = "missao_formal", length = 270)
	private String missaoFormal;
	
	@Column(name = "missao_alternativa", length = 126)
	private String missaoAlternativa;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT")
	@Column(name = "data_atualizacao")
	private Instant dataAtualizacao;

	@JsonIgnore
	@OneToMany(mappedBy = "trilha")
	private List<Cargo> cargos = new ArrayList<>();

	public Trilha() {
	}	

	public Trilha(Integer id, String trilhaNome, String diretoria, String missaoFormal, String missaoAlternativa,
			Instant dataAtualizacao) {
		super();
		this.id = id;
		this.trilhaNome = trilhaNome;
		this.diretoria = diretoria;
		this.missaoFormal = missaoFormal;
		this.missaoAlternativa = missaoAlternativa;
		this.dataAtualizacao = dataAtualizacao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTrilhaNome() {
		return trilhaNome;
	}

	public void setTrilhaNome(String trilhaNome) {
		this.trilhaNome = trilhaNome;
	}

	public String getDiretoria() {
		return diretoria;
	}

	public void setDiretoria(String diretoria) {
		this.diretoria = diretoria;
	}

	public String getMissaoFormal() {
		return missaoFormal;
	}

	public void setMissaoFormal(String missaoFormal) {
		this.missaoFormal = missaoFormal;
	}

	public String getMissaoAlternativa() {
		return missaoAlternativa;
	}

	public void setMissaoAlternativa(String missaoAlternativa) {
		this.missaoAlternativa = missaoAlternativa;
	}

	public Instant getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(Instant dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

	public List<Cargo> getCargos() {
		return cargos;
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
		Trilha other = (Trilha) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
