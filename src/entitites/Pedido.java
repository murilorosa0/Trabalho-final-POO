package entitites;

public class Pedido {

    private String idPedido, codigoItem, estadoDestino;
    private Double quantidade, valorUnitario;

    public Pedido() {
    }

    public Pedido(String idPedido, String codigoItem, String estadoDestino, Double quantidade, Double valorUnitario) {
        this.idPedido = idPedido;
        this.codigoItem = codigoItem;
        this.estadoDestino = estadoDestino;
        this.quantidade = quantidade;
        this.valorUnitario = valorUnitario;
    }

    public String getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(String idPedido) {
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
}
