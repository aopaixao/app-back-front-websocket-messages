package br.com.ekom.websocket.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "promocao")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idPromocao", scope = Promocao.class)
public class Promocao {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_promocao")
	private Integer idPromocao;

	@Column(name = "nome_promocao")
	private String nomePromocao;

	@Column(name = "descricao_promocao")
	private String descricaoPromocao;

	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "promocoes", cascade = CascadeType.ALL)
	//@ManyToMany(mappedBy = "promocoes")
	private List<Canal> canais;

	public Integer getIdPromocao() {
		return idPromocao;
	}

	public void setIdPromocao(Integer idPromocao) {
		this.idPromocao = idPromocao;
	}

	public String getNomePromocao() {
		return nomePromocao;
	}

	public void setNomePromocao(String nomePromocao) {
		this.nomePromocao = nomePromocao;
	}

	public String getDescricaoPromocao() {
		return descricaoPromocao;
	}

	public void setDescricaoPromocao(String descricaoPromocao) {
		this.descricaoPromocao = descricaoPromocao;
	}

	public List<Canal> getCanais() {
		return canais;
	}

	public void setCanais(List<Canal> canais) {
		this.canais = canais;
	}

	@Override
	public String toString() {
		return "Promocao [idPromocao=" + idPromocao + ", nomePromocao=" + nomePromocao + ", descricaoPromocao="
				+ descricaoPromocao + ", canais=" + canais + "]";
	}
	
}