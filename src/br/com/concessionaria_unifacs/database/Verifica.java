package br.com.concessionaria_unifacs.database;

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
}
