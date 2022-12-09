package br.com.concessionaria_unifacs.programa;

import java.util.Scanner;

import br.com.concessionaria_unifacs.database.DataBase;

/**
 * Classe responsável por executar o
 * nosso programa 
 */
public class Principal {
	public static void main(String[] args) {
		/**
		 * É instanciada uma referência para
		 * um objeto do tipo DataBase afim de
		 * simular o banco de dados
		 */
		DataBase dataBase = new DataBase();
		
		/**
		 * Invocação do menu para que o
		 * progrma seja iniciado
		 */
		menu();
	}

	public static void menu() {		
		Scanner leitor = new Scanner(System.in);
		/**
		 * validador
		 */
		Boolean validador = true;
		while (validador == true)  {	
			System.out.println("\n+----------------------+");
			System.out.println("|    MENU DE OPÇÕES    |");
			System.out.println("+----------------------+");
			System.out.println("| 1. Cadastrar veículo |");
			System.out.println("| 2. Listar veículos   |");
			System.out.println("| 3. Procurar veículo  |");
			System.out.println("| 4. Editar veículo    |");
			System.out.println("| 5. Excluir veículo   |");
			System.out.println("| 6. Sair              |");
			System.out.println("+----------------------+");
			System.out.println("Digite uma opção:");
			String resposta = leitor.next(); 

			switch (resposta) {
				case "1": {
					DataBase.cadastrar();
					validador = true;
					break;
				}
				case "2": {
					DataBase.listar();
					validador = true;
					break;
				}
				case "3": {
					DataBase.procurar();
					validador = true;
					break;
				}
				case "4": {
					DataBase.editar();
					validador = true;
					break;
				}
				case "5": {
					DataBase.excluir();
					validador = true;
					break;
				}
				case "6": {
					System.out.println("\n~ FIM DO PROGRAMA ~");
					validador = false;
					break;
				}
				default : {
					System.out.println("\n------ OPÇÃO INVÁLIDA --------");
					System.out.println("Por favor escolha entre 1 e 6:");
					validador = true;
					break;
				}
			}
		}
	}
}
	
