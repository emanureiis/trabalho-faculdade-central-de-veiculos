package br.com.concessionaria_unifacs;

import br.com.concessionaria_unifacs.*;
import java.util.Scanner;

public class Principal {
	public static void main(String[] args) {
		
		Automovel automovel = new Automovel("teste", "teste", 2022, "azul", "1", "1234", "20");
		Automovel.add(automovel);
		
		//INICIO DO PROGRAMA
		menu();
	}
	
	
	private static void menu() {
		System.out.println("Digite uma opção:\n");
		System.out.println("+---------------------+");
		System.out.println("|    MENU DE OPÇÕES   |");
		System.out.println("+----------------------+");
		System.out.println("| 1. Cadastrar veículo");
		System.out.println("| 2. Listar veículos");
		System.out.println("| 3. Editar veículo");
		System.out.println("| 4. Excluir veículo");
		System.out.println("| 5. Sair");
		verrificaResposta();
	}
	
	private static void verrificaResposta() {
		Scanner leitor = new Scanner(System.in);
	
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
			case 3: {
				System.out.println("Digite a placa do autómovel que deseja editar:");
				String p = leitor.next();
				Automovel.editar(p);
				menu();
			}
			case 4: {
				System.out.println("Digite a placa do autómovel que deseja excluir:");
				String p = leitor.next();
				Automovel.excluir(p);
				menu();
			}
		}
	}
}
