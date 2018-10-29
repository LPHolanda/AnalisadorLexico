package br.usjt.transdutor.entity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;


@Component
public class Transdutor {

		
	private String entrada;
	
	private String saida = "";
	
	String[] intermediario;
	
	List<String> aux = new ArrayList<String>();
	
	List<String> variaveis = new ArrayList<String>();

	
	
	public String getEntrada() {
		return entrada;
	}

	public void setEntrada(String entrada) {
		this.entrada = entrada;
	}

	public String getSaida() {
		return saida;
	}

	public void setSaida(String saida) {
		this.saida = saida;
	}

	public String[] getIntermediario() {
		return intermediario;
	}

	public void setIntermediario(String[] intermediario) {
		this.intermediario = intermediario;
	}

	public List<String> getAux() {
		return aux;
	}

	public void setAux(List<String> aux) {
		this.aux = aux;
	}

	public List<String> getVariaveis() {
		return variaveis;
	}

	public void setVariaveis(List<String> variaveis) {
		this.variaveis = variaveis;
	}
	
	
	
	
	
}
