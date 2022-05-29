package Teste;

import Banco.Banco;
import Contas.Conta;
import Contas.ContaCorrente;
import Contas.ContaPoupanca;
import java.util.Scanner;

import javax.swing.JOptionPane;

import java.util.Random;

public class main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//para gerar o numero aleatorio da conta
		Random gerador = new Random();

		System.out.println("Insira seu nome para prosseguir");
		String nome = sc.next();
		System.out.println("Bem vindo " + nome + "!");
		//instancio os bancos
		Banco akashi = new Banco("Akashi", 123456789);
		Banco Miojo_Pay = new Banco("Miojo_pay", 433232298);
		//instancio o objeto conta
		Conta conta;
		//crio as agencias dos bancos
		akashi.addAgencias(1.0, "Apucarana");
		Miojo_Pay.addAgencias(1.0, "Bauru");
		//escolhe os bancos
		System.out.println("Qual banco deseja fazer as contas?");
		System.out.println("Akashi(1) ou Miojo Pay(2)");
		int escolha = sc.nextInt();
		//armazena nos bancos escolhidos
		if (escolha == 1) {
			System.out.println("Escolha o codigo da sua agencia mais proxima");
			akashi.getAgencias();
			Double agencia = sc.nextDouble();
			int nconta = gerador.nextInt(99999);
			conta = akashi.CriarConta(nome, nconta, agencia);
			JOptionPane.showMessageDialog(null, "Conta criada com sucesso!");
		} else {
			System.out.println("Escolha o codigo da sua agencia mais proxima");
			Miojo_Pay.getAgencias();
			Double agencia = sc.nextDouble();
			int nconta = gerador.nextInt(99999);
			conta = Miojo_Pay.CriarConta(nome, nconta, agencia);
			JOptionPane.showMessageDialog(null, "Conta criada com sucesso!");
		}
		//transformo a conta em conta composta, com a corrente e poupanca
		ContaPoupanca contap = new ContaPoupanca(conta.getNomeCliente(), conta.getNumConta(), conta.getnAgencia(),
				conta.getCNPJ());
		ContaCorrente contac = new ContaCorrente(conta.getNomeCliente(), conta.getNumConta(), conta.getnAgencia(),
				conta.getCNPJ());
		//so para o loop
		int a;
		//loop de usos da conta
		do {
			System.out.println("\nDeseja Algo?(0 para sair)");
			System.out.println("(1) Sacar da conta corrente");
			System.out.println("(2) Depositar na conta corrente");
			System.out.println("(3) Fazer um pix da conta corrente");
			System.out.println("(4) Criar chave pix");
			System.out.println("(5) Imprimir extrato");
			System.out.println("(6) Ver rendimento anual do dinheiro em conta poupanca");
			System.out.println("(7) Config"); // seria para alterar dados de criacao da conta ex nome, nconta...
			a = sc.nextInt();
			if (a == 1) {
				System.out.println("Insira o valor que deseja sacar");
				float valor = sc.nextFloat();
				contac.sacar(valor);
			}
			if (a == 2) {
				System.out.println("Depositar em conta corrente(1) ou poupanca(2)");
				int e = sc.nextInt();
				if (e == 1) {
					System.out.println("Insira o valor que deseja depositar");
					float valor = sc.nextFloat();
					System.out.println(valor);
					contac.depositar(valor);
				} else {
					System.out.println("Insira o valor que deseja depositar");
					float valor = sc.nextFloat();
					System.out.println(valor);
					contap.depositar(valor);
				}
			}
			if (a == 3) {
				System.out.println("Insira o valor que deseja fazer o pix");
				float valor = sc.nextFloat();
				System.out.println("Insira a chave");
				int chave = sc.nextInt();
				contac.pix(valor, chave);
			}
			if (a == 4) {
				System.out.println("Insira o numero da chave");
				int chave = sc.nextInt();
				contac.setChave(chave);
			}
			if (a == 5) {
				System.out.println("Deseja imprimir da conta Corrente(1) ou Poupanca(2)");
				int e = sc.nextInt();
				if (e == 1) {
					contac.imprimirExtrato();
				} else {
					contap.imprimirExtrato();
				}
			}
			if (a == 6) {
				contap.calculoRendimento(conta.getSaldo());
			}
			if (a == 7) {
				JOptionPane.showMessageDialog(null, "Nao fiz isso ainda rs!");
			}
		} while (a > 0);
		sc.close();
	}
}
