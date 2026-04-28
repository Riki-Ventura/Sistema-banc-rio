package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o valor inicial da conta: ");
        double valorInicial = scanner.nextDouble();

        ContaBancaria conta = new ContaBancaria(valorInicial);

        int opcao = 0;

        // O Loop while é executado até que alguma condição seja atendida.

        while (opcao != 7){
            System.out.println("\n========  MENU BANCO  =======");
            System.out.println("1 - Consultar Saldo");
            System.out.println("2 - Consultar Cheque Especial");
            System.out.println("3 - Depositar");
            System.out.println("4 - Sacar");
            System.out.println("5 - Verificar uso do Cheque Especial");
            System.out.println("6 - Pagar Boleto");
            System.out.println("7 - Sair");
            System.out.println("Escolha uma opção:");

            opcao = scanner.nextInt();

            if (opcao == 1){
                System.out.println("Saldo: R$ " + conta.getSaldo());
            } else if (opcao == 2){
                System.out.println("Limite Cheque Especial: R$ " + conta.getLimiteChequeEspecial());
                System.out.println("Cheque Especial usado R$: " + conta.getUsadoChequeEspecial());
            } else if (opcao == 3) {
                System.out.println("Digite o Valor do Deposito");
                double deposito = scanner.nextDouble();
                conta.depositar(deposito);
                System.out.println("Depósito realizado com sucesso!");
            } else if (opcao == 4) {
                System.out.println("Digite o valor do saque:");
                double valorSaque = scanner.nextDouble();
                conta.sacar(valorSaque);
            } else if (opcao == 5) {
                if (conta.getUsadoChequeEspecial() > 0){
                    System.out.println("A conta está usando Cheque Especial.");
                }else {
                    System.out.println("A conta não está usando Cheque Especial.");
                }
            } else if (opcao == 6) {
                System.out.println("Digite o valor do Boleto: ");
                double valorBoleto = scanner.nextDouble();
                conta.pagarBoleto(valorBoleto);
                System.out.println("Boleto pago com sucesso!");
            } else if (opcao == 7) {
                System.out.println("Sistema encerrado.");
            } else {
                System.out.println("Opção inválida");
            }
        }
        scanner.close();
    }
}