package br.usjt.transdutor.service;

import org.springframework.stereotype.Service;

import br.usjt.transdutor.entity.Transdutor;

@Service
public class TransdutorService {

	
	// PASSA A ENTRADA PARA UM ARRAY AUXÍLIAR
	public Transdutor criarArrayAuxiliar(String[] intermediario, Transdutor transdutor) {
		//SPLITAR O INTERMEDIARIO NO CONTROLLER
		for (String string : intermediario) {
			if(!transdutor.getAux().contains(string))
					transdutor.getAux().add(string);
		}
		return transdutor;
	}
	
	
	// ORGANIZA A ENTRADA QUE ESTÁ NO ARRAY AUXÍLIAR NO ARRAY DE VARIÁVEIS
	public Transdutor organizaAuxParaVariaveis(Transdutor transdutor) {
		
		
		for(int i = 0; i < transdutor.getAux().size(); i++) {
			Character verifica = transdutor.getAux().get(i).substring(0, 1).charAt(0);
			
			if(!Character.isDigit(verifica)) {
				
				if(!transdutor.getVariaveis().contains(transdutor.getAux().get(i))) {
					transdutor.getVariaveis().add(transdutor.getAux().get(i));
				}
			
			// ADICIONA EM VARIÁVEL SE HOUVER UMA LETRA ENTRE OS NÚMEROS
			}else if (Character.isDigit(verifica)) {
				String formatado = "";
				String separa = transdutor.getAux().get(i);
				
				for(int k = 0; k < separa.length(); k++) {
					
					int j = k + 1;
					Character digito = separa.substring(k, j).charAt(0);
					
					if(!Character.isDigit(digito)) {
						formatado = formatado + separa.substring(k, separa.length());
					
						if(!transdutor.getVariaveis().contains(formatado)) {
							transdutor.getVariaveis().add(formatado);
						}
						break;
					}
				}
			}
		}
		return transdutor;
	}
	
	//ORGANIZA A SAÍDA
	public Transdutor organizaSaida(Transdutor transdutor) {
		
		for(int i = 0; i < transdutor.getIntermediario().length; i++) {
			Character c = transdutor.getIntermediario()[i].substring(0, 1).charAt(0);
			
			if(Character.isDigit(c)) {
				String numero = "";
				String var = "";
				
				for(int j = 0; j < transdutor.getIntermediario()[i].length(); j++) {
					
					int k = j + 1;
					Character d = transdutor.getIntermediario()[i].substring(j, k).charAt(0);
				
					if(Character.isDigit(d)) {
						numero += d;
					} else {
						var = transdutor.getIntermediario()[i].substring(j, transdutor.getIntermediario()[i].length());
					}
				}
				transdutor.setSaida(transdutor.getSaida()+"N("+ numero + ")");
				if(!var.equals("")) {
					int x = 0;
					while (!transdutor.getVariaveis().get(x).equals(var)) {
						x++;
					}
					transdutor.setSaida(transdutor.getSaida()+"V(" + x + ")");
				}
			} else {
				int x = 0;
				while(!transdutor.getVariaveis().get(x).equals(transdutor.getIntermediario()[i])) {
					x++;
				}
				transdutor.setSaida(transdutor.getSaida()+"V(" + x + ")");
			}
		}
		
		return transdutor;
		
	}
	
	
	
	
}
