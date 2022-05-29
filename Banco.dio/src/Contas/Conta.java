package Contas;

import javax.swing.JOptionPane;

public class Conta{
	
	protected String nomeCliente;
	protected int numConta;
	protected int CNPJ;
	protected String nAgencia;
	protected int chave;
	protected float saldo;
	
	public Conta(String nomecliente, int numconta, String nagencia, int cnpj) {
		this.nomeCliente = nomecliente;
		this.numConta = numconta;
		this.nAgencia = nagencia;
		this.CNPJ = cnpj;
	}
	
	public int getCNPJ() {
		return CNPJ;
	}

	public void sacar (float saque) {
		if (saque <= saldo && saque >= 0) {
			this.saldo -= saque;
			JOptionPane.showMessageDialog(null, "Saque feito com sucesso!");
			JOptionPane.showMessageDialog(null, "Seu novo saldo e de R$" + this.saldo);
		}else {
			JOptionPane.showMessageDialog(null, "Saldo Insuficiente!");
		}
	}

	public void depositar(float deposito) {
		if (deposito > 0) {
			this.saldo += deposito;
			JOptionPane.showMessageDialog(null, "Deposito feito com sucesso!");
			JOptionPane.showMessageDialog(null, "Seu novo saldo e de R$" + this.saldo);
		}else {
			JOptionPane.showMessageDialog(null, "Deposito Invalido!");
		}
	}
	
	public void pix(float valor, int chave) {
		if (valor <= saldo && valor >= 0) {
			this.saldo -= valor;
			JOptionPane.showMessageDialog(null, "Pix feito com sucesso para a chave " + chave);
			JOptionPane.showMessageDialog(null, "Seu novo saldo e de R$" + this.saldo);
		}else {
			JOptionPane.showMessageDialog(null, "valor Invalido!");
		}
	}
	
	protected void imprimirExtrato() {
		System.out.println("Agencia de: "+ this.nAgencia);
		System.out.println("Numero da conta: "+ this.numConta);
		System.out.println("Saldo: "+ this.saldo);
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public String getnAgencia() {
		return nAgencia;
	}

	public void setnAgencia(String nAgencia) {
		this.nAgencia = nAgencia;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public int getNumConta() {
		return numConta;
	}

	public void setNumConta(int numConta) {
		this.numConta = numConta;
	}

	public float getSaldo() {
		return saldo;
	}
	
	public int getChave() {
		return chave;
	}

	public void setChave(int chave) {
		this.chave = chave;
		JOptionPane.showMessageDialog(null, "Chave criada " + chave + " com sucesso!");
	}

	public String ToString() {
		return " Nome do usuario: " + this.nomeCliente
			 + " Numero da conta: " + this.numConta
			 + " Agencia: " + this.nAgencia;
	}
}
