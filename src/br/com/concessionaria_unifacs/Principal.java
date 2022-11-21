package br.com.concessionaria_unifacs;

import java.util.Scanner;

public class Principal {
	public static void main(String[] args) {
		Scanner leitor = new Scanner(System.in);
		
		//INICIO DO PROGRAMA
		menu();
		int resposta = leitor.nextInt(); 
		switch (resposta) {
			case 1: {
				Automovel.cadastrar();
				menu();
			}
			case 2: {
				Automovel.listar();
				menu();
			}
		}
	}
	

	public static void menu() {
		System.out.println("Digite uma opção:\n");
		System.out.println("+---------------------+");
		System.out.println("|    MENU DE OPÇÕES   |");
		System.out.println("+----------------------+");
		System.out.println("| 1. Cadastrar veículo");
		System.out.println("| 2. Listar veículos");
		System.out.println("| 3. Editar veículo");
		System.out.println("| 4. Excluir veículo");
		System.out.println("| 5. Sair");
		
	}
}
