package application;
import entities.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Item[] itens = new Item[5];
        RegistradorDeItens registradorDeItens = new RegistradorDeItens();

        registradorDeItens.start(itens);

        rodarPrograma(itens);
    }

    static void rodarPrograma(Item[] itens){
        int opcao=0;
        Scanner scanner = new Scanner(System.in);
        while (opcao!=itens.length+1) {
            printarMenu(itens);

            opcao= scanner.nextInt();
            scanner.nextLine();

            if (opcao==itens.length+1) {
                continue;
            }

            try {
                itens[opcao-1].venda();
            } catch (Exception e) {
                if (e instanceof IndexOutOfBoundsException) {
                    System.out.println("Opcao invalida, tente novamente");
                } else {
                    e.getMessage();
                }
            }
        }

        System.out.println("Vendas encerradas!");
        scanner.close();
    }

    static void printarMenu(Item[] itens){
        int i;
        System.out.println("Escolha um produto para comprar ou sair do programa");
        for (i = 1; i <= itens.length; i++) {
            System.out.println(i+"- "+ itens[i-1].getDescricao());
        }
        System.out.println(i+"- Sair do Programa");
    }

}