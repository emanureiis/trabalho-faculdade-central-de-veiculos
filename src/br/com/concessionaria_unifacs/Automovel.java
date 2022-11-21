package br.com.concessionaria_unifacs;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class Automovel {
	private String marca;
	private String modelo;
	private int ano;
	private String cor;
	private String motor;
	private String placa;
	private String preco;
	private static Collection<Automovel> automoveis = new ArrayList<>();
	
	public Automovel(String marca, String modelo, int ano, String cor, String motor, String placa, String preco) {
		System.out.println("Criando");
		this.marca = marca;
		this.modelo = modelo;
		this.ano = ano;
		this.cor = cor;
		this.motor = motor;
		this.placa = placa;
		this.preco = preco;
	}
	
	public static void cadastrar() {
		Scanner leitor = new Scanner(System.in);
		
		System.out.println("Digite a marca do veículo:");
		String marca = leitor.next();
		
		System.out.println("\nDigite o modelo do veículo:");
		String modelo = leitor.next();
		
		System.out.println("\nDigite o ano do veículo:");
		int ano = leitor.nextInt();
		
		System.out.println("\nDigite a cor do veículo:");
		String cor = leitor.next();
		
		System.out.println("\nDigite o motor do veículo:");
		String motor = leitor.next();
		
		System.out.println("\nDigite a placa do veículo:");
		String placa = leitor.next();
		
		System.out.println("\nDigite o preço do veículo:");
		String preco = leitor.next();
		
		automoveis.add(new Automovel(marca, modelo, ano, cor, motor, placa, preco));
		System.out.println("\nParabéns! O cadastro foi realizado com sucesso.\n");
	}
	
	public static void add(Automovel automovel) {
		automoveis.add(automovel);
	}
	
	public static void listar() {
		for (Automovel automovel : automoveis) {
			System.out.println(automovel.toString());
		}
	}
	
	public static void editar(String placa) {
		for (Automovel automovel : automoveis) {	
			if (automovel.placa.equals(placa)) {
				System.out.println("Automovel encontrado");
			} else {
				System.out.println("Nao achei");
			}
		}	
	}
	
	public static void excluir(String placa) {
		for (Automovel automovel : automoveis) {	
			if (automovel.placa.equals(placa)) {
				System.out.println("Apaguei");
			} else {
				System.out.println("Nao apaguei");
			}
		}	
	}
}
