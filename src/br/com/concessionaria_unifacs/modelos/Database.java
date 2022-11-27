package br.com.concessionaria_unifacs.modelos;

import java.util.Collection;
import java.util.HashSet;
import java.util.Scanner;

import br.com.concessionaria_unifacs.programa.Principal;

public class Database {
	private static Scanner leitor = new Scanner(System.in);
	private static Collection<Automovel> automoveis = new HashSet<>();
	
	public Database() {
		Automovel automovel1 = new Automovel("Chevrolet", "Corsa", 2002, "Branco", "1.0", "PJL3344", "20.000"); automoveis.add(automovel1);
		Automovel automovel2 = new Automovel("Chevrolet", "Corsa", 2002, "Branco", "1.0", "PJL3344", "20.000"); automoveis.add(automovel2);
	}
	
	public static void cadastrar() {	
		int stageTotal = 7;
		int stage = 1;
		System.out.println("\n+-----------------------------------------+");
		System.out.println("|           CADASTRAR VEÍCULO             |");
		System.out.println("|      (DIGITE 'C' PARA CANCELAR)         |");
		System.out.println("+-----------------------------------------+");
		System.out.println("Etapa "+(stage++)+" de "+stageTotal+ " - Digite a marca do veículo:");
		String marca = leitor.next();
		verificarCancelar(marca);
		
		System.out.println("\nEtapa "+(stage++)+" de "+stageTotal+ " - Digite o modelo do veículo:");
		String modelo = leitor.next();
		
		System.out.println("\nEtapa "+(stage++)+" de "+stageTotal+ " - Digite o ano do veículo:");
		int ano = leitor.nextInt();
		
		System.out.println("\nEtapa "+(stage++)+" de "+stageTotal+ " - Digite a cor do veículo:");
		String cor = leitor.next();
		
		System.out.println("\nEtapa "+(stage++)+" de "+stageTotal+ " - Digite a motorização do veículo:");
		String motorizacao = leitor.next();
		
		System.out.println("\nEtapa "+(stage++)+" de "+stageTotal+ " - Digite a placa do veículo:");
		String placa = leitor.next();
		
		System.out.println("\nEtapa "+(stage++)+" de "+stageTotal+ " - Digite o preço do veículo:");
		String preco = leitor.next();
		System.out.println("+------------------------------------------+");
		System.out.println("| PARABÉNS! CADASTRO REALIZADO COM SUCESSO |");
		System.out.println("+------------------------------------------+");
		automoveis.add(new Automovel(marca, modelo, ano, cor, motorizacao, placa, preco));
	
		Principal.menu();
	}
	
	public static void listar() {
		if (automoveis.size() == 0) {
			System.out.println("\n+------------------------------+");
			System.out.println("|          E  R  R  O          |");
			System.out.println("+------------------------------+");
			System.out.println("Nenhum veículo foi cadastrado.\nDeseja cadastrar? (S ou N)");
			while (varificaRespostaAdicinar() == false) {
				varificaRespostaAdicinar();
			}
		}
		
		if (automoveis.size() > 0) {
			int count = 0;
			System.out.println("\n+---------------------------------------------+");
			System.out.println("|                LISTAR VEÍCULOS              |");
			System.out.println("+---------------------------------------------+");
			for (Automovel automovel : automoveis) {
				System.out.println((count=count+1)+". "+automovel.toString()+"\n");
			}
		Principal.menu();
		}
	}
	
	private static boolean varificaRespostaAdicinar() {
		String resposta = leitor.next();
		switch (resposta.toUpperCase()) {
			case "S": {
				Database.cadastrar();
			}
			case "N": {
				Principal.menu();
			}
			default : {
				System.out.println("\n- RESPOSTA INCORRETA -");
				System.out.println("Por favor digite S ou N:");
				return false;
			}
		}
	}
		
	private static void verificarCancelar(String resposta) {
		switch (resposta.toUpperCase()) {
			case "C": {
				System.out.println("\n~ Cancelado com sucesso! ~");
				Principal.menu();
			}
			break;
		}
	}

	public static void editar() {
		System.out.println("\n+-----------------------------------------+");
		System.out.println("|             EDITAR VEÍCULO              |");
		System.out.println("|      (DIGITE 'C' PARA CANCELAR)         |");
		System.out.println("+-----------------------------------------+");
		System.out.println("Digite a placa do autómovel que deseja editar:");
		String placa = leitor.next();
		verificarCancelar(placa);
		for (Automovel automovel : automoveis) {	
			if (automovel.getPlaca().equals(placa)) {
				do {
					System.out.println("\n+-----------------------------------------+");
					System.out.println("|         - VEÍCULO ENCONTRADO -          |");
					System.out.println("| SELECIONE O ATRIBUTO QUE DESEJA EDITAR  |");
					System.out.println("+-----------------------------------------+");
					System.out.println("| 1. Marca                                |");
					System.out.println("| 2. Modelo                               |");
					System.out.println("| 3. Ano                                  |");
					System.out.println("| 4. Cor                                  |");
					System.out.println("| 5. Motorização                          |");
					System.out.println("| 6. Placa                                |");
					System.out.println("| 6. Preço                                |");
					System.out.println("|                                         |");
					System.out.println("| 7. Cancelar                                |");
					System.out.println("+-----------------------------------------+");
					EditaAtributo(automovel);
					System.out.println("+-------------------------------------------+");
					System.out.println("| PARABÉNS! ATRIBUTO ATUALIZADO COM SUCESSO |");
					System.out.println("+-------------------------------------------+");
					verrificarContinuarEditando();
				} while (verrificarContinuarEditando() == false);

			} else {
				System.out.println("Nao achei");
			}
		}	
	}
	
	private static boolean EditaAtributo(Automovel automovel) {
		String resposta = leitor.next(); 
		switch (resposta) {
			case "1": {
				System.out.println("\n- Digite a nova marca do veículo:");
				String marca = leitor.next();
				automovel.setMarca(marca);
				verrificarContinuarEditando();
			}
	
			default : {
				System.out.println("Resposta incorreta!");
			}
		}
		System.out.println("Finish");
		return false;
	}

	public static boolean verrificarContinuarEditando() {
		System.out.println("\nDeseja editar mais algum atributo do veículo? (S ou N)");
		String resposta = leitor.next();
		switch (resposta.toUpperCase()) {
			case "S": {
				return false;
			}
			case "N": {
				Principal.menu();
			}
			default : {
				System.out.println("\n- RESPOSTA INCORRETA -");
				System.out.println("Por favor digite S ou N:");
				return false;
			}
		}
	}

	public static void excluir() {
		System.out.println("\n+-----------------------------------------+");
		System.out.println("|             EXCLUIR VEÍCULO             |");
		System.out.println("|      (DIGITE 'C' PARA CANCELAR)         |");
		System.out.println("+-----------------------------------------+");
		System.out.println("Digite a placa do autómovel que deseja excluir:");
		String placa = leitor.next();
		verificarCancelar(placa);
		for (Automovel automovel : automoveis) {	
			if (automovel.getPlaca().equals(placa)) {
				automoveis.remove(automovel);
				System.out.println("Achei e apaguei");
				Principal.menu();
			} else {
				System.out.println("Veículo não encontrado");
				Principal.menu();
			}
		}	
	}
}
