package domain.model;

public class Order {

    private int idPedido;
    private String codigoItem, estadoDestino;
    private Double quantidade, valorUnitario;

    public Order() {
    }

    public Order(int idPedido, String codigoItem, String estadoDestino, Double quantidade, Double valorUnitario) {
        this.idPedido = idPedido;
        this.codigoItem = codigoItem;
        this.estadoDestino = estadoDestino;
        this.quantidade = quantidade;
        this.valorUnitario = valorUnitario;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public String getCodigoItem() {
        return codigoItem;
    }

    public void setCodigoItem(String codigoItem) {
        this.codigoItem = codigoItem;
    }

    public String getEstadoDestino() {
        return estadoDestino;
    }

    public void setEstadoDestino(String estadoDestino) {
        this.estadoDestino = estadoDestino;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }

    public Double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(Double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    @Override
    public String toString(){
        return "idPedido = " + idPedido + ", \ncodigoItem = " + codigoItem + ", \nquantidade = " + quantidade + ", \nvalorUnitario = " + valorUnitario + ", \nestadoDestino = " + estadoDestino;
    }
}
