package br.com.concessionaria_unifacs.database;

import br.com.concessionaria_unifacs.modelos.Automovel;
import br.com.concessionaria_unifacs.programa.Principal;

public class Verifica {
	
	public static void verificarCancelar(String resposta) {
		switch (resposta.toUpperCase()) {
			case "C": {
				System.out.println("\n~ Operação cancelada com sucesso! ~");
				Principal.menu();
				break;
			}
		}
	}
	
	public static boolean verificarPlaca(String placa) {
		for (Automovel automovel : DataBase.getAutomoveisList()) {
			if (automovel.getPlaca().equals(placa)) {
				System.out.println("\n+----------------------+");
				System.out.println("|       E R R O       |");
				System.out.println("+----------------------+");
				System.out.println("Este veículo já existe.\nCadastre um novo ou exclua o existente.");
				Principal.menu();
			}
			return true;
		}
		return false;
	}
}
