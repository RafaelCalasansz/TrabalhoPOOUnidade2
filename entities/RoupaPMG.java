package entities;

import java.util.HashMap;
import java.util.Scanner;

public class RoupaPMG implements Item {

    private String descricao;
    private int estoqueMin, estoqueMax;
    private int[] qntdEstoque = new int[3];

    private HashMap<Character,Integer> tipoDeRoupa = new HashMap<Character,Integer>();
    

    public RoupaPMG(String descricao, int estoqueMax, int estoqueMin){
        this.descricao = descricao;
        this.estoqueMax= estoqueMax;
        this.estoqueMin= estoqueMin;
        for (int i = 0; i < qntdEstoque.length; i++) {
            qntdEstoque[i] = estoqueMax;
        }

        tipoDeRoupa.put('P', 0);
        tipoDeRoupa.put('M', 1);
        tipoDeRoupa.put('G', 2);
    }

    private char escolhaTamanho(){
        Scanner scanner = new Scanner(System.in);
        String tamanho;

        System.out.println("Qual tamanho da Roupa que voce Deseja? (P, M ou G)");
        tamanho=scanner.nextLine();

        tamanho=tamanho.toUpperCase();

        return tamanho.charAt(0);

    }

    public void venda(){

        char tipo = escolhaTamanho();

        if (!tipoDeRoupa.containsKey(tipo)) {
            throw new ErroDeTamanho("Tamanho Inexistente");
        }

        int tamanho;

        tamanho=tipoDeRoupa.get(tipo);
        qntdEstoque[tamanho]--;

        if (qntdEstoque[tamanho]<estoqueMin) {
            reestoque(tamanho);
        }
    }

    private void reestoque(int tamanho){
        qntdEstoque[tamanho] = estoqueMax;
    }

    public String getDescricao() {
        return descricao;
    }

}


class ErroDeTamanho extends RuntimeException {

    String message;

    public ErroDeTamanho(String s){
        message=s;
    }

    public ErroDeTamanho(){
        message=null;
    }

    public String getMessage() {
        return message;
    }
}
