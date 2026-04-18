package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Lanchonete {
    private List<Pedido> historicoPedidos;

    public Lanchonete() {
        this.historicoPedidos = new ArrayList<>();
    }

    public void registrarPedido(Pedido pedido) {
        if (!pedido.isFinalizado()) {
            throw new IllegalStateException("Apenas pedidos finalizados podem ser registrados no histórico.");
        }
        this.historicoPedidos.add(pedido);
    }

    public double consultarFaturamentoPorData(LocalDate data) {
        double totalFaturado = 0;
        for (Pedido p : historicoPedidos) {
            if (p.getData().equals(data)) {
                totalFaturado += p.calcularTotal();
            }
        }
        return totalFaturado;
    }
}