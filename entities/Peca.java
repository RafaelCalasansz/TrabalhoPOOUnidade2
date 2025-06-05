package entities;

public abstract class Peca {
    int qntdEstoque, estoqueMin, estoqueMax;
    String descricao;

    public Peca(String descricao, int estoqueMax, int estoqueMin){
        this.descricao=descricao;
        this.estoqueMax=estoqueMax;
        this.estoqueMin=estoqueMin;
        qntdEstoque=estoqueMax;

        System.out.println("Peca criada com sucesso!!");
    }

    public abstract void venda();

    public String getDescricao() {
        return descricao;
    }

    public void reestoque(){
        qntdEstoque=estoqueMax;

        System.out.println("Estoque Reabastecido");
    }

}

