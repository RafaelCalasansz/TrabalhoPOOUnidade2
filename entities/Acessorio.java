package entities;


import java.util.Scanner;

public class Acessorio extends Peca implements Item {

    public Acessorio(String descricao, int estoqueMax, int estoqueMin){
        super(descricao, estoqueMax, estoqueMin);
    }

    public int escolha(){
        Scanner scanner = new Scanner(System.in);
        int i;

        System.out.print("Digite quantas pecas deseja: ");

        i=scanner.nextInt();

        return i;
    }

    @Override
    public void venda(){
        int qntdVendas= escolha();

        if (qntdVendas>qntdEstoque) {
            throw new ErroDeVendas("A quantidade de peças indisponivel!");
        }
        if (qntdVendas<=0) {
            throw new ErroDeVendas("Quantidade Invalida!");
        }

        qntdEstoque-=qntdVendas;

        if (qntdEstoque<estoqueMin) {
            reestoque();
        }
    }
}

class ErroDeVendas extends RuntimeException {
    String message;

    public ErroDeVendas(){

    }

    public ErroDeVendas(String s){
        message=s;
    } 


    public String getMessage() {
        return message;
    }
}