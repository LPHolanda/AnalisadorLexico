package br.usjt.projeto2.test;

import java.util.ArrayList;
import java.util.List;

public class TesteTransdutor {

	public static void main(String[] args) {

		String entrada = "A25 345 A2 A A25 25B"; 
		String saida = "";
		String[] intermediario;
		List<String> aux = new ArrayList<String>();
		List<String> variaveis = new ArrayList<String>();

		intermediario = entrada.split(" ");

		// PASSA A ENTRADA PARA UM ARRAY AUXÍLIAR
		for (String string : intermediario) {
			if (!aux.contains(string))
				aux.add(string);
		}

		// ORGANIZA A ENTRADA QUE ESTÁ NO ARRAY AUXÍLIAR NO ARRAY DE VARIÁVEIS
		for (int i = 0; i < aux.size(); i++) {
			Character verifica = aux.get(i).substring(0, 1).charAt(0);

			if (!Character.isDigit(verifica)) {

				if (!variaveis.contains(aux.get(i))) {
					variaveis.add(aux.get(i));
				}
			}

			// ADICIONA EM VARIÁVEL SE HOUVER UMA LETRA ENTRE OS NÚMEROS
			else if (Character.isDigit(verifica)) {

				String formatado = "";
				String separa = aux.get(i);

				for (int k = 0; k < separa.length(); k++) {
					
					int j = k + 1;
					Character digito = separa.substring(k, j).charAt(0);

					if (!Character.isDigit(digito)) {
						formatado = formatado + separa.substring(k, separa.length());

						if (!variaveis.contains(formatado)) {
							variaveis.add(formatado);
						}
						break;
					}
				}
			}
		}

		// ORGANIZA A SAÍDA 
		for (int i = 0; i < intermediario.length; i++) {
			Character c = intermediario[i].substring(0, 1).charAt(0);

			if (Character.isDigit(c)) {
				String numero = "";
				String var = "";

				for (int j = 0; j < intermediario[i].length(); j++) {

					int k = j + 1;
					Character d = intermediario[i].substring(j, k).charAt(0);

					if (Character.isDigit(d)) {
						numero += d;
					} else {
						var = intermediario[i].substring(j, intermediario[i].length());
					}
				}

				saida += "N(" + numero + ")";
				if (!var.equals("")) {
					int x = 0;
					while (!variaveis.get(x).equals(var)) {
						x++;
					}
					saida += "V(" + x + ")";
				}
			} else {
				int x = 0;
				while (!variaveis.get(x).equals(intermediario[i])) {
					x++;
				}
				saida += "V(" + x + ")";
			}
		}

		// OUTPUT
		System.out.println("Entrada: " + entrada);
		System.out.println("Saída: " + saida);
		System.out.println("Tabela de Variáveis");
		for (int i = 0; i < variaveis.size(); i++) {
			System.out.println(i + "  ...  " + variaveis.get(i));
		}
	}
}
