package entities;

public class RoupaTamanhoUnico extends Peca implements Item {
    
    public RoupaTamanhoUnico(String descricao, int estoqueMax, int estoqueMin){
        super(descricao, estoqueMax, estoqueMin);
    }


    @Override
    public void venda() {
        
        qntdEstoque--;
        
        if(qntdEstoque<estoqueMin){
            reestoque();
        }
    }
}
