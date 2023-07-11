package br.com.ekom.websocket.dto;

public class PromocaoDTO {
	private Integer idPromocao;
	private String nomePromocao;
	private String descricaoPromocao;

	public PromocaoDTO() {
	}

	public PromocaoDTO(Integer idPromocao, String nomePromocao, String descricaoPromocao) {
		super();
		this.idPromocao = idPromocao;
		this.nomePromocao = nomePromocao;
		this.descricaoPromocao = descricaoPromocao;
	}

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

	@Override
	public String toString() {
		return "PromocaoDTO [idPromocao=" + idPromocao + ", nomePromocao=" + nomePromocao + ", descricaoPromocao="
				+ descricaoPromocao + "]";
	}
	
}