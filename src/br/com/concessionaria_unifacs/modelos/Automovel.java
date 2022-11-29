package br.com.concessionaria_unifacs.modelos;

/**
 * Esta classe define todos os atributos
 * e métodos inerentes aos veículos da
 * concessionária
 */
public class Automovel {
	private String marca;
	private String modelo;
	private String ano;
	private String cor;
	private String motorizacao;
	private String placa;
	private String preco;
	
	public Automovel(String marca, String modelo, String ano, String cor, String motorizacao, String placa, String preco) {
		this.marca = marca;
		this.modelo = modelo;
		this.ano = ano;
		this.cor = cor;
		this.motorizacao = motorizacao;
		this.placa = placa;
		this.preco = preco;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getMotorizacao() {
		return motorizacao;
	}

	public void setMotorizacao(String motorizacao) {
		this.motorizacao = motorizacao;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getPreco() {
		return preco;
	}

	public void setPreco(String preco) {
		this.preco = preco;
	}
	
	@Override
	public String toString() {
		return this.marca+" "+this.modelo+" "+this.motorizacao+" - "+this.ano+ ""
				+ " Cor: "+this.cor+ ", Placa: "+this.placa+ ", Preço: R$ "+this.preco; 
	}
	
}
