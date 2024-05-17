package br.com.alura.ConversorDeMoedas;

import javax.sound.midi.Soundbank;
import javax.swing.*;
import java.io.IOException;
import java.util.Scanner;

import static jdk.javadoc.doclet.DocletEnvironment.ModuleMode.API;

public class Principal {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);

        int opcao = 0;

        System.out.println("*********************************");
        System.out.println("Bem vindo ao Conversor de moedas");
        System.out.println("\n Para converter uma cotaçao basta apenas digitar a opçao e o valor que deseja");
        System.out.println(" Ou se preferirar terminar o processo digite 1");

        String menu = """
                *** Digite sua opçao ***
                1 - Real para Dolar
                2 - Dolar para Real
                3 - Euro para Dolar
                4 - Dolar para Euro
                5 - Real para Euro
                6 - Euro para Real
                7 - sair                                   
                """;
        System.out.println("**********************************");
        while (opcao !=7){
            System.out.println(menu);
            opcao = leitura.nextInt();
            if (opcao == 1) {
                System.out.println("o valor sera convertido de Real para Dolar");
                converterMoedas(leitura, "BRL", "USD");

            }else if (opcao ==2) {
                System.out.println("o valor sera convertido de Dolar para Real");
                converterMoedas(leitura, "USD", "BRL");

            }else if (opcao ==3) {
                System.out.println("o valor sera convertido de Euro para Dolar");
                converterMoedas(leitura, "EUR", "USD" );
            }else if (opcao ==4) {
                System.out.println("o valor sera convertido de Dolar para Euro");
                converterMoedas(leitura, "USD", "EUR" );
            }else if (opcao ==5) {
                System.out.println("o valor sera convertido de Real para Euro");
                converterMoedas(leitura, "BRL", "EUR" );
            }else if (opcao ==6) {
                System.out.println("o valor sera convertido de Euro para Real");
                converterMoedas(leitura, "EUR", "BRL" );
            }
        }

    }

    public static void converterMoedas(Scanner scanner, String moedaOrigem, String moedaDestino) {
        System.out.println("Digite o valor a ser convertido:");
        double valor = scanner.nextDouble();

        try {
            double valorConvertido=ConversorDeMoedas.converterMoeda(valor, moedaOrigem, moedaDestino);
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println(valor + " " + moedaOrigem + " equivalem a " + valorConvertido + " " + moedaDestino);
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

        } catch (IOException | InterruptedException e) {
            System.out.println("Erro ao converter moeda: " + e.getMessage());
        }
    }
}

