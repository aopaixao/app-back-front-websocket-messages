package br.com.ekom.websocket.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "canal")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idCanal", scope = Canal.class)
public class Canal {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_canal")
	private Integer idCanal;

	@Column(name = "nome_canal")
	private String nomeCanal;

	@Column(name = "descricao_canal")
	private String descricaoCanal;

	@ManyToMany
	@JoinTable(name = "promocao_canal", 
		joinColumns = @JoinColumn(name = "id_canal"), 
		inverseJoinColumns = @JoinColumn(name = "id_promocao"))
	private List<Promocao> promocoes;

	public Integer getIdCanal() {
		return idCanal;
	}

	public void setIdCanal(Integer idCanal) {
		this.idCanal = idCanal;
	}

	public String getNomeCanal() {
		return nomeCanal;
	}

	public void setNomeCanal(String nomeCanal) {
		this.nomeCanal = nomeCanal;
	}

	public String getDescricaoCanal() {
		return descricaoCanal;
	}

	public void setDescricaoCanal(String descricaoCanal) {
		this.descricaoCanal = descricaoCanal;
	}

	public List<Promocao> getPromocoes() {
		return promocoes;
	}

	public void setPromocoes(List<Promocao> promocoes) {
		this.promocoes = promocoes;
	}

}