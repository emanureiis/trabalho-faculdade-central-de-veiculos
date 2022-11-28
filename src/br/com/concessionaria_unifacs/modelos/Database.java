package br.com.concessionaria_unifacs.modelos;

import java.util.Collection;
import java.util.HashSet;
import java.util.Scanner;

import br.com.concessionaria_unifacs.programa.Principal;

public class Database {
	private static Scanner leitor = new Scanner(System.in);
	private static Collection<Automovel> automoveis = new HashSet<>();
	
	public Database() {
		Automovel automovel1 = new Automovel("Chevrolet", "Corsa", "2002", "Branco", "1.0", "1234", "20.000");
		automoveis.add(automovel1);
		Automovel automovel2 = new Automovel("Chevrolet", "Corsa", "2002", "Branco", "1.0", "PJL3344", "20.000");
		automoveis.add(automovel2);
	}
	
	public static void cadastrar() {	
		int stageTotal = 7;
		int stage = 1;
		System.out.println("\n+-----------------------------------------+");
		System.out.println("|           CADASTRAR VEÍCULO             |");
		System.out.println("|      (DIGITE 'C' PARA CANCELAR)         |");
		System.out.println("+-----------------------------------------+");
		
		System.out.println("\nEtapa "+(stage++)+" de "+stageTotal+ " - Digite a placa do veículo:");
		String placa = leitor.next();
		verificarCancelar(placa);
			for (Automovel automovel : automoveis) {
				if (automovel.getPlaca() == placa) {
					System.out.println("\n+------------------------------+");
					System.out.println("|          E  R  R  O          |");
					System.out.println("+------------------------------+");
					System.out.println("Este veículo já existe.\nCadastre um novo ou exclua o existente.");
					cadastrar();
				}
			}
		
		System.out.println("Etapa "+(stage++)+" de "+stageTotal+ " - Digite a marca do veículo:");
		String marca = leitor.next();
		verificarCancelar(marca);
		
		System.out.println("\nEtapa "+(stage++)+" de "+stageTotal+ " - Digite o modelo do veículo:");
		String modelo = leitor.next();
		verificarCancelar(modelo);
		
		System.out.println("\nEtapa "+(stage++)+" de "+stageTotal+ " - Digite o ano do veículo:");
		String ano = leitor.next();
		verificarCancelar(ano);
		
		System.out.println("\nEtapa "+(stage++)+" de "+stageTotal+ " - Digite a cor do veículo:");
		String cor = leitor.next();
		verificarCancelar(cor);
		
		System.out.println("\nEtapa "+(stage++)+" de "+stageTotal+ " - Digite a motorização do veículo:");
		String motorizacao = leitor.next();
		verificarCancelar(motorizacao);
		
		System.out.println("\nEtapa "+(stage++)+" de "+stageTotal+ " - Digite o preço do veículo:");
		String preco = leitor.next();
		
		automoveis.add(new Automovel(marca, modelo, ano, cor, motorizacao, placa, preco));

		System.out.println("+------------------------------------------+");
		System.out.println("| PARABÉNS! CADASTRO REALIZADO COM SUCESSO |");
		System.out.println("+------------------------------------------+");
		
		Principal.menu();
	}
	
	public static void listar() {
		if (automoveis.size() > 0) {
			int count = 0;
			System.out.println("\n+---------------------------------------------+");
			System.out.println("|             RELAÇÃO DE VEÍCULOS             |");
			System.out.println("+---------------------------------------------+");
			for (Automovel automovel : automoveis) {
				System.out.println((count=count+1)+". "+automovel.toString()+"\n");
			}
			Principal.menu();
		}
		
//		if (automoveis.size() == 0) {
//			Boolean validador = true;
//			System.out.println("\n+------------------------------+");
//			System.out.println("|          E  R  R  O          |");
//			System.out.println("+------------------------------+");
//			System.out.println("Nenhum veículo foi cadastrado.\nDeseja cadastrar? (S ou N)");
//			String resposta = leitor.next();	
//
//			while (validador == true) {
//				switch (resposta.toUpperCase()) {
//					case "S": {
//						Database.cadastrar();
//					}
//					case "N": {
//						Principal.menu();
//					}
//					default : {
//						System.out.println("\n- RESPOSTA INCORRETA -");
//						System.out.println("Por favor digite S ou N:");
//						validador = true;
//						break;
//					}
//				}
//			}
//		}
	}
		
	public static void editar() {
		System.out.println("\n+--------------------------------------------+");
		System.out.println("|               EDITAR VEÍCULO               |");
		System.out.println("|         (DIGITE 'C' PARA CANCELAR)         |");
		System.out.println("+--------------------------------------------+");
		System.out.println("Insira a placa do autómovel que deseja editar:");
		String resposta = leitor.next();
		verificarCancelar(resposta);
		
		for (Automovel automovel : automoveis) {	
			if (automovel.getPlaca().equals(resposta)) {
				boolean validador = true;
				while (validador == true) {
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
					System.out.println("| 7. Preço                                |");
					System.out.println("| 8. Cancelar                             |");
					System.out.println("+-----------------------------------------+");
					String opcao = leitor.next();

					switch (resposta) {
						case "1": {
							System.out.println("\n- Digite a nova marca do veículo:");
							String marca = leitor.next();
							automovel.setMarca(marca);
							validador = false;
							break;
						}
						
						case "2": {
							System.out.println("\n- Digite o novo modelo do veículo:");
							String modelo = leitor.next();
							automovel.setModelo(modelo);
							validador = false;
							break;
						}
						
						case "3": {
							System.out.println("\n- Digite o novo ano do veículo:");
							String ano = leitor.next();
							automovel.setAno(ano);
							validador = false;
							break;
						}
						
						case "4": {
							System.out.println("\n- Digite a nova cor do veículo:");
							String cor = leitor.next();
							automovel.setCor(cor);
							validador = false;
							break;
						}
						
						case "5": {
							System.out.println("\n- Digite a nova motorização do veículo:");
							String motorizacao = leitor.next();
							automovel.setMotorizacao(motorizacao);
							validador = false;
							break;
						}
						
						case "6": {
							System.out.println("\n- Digite a nova placa do veículo:");
							String placa = leitor.next();
							automovel.setPlaca(placa);
							validador = false;
							break;
						}
						
						case "7": {
							System.out.println("\n- Digite o novo preço do veículo:");
							String preco = leitor.next();
							automovel.setPreco(preco);
							validador = false;
							break;
						}
						
						
						case "8": {
							validador = false;
							break;
						}
						default : {
							System.out.println("\n- RESPOSTA INCORRETA -");
							System.out.println("Digite uma opção válida!");
							validador = true;
							break;
						}
					}
					System.out.println("\n+---------------------------------------------+");
					System.out.println("| PARABÉNS! ALTERAÇÕES REALIZADAS COM SUCESSO |");
					System.out.println("+---------------------------------------------+");
					Principal.menu();
				}
			} else {
				System.out.println("\n+---------------------+");
				System.out.println("|     E  R  R  O      |");
				System.out.println("+---------------------+");
				System.out.println("Veículo não encontrado.");
				editar();
			}
		}
	}
			
	public static void excluir() {
		System.out.println("\n+---------------------------------------------+");
		System.out.println("|              EXCLUIR VEÍCULO                |");
		System.out.println("|        (DIGITE 'C' PARA CANCELAR)           |");
		System.out.println("+---------------------------------------------+");
		System.out.println("Insira a placa do autómovel que deseja excluir:");
		String placa = leitor.next();
		verificarCancelar(placa);
		
		for (Automovel automovel : automoveis) {	
			if (automovel.getPlaca().equals(placa)) {
				automoveis.remove(automovel);
				System.out.println("+------------------------------------------+");
				System.out.println("|  PARABÉNS! VEÍCULO EXCLUIDO COM SUCESSO  |");
				System.out.println("+------------------------------------------+");
				Principal.menu();
			} else {
				System.out.println("\n+---------------------+");
				System.out.println("|     E  R  R  O      |");
				System.out.println("+---------------------+");
				System.out.println("Veículo não encontrado.");
				excluir();
			}
		}	
	}

	private static void verificarCancelar(String resposta) {
		switch (resposta.toUpperCase()) {
			case "C": {
				System.out.println("\n~ Operação cancelada com sucesso! ~");
				Principal.menu();
				break;
			}
		}
	}

}