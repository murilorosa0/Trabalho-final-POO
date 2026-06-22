package entitites;

import java.time.LocalDate;
import java.util.List;

public class FaturamentoDiario {

    private LocalDate date;
    private Double totalFaturado;
    private List<Pedido> pedidos;

    public FaturamentoDiario() {
    }

    public FaturamentoDiario(LocalDate date, Double totalFaturado, List<Pedido> pedidos) {
        this.date = date;
        this.totalFaturado = totalFaturado;
        this.pedidos = pedidos;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Double getTotalFaturado() {
        return totalFaturado;
    }

    public void setTotalFaturado(Double totalFaturado) {
        this.totalFaturado = totalFaturado;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public void adicionarPedidoFaturado(Pedido pedido, double valorTotal) {

    }

}
