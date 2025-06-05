package entities;

import java.util.Scanner;

public class RegistradorDeItens {
    
    public void start(Item[] itens){
        for (int i = 0; i < itens.length; i++) {
            itens[i]= registrarItem();
        }
    }

    private Item registrarItem(){
        Scanner scanner = new Scanner(System.in);
        String descricao;
        int estoqueMin, estoqueMax, i;

        System.out.println("Qual o nome do produto?");
        descricao= scanner.nextLine();

        estoqueMin=loopCheck("Digite a quantidade minima em estoque desse produto? (Necessario ser maior que 0)",
                            "Quantidade invalida, tente novamente!", 
                            0, 
                            scanner);
        
        estoqueMax=loopCheck("Digite a quantidade maxima de estoque desse produto? (Necessario ser maior que a minima)",
                            "Quantidade invalida, tente novamente!", 
                            estoqueMin, 
                            scanner);
                        
        i=loopCheck("Qual o tipo do produto registrado?"+
                           " \n [1]-Acessorio"+
                           " \n [2]-Roupa Tamanho Unico"+
                           " \n [3]-Roupa Tamanho P/M/G",
                            "Opcao invalida, tente novamente!", 0, 3, scanner);

        switch (i) {
            case 1:
                return new Acessorio(descricao, estoqueMax, estoqueMin);
            case 2:
                return new RoupaTamanhoUnico(descricao, estoqueMax, estoqueMin);
            case 3: 
                return new RoupaPMG(descricao, estoqueMax, estoqueMin);
            default:
                return null;
        
        }
}

    private int loopCheck(String startMessage, String errorMessage, int min, Scanner scanner){
        int valor;
        do {
            System.out.println(startMessage);
            valor= scanner.nextInt();
            if(valor<=min){
                System.out.println(errorMessage);
            }

        }while (valor<=min);

        return valor;
    }

    private int loopCheck(String startMessage, String errorMessage, int min,int max, Scanner scanner){
        int valor;
        do {
            System.out.println(startMessage);
            valor= scanner.nextInt();
            if(valor<=min && valor>max){
                System.out.println(errorMessage);
            }

        }while (valor<=min && valor>max);

        return valor;
    }

}
