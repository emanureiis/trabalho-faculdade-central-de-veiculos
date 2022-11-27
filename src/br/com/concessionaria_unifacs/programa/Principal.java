package br.com.concessionaria_unifacs.programa;

import java.util.Scanner;

import br.com.concessionaria_unifacs.modelos.Database;

public class Principal {
	public static void main(String[] args) {
		Database dataBase = new Database();
		menu();
		
	}

	public static void menu() {
		do {	
			System.out.println("\n+----------------------+");
			System.out.println("|    MENU DE OPÇÕES    |");
			System.out.println("+----------------------+");
			System.out.println("| 1. Cadastrar veículo |");
			System.out.println("| 2. Listar veículos   |");
			System.out.println("| 3. Editar veículo    |");
			System.out.println("| 4. Excluir veículo   |");
			System.out.println("| 5. Sair              |");
			System.out.println("+----------------------+");
			System.out.println("Digite uma opção:");
			verrificaResposta();
		} while (verrificaResposta());
	}
	
	private static boolean verrificaResposta() {
		Scanner leitor = new Scanner(System.in);
		
		String resposta = leitor.next(); 
		switch (resposta) {
			case "1": {
				Database.cadastrar();
			}
			case "2": {
				Database.listar();
			}
			case "3": {
				Database.editar();
			}
			case "4": {
				Database.excluir();
			}
			case "5": {
				break;
			}
			default : {
				System.out.println("Resposta incorreta!");
				menu();
			}
		}
		System.out.println("Finish");
		return false;
	}

}
