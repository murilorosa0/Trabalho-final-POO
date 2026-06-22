package entitites;

import java.util.Map;

public class CatalogoProdutos {

    private Map<String, Produto> produtos;

    public CatalogoProdutos() {
    }

    public CatalogoProdutos(Map<String, Produto> produtos) {
        this.produtos = produtos;
    }

    public Map<String, Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(Map<String, Produto> produtos) {
        this.produtos = produtos;
    }

    public void addProduto(Produto produto) {
        this.produtos.put(produto.getCodigo().toUpperCase(), produto);
    }

    public void removerProduto(String codigo) {
        if (existeProduto(codigo)) {
            this.produtos.remove(codigo.toUpperCase());
        } else {
            System.out.println("Esse produto não está no catálogo");
        }
    }

    public boolean existeProduto(String codigo) {
        return produtos.containsKey(codigo.toUpperCase());
    }

}
