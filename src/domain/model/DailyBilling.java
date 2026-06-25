package domain.model;

import java.time.LocalDate;
import java.util.List;

public class DailyBilling {

    private LocalDate date;
    private Double totalFaturado;
    private List<Order> orders;

    public DailyBilling() {
    }

    public DailyBilling(LocalDate date, Double totalFaturado, List<Order> orders) {
        this.date = date;
        this.totalFaturado = totalFaturado;
        this.orders = orders;
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

    public List<Order> getPedidos() {
        return orders;
    }

    public void setPedidos(List<Order> orders) {
        this.orders = orders;
    }

    public void adicionarPedidoFaturado(Order order, double valorTotal) {

    }

}
