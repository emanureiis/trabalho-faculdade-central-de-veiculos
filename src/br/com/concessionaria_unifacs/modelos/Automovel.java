package br.com.concessionaria_unifacs.modelos;

public class Automovel {
	private String marca;
	private String modelo;
	private int ano;
	private String cor;
	private String motorizacao;
	private String placa;
	private String preco;
	
	public Automovel(String marca, String modelo, int ano, String cor, String motorizacao, String placa, String preco) {
		System.out.println("Criando");
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

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getMotor() {
		return motorizacao;
	}

	public void setMotor(String motorizacao) {
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
				+ "\nCor: "+this.cor+ ", Placa: "+this.placa+ ", Preço: R$ "+this.preco; 
	}
	
}
