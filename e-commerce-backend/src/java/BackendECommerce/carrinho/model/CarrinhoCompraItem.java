package BackendECommerce.carrinho.model;

import BackendECommerce.produto.model.Produto;
import java.io.Serializable;

/**
 *
 * @author Bruno Cândido Albuquerque
 * 
 * Classe que representa um item do carrinho de compras
 */
public class CarrinhoCompraItem implements Serializable {
    
    private Produto produto;
    private int quantidade;

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
}
