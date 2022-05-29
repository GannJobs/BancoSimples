package Contas;

public class ContaCorrente extends Conta{

	public ContaCorrente(String nomecliente, int numconta, String nagencia, int cnpj) {
		super(nomecliente, numconta, nagencia, cnpj);
	}

	public void imprimirExtrato() {
		System.out.println("Extrato Bancario da Conta Corrente");
		super.imprimirExtrato();
	}
}
