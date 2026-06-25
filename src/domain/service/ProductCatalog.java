package domain.service;

import domain.model.Product;

import java.util.Map;

public class ProductCatalog {

    private Map<String, Product> produtos;

    public ProductCatalog() {
    }

    public ProductCatalog(Map<String, Product> produtos) {
        this.produtos = produtos;
    }

    public Map<String, Product> getProdutos() {
        return produtos;
    }

    public void setProdutos(Map<String, Product> produtos) {
        this.produtos = produtos;
    }

    public void addProduto(Product produto) {
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
