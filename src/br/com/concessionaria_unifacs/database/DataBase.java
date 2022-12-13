package br.com.concessionaria_unifacs.database;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import br.com.concessionaria_unifacs.modelos.Automovel;
import br.com.concessionaria_unifacs.programa.Principal;

/**
 * A classe Database simula um pequeno
 * banco de dados que armazena os veículos
 * da concessionária.
 */
public class DataBase {
	private static Scanner leitor = new Scanner(System.in);
	private static List<Automovel> automoveisList = new ArrayList<Automovel>();
//	private static List<Automovel> automoveisLinkedList = new LinkedList<Automovel>();
	
	
	/**
	 * No construtor da classe Database foi
	 * definido que ao instanciarmos algum objeto
	 * desse tipo, serão instanciados também
	 * 07 objetos do tipo Automovel, além de adicionar
	 * esses obejetos em nossa Collection automoveis
	 */
	public DataBase() {
		Automovel automovel1 = new Automovel("Chevrolet", "Corsa", "2002", "Branco", "1.0", "ABC1234", "16.000");
		automoveisList.add(automovel1);
		Automovel automovel2 = new Automovel("Volkswagen", "Gol", "2020", "Preto", "1.6", "DEF5678", "45.000");
		automoveisList.add(automovel2);
		Automovel automovel3 = new Automovel("Pegeout", "308", "2018", "Branco", "2.0", "RDE4F68", "50.000");
		automoveisList.add(automovel3);
		Automovel automovel4 = new Automovel("Chevrolet", "Onix", "2018", "Branco", "1.8 Flex", "TRX4778", "44.900");
		automoveisList.add(automovel4);
		Automovel automovel5 = new Automovel("Hyundai", "Creta", "2022", "Prata", "2.0", "ACE098A", "109.000");
		automoveisList.add(automovel5);
		Automovel automovel6 = new Automovel("Ford", "Ka", "2019", "Azul", "1.8 Flex", "NWV6I72", "56.000");
		automoveisList.add(automovel6);
		Automovel automovel7 = new Automovel("Fiat", "Uno", "2013", "Rosa", "1.0 Flex", "BRN8542", "26.000");
		automoveisList.add(automovel7);
	}
	
	public static List<Automovel> getAutomoveisList() {
		return automoveisList;
	}

	public static void setAutomoveisList(List<Automovel> automoveisList) {
		DataBase.automoveisList = automoveisList;
	}

	public static void cadastrar() {	
		/**
		 * Define a quantidade inicial de etapas
		 * do processo de cadastro de veículos;
		 * Fizemos isso para que o incremento
		 * funcione corretamente
		 * 
		 */
		int stage = 1;
		
		/**
		 * Define a quantidade total de etapas
		 * do processo de cadastro de veículos
		 */
		int stageTotal = 7;
		System.out.println("\n+-----------------------------------------+");
		System.out.println("|           CADASTRAR VEÍCULO             |");
		System.out.println("|      (DIGITE 'C' PARA CANCELAR)         |");
		System.out.println("+-----------------------------------------+");
		
		/**
		 * Primeira etapa do cadastro 
		 */
		System.out.println("\nEtapa "+(stage++)+" de "+stageTotal+ " - Digite a placa do veículo:");
		String placa = leitor.nextLine();
		Verifica.verificarPlaca(placa);
//		Verifica.verificarCancelar(placa);
			if (Verifica.verificarPlaca(placa)) {
				Principal.menu();
			}

	
		/**
		 * Segunda etapa do cadastro 
		 */
		System.out.println("\nEtapa "+(stage++)+" de "+stageTotal+ " - Digite a marca do veículo:");
		String marca = leitor.nextLine();
		Verifica.verificarCancelar(marca);

		/**
		 * Terceira etapa do cadastro 
		 */
		System.out.println("\nEtapa "+(stage++)+" de "+stageTotal+ " - Digite o modelo do veículo:");
		String modelo = leitor.nextLine();
		Verifica.verificarCancelar(modelo);
		
		/**
		 * Quarta etapa do cadastro 
		 */
		System.out.println("\nEtapa "+(stage++)+" de "+stageTotal+ " - Digite o ano do veículo:");
		String ano = leitor.nextLine();
		Verifica.verificarCancelar(ano);
		
		/**
		 * Quinta etapa do cadastro 
		 */
		System.out.println("\nEtapa "+(stage++)+" de "+stageTotal+ " - Digite a cor do veículo:");
		String cor = leitor.nextLine();
		Verifica.verificarCancelar(cor);
		
		/**
		 * Sexta etapa do cadastro 
		 */
		System.out.println("\nEtapa "+(stage++)+" de "+stageTotal+ " - Digite a motorização do veículo:");
		String motorizacao = leitor.nextLine();
		Verifica.verificarCancelar(motorizacao);
		
		/**
		 * Sétima etapa do cadastro 
		 */
		System.out.println("\nEtapa "+(stage++)+" de "+stageTotal+ " - Digite o preço do veículo:");
		String preco = leitor.nextLine();
		
		/**
		 * Um objeto do tipo Automovel é instanciado com 
		 * todos os atributos que o usuário digitou e adicionado
		 * à Collection automoveis 
		 */
		automoveisList.add(new Automovel(marca, modelo, ano, cor, motorizacao, placa, preco));

		System.out.println("\n+------------------------------------------+");
		System.out.println("| PARABÉNS! CADASTRO REALIZADO COM SUCESSO |");
		System.out.println("+------------------------------------------+");
		
		Principal.menu();
	}
	
	/**
	 *  Este método é responsável pela listagem 
	 *  dos veículos registrados no sistema
	 */
	public static void listar() {	
		automoveisList.sort(Comparator.comparing(Automovel::getModelo));
		/**
		 * Se a Collection automoveis tiver ao menos um objeto,
		 * para cada automóvel é exibido os atributos
		 * modelo, ano e preço
		 */
		if (automoveisList.size() > 0) {
			int count = 0;
			System.out.println("\n+------------------------------------------+");
			System.out.println("|           RELAÇÃO DE VEÍCULOS            |");
			System.out.println("+------------------------------------------+");
			System.out.printf("| %-10s | %-10s | %-10s     | \n", "MODELO", "PLACA", "PREÇO");
			System.out.println("+------------------------------------------+");
			for (Automovel automovel : automoveisList) {
				System.out.format("| %-10s | %-10s | R$ %-10s  | \n", automovel.getModelo(), automovel.getPlaca(), automovel.getPreco());
	        }
	        System.out.println("+------------------------------------------+");			
			Principal.menu();
		}

	}
	
	/**
	 *  Este método edita os atributos de um veiculo especifico
	 *  baseado na placa que o usuário digítar 
	 */
	public static void editar() {
		System.out.println("\n+--------------------------------------------+");
		System.out.println("|               EDITAR VEÍCULO               |");
		System.out.println("|         (DIGITE 'C' PARA CANCELAR)         |");
		System.out.println("+--------------------------------------------+");
		System.out.println("Insira a placa do autómovel que deseja editar:");
		String resposta = leitor.next();
		Verifica.verificarCancelar(resposta);
		
		for (Automovel automovel : automoveisList) {	
			/**
			 * se a placa que o usuario digitou for igual 
			 * a de algum veiculo da Collection, este é seleciomado 
			 */
			if (automovel.getPlaca().equals(resposta)) {
				boolean validador = true;
				while (validador == true) {
					System.out.println("\n+-----------------------------------------+");
					System.out.println("|  "+automovel.getMarca()+" "+automovel.getModelo()+" "+automovel.getMotorizacao()+" - "+automovel.getAno()+" SELECIONADO  |");
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
					
					/**
					 * verifica a opcao que o usuario digitou e baseado nisso
					 * realiza um comando especifico 
					 */
					switch (opcao) {
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
							Verifica.verificarPlaca(placa);
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
				}
				System.out.println("\n+---------------------------------------------+");
				System.out.println("| PARABÉNS! ALTERAÇÕES REALIZADAS COM SUCESSO |");
				System.out.println("+---------------------------------------------+");
				Principal.menu();
			}
		}
		
		/**
		 * se a placa que o usuario digitou não for
		 * encontrada na Collection automoveis, uma mensagem
		 * de erro é impressa 
		 */
		for (Automovel automovel : automoveisList) {	
			if ((!automovel.getPlaca().equals(resposta))){
				System.out.println("\n+---------------------+");
				System.out.println("|       E R R O       |");
				System.out.println("+---------------------+");
				System.out.println("Veículo não encontrado.");
				editar();
			}
		}
	}
			
	public static void procurar() {
		System.out.println("\n+---------------------------------------------+");
		System.out.println("|              PROCURAR VEÍCULO               |");
		System.out.println("|         (DIGITE 'C' PARA CANCELAR)          |");
		System.out.println("+---------------------------------------------+");
		System.out.println("Insira a placa do automóvel que deseja procurar:");
		String resposta = leitor.next();
		Verifica.verificarCancelar(resposta);
		
		for (Automovel automovel : automoveisList) {	
			if (automovel.getPlaca().equals(resposta)) {
				System.out.println("\n+-----------------------------------------------------------------+");
				System.out.println("|                      VEÍCULO ENCONTRADO                         |");
				System.out.println("+-----------------------------------------------------------------+");
				System.out.printf("| %-10s | %-10s | %-10s | %-10s | %-10s  |\n","MARCA", "MODELO", "ANO", "PLACA", "PREÇO");
				System.out.println("+-----------------------------------------------------------------+");
				System.out.format("| %-10s | %-10s | %-10s | %-10s | R$%-10s|\n", automovel.getMarca(), automovel.getModelo(), automovel.getAno(), automovel.getPlaca(), automovel.getPreco());
				System.out.println("+-----------------------------------------------------------------+");
					Principal.menu();
			}
		}
		for (Automovel automovel : automoveisList) {	
			if ((!automovel.getPlaca().equals(resposta))){
				System.out.println("\n+---------------------+");
				System.out.println("|       E R R O       |");
				System.out.println("+---------------------+");
				System.out.println("Veículo não encontrado.");
				procurar();
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
		Verifica.verificarCancelar(placa);
		
		for (Automovel automovel : automoveisList) {	
			if (automovel.getPlaca().equals(placa)) {
				
				Boolean validador = true;
				while (validador == true) {
					System.out.println("\n"+automovel.getMarca()+" "+automovel.getModelo()+" "+automovel.getMotorizacao()+" - "+automovel.getAno()+" SELECIONADO");
					System.out.println("Deseja realmente excluir? (S/N)");
					String resposta = leitor.next();
	
					switch (resposta.toUpperCase()) {
						case "S": {
							automoveisList.remove(automovel);
							validador = false;
							break;
						}
						case "N": {
							Principal.menu();
							break;
						}
						default : {
							System.out.println("\n----- OPÇÃO INVÁLIDA -----");
							System.out.println("Por favor escolha S ou N:");
							validador = true;
							break;
						}
					}
			}
				System.out.println("\n+------------------------------------------+");
				System.out.println("|  PARABÉNS! VEÍCULO EXCLUIDO COM SUCESSO  |");
				System.out.println("+------------------------------------------+");
				Principal.menu();
			}
		}
			
		for (Automovel automovel : automoveisList) {
			if (!automovel.getPlaca().equals(placa)) {
				System.out.println("\n+---------------------+");
				System.out.println("|       E R R O       |");
				System.out.println("+---------------------+");
				System.out.println("Veículo não encontrado.");
				excluir();
			}
		}
	}
}
