package Banco;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import Contas.Conta;

public class Banco {

	private String nome;
	private int CNPJ;
	//imagino que cada agencia seja unica, e ela tenha sua identificacao e nome
	//por isso o Map, para que nao exitam agencias duplicadas
	private Map<Double, String> agencias = new LinkedHashMap<>();
	
	public Banco(String nome, int cNPJ) {
		this.nome = nome;
		this.CNPJ = cNPJ;
	}
	
	public Conta CriarConta(String nomecliente, int numconta, Double numeroAgencia) {
		Conta c = new Conta(nomecliente, numconta, agencias.get(numeroAgencia), this.CNPJ);	
		return c;
	}

	public int getCnpj(int cnpj) {
		return CNPJ;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCNPJ() {
		return CNPJ;
	}

	public void getAgencias() {
		System.out.println(agencias.toString() + " ");
	}

	public void setAgencias(Double id, String estado) {
		this.agencias.put(id, estado);
	}
	
	public void addAgencias(Double id, String estado) {
		setAgencias(id, estado);
	}
}
