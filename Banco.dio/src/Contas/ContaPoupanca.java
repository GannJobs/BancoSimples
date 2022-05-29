package Contas;

public class ContaPoupanca extends Conta{

	protected double taxaRendimento = 0.2;
	
	public ContaPoupanca(String nomecliente, int numconta, String nagencia, int cnpj) {
		super(nomecliente, numconta, nagencia, cnpj);
	}
	
	public void calculoRendimento(float saldo) {
		double Saldo = getSaldo() + getSaldo() * taxaRendimento;
		System.out.println("O rendimento de " + taxaRendimento + " ,resultara no valor de R$" + Saldo + " anualmente!");
	}
	
	public void imprimirExtrato() {
		System.out.println("Extrato Bancario da Conta Conta poupanca");
		super.imprimirExtrato();
	}
}
