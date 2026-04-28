package org.example;

public class ContaBancaria {

    /*saldo: Dinheiro na conta;
      limiteChequeEspecial: Quanto pode usar além do saldo;
      usadoChequeEspecial: quanto já foi usado
       */
    private double saldo;
    private double limiteChequeEspecial;
    private double usadoChequeEspecial;

    public double getSaldo(){
        return saldo;
    }
    public double getLimiteChequeEspecial(){
        return limiteChequeEspecial;
    }
    public double getUsadoChequeEspecial(){
        return usadoChequeEspecial;
    }

    // Os métodos get permitem acessar os valores dos atributos sem deixar os atributos públicos.

    public ContaBancaria (double valorInicial){
        //definir saldo
        saldo = valorInicial;
        // se valor inicial for menor que R$500,00 cheque especial terá R$50,00 de limite.
        if (saldo<=500){
            limiteChequeEspecial=50;
        }
        //se valor inicial for maior que R$500,00 cheque especial terá o valor de 50% do valor inicial.
        else {
            limiteChequeEspecial = saldo * 0.5;
        }
        //valor usado do cheque especial
        usadoChequeEspecial =0;
    }
public void sacar(double valor){
        //valor a ser sacado é o Saldo + LimeteChequeEspecial.
    if (saldo>= valor) {
        //tira do valor o saldo
        saldo = saldo - valor;
    }else {
        //tira o valor do saldo + limiteChequeEspecial.
        double falta = valor - saldo;
        double disponivelCheque = limiteChequeEspecial - usadoChequeEspecial;

        if (falta <= disponivelCheque){
            saldo = 0;
            usadoChequeEspecial += falta;
        }else{
            System.out.println("Saldo insuficiente");
        }
    }

}
public void depositar(double deposito) {
    //valor a ser depositado será usado para pagar a divida caso o cheque especial usado seja maior que 0.
    if (usadoChequeEspecial > 0) {
        //Está dizendo, meu cheque especial usado é maior que 0 (está perguntando se usei um valor maior que 0 do meu cheque especial, se sim vamos pegar parte do valor depositado mais 20% se sobrar para pagar a divida.)
        double taxa = usadoChequeEspecial * 0.2;
        double totalDivida = usadoChequeEspecial + taxa;

        if (deposito >= totalDivida) {
            deposito -= totalDivida;
            usadoChequeEspecial = 0;
            saldo += deposito;
        } else {
            usadoChequeEspecial = totalDivida - deposito;
        }
    }else{
        saldo += deposito;
    }
}
    public void pagarBoleto(double valor) {
        sacar(valor);
    }
}