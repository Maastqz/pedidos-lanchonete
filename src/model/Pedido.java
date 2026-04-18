package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private LocalDate data;
    private List<Produto> itens;
    private boolean finalizado;

    public Pedido() {
        this.data = LocalDate.now(); // Define a data de hoje
        this.itens = new ArrayList<>();
        this.finalizado = false;
    }

    public void adicionarProduto(Produto produto) {
        if (finalizado) {
            throw new IllegalStateException("Não é possível adicionar produtos a um pedido finalizado.");
        }
        this.itens.add(produto);
    }

    public double calcularTotal() {
        double total = 0;
        for (Produto p : itens) {
            total += p.getPreco();
        }
        return total;
    }

    public void finalizarPedido() {
        if (itens.isEmpty()) {
            throw new IllegalStateException("Um pedido só pode ser finalizado se tiver pelo menos um produto.");
        }
        this.finalizado = true;
    }

    public LocalDate getData() { return data; }
    public List<Produto> getItens() { return itens; }
    public boolean isFinalizado() { return finalizado; }
}