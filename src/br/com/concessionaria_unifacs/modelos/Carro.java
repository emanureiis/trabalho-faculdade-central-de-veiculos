package br.com.concessionaria_unifacs.modelos;

public class Carro extends Automovel {

	private String categoria;
	private String direcao;
	private String cambio;
	
	public Carro(String marca, String modelo, String ano, String cor, String motorizacao, String placa, String preco, String categoria, String cambio) {
		super(marca, modelo, ano, cor, motorizacao, placa, preco);
		this.categoria = categoria;
		this.direcao = categoria;
		this.cambio = cambio;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getDirecao() {
		return direcao;
	}

	public void setDirecao(String direcao) {
		this.direcao = direcao;
	}

	public String getCambio() {
		return cambio;
	}

	public void setCambio(String cambio) {
		this.cambio = cambio;
	}
}
