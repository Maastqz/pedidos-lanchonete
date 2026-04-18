import model.Lanchonete;
import model.Pedido;
import model.Produto;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        try {
            Lanchonete minhaLanchonete = new Lanchonete();

            Produto p1 = new Produto("X-Burguer", "Pão, carne e queijo", 15.0);
            Produto p2 = new Produto("Suco de Laranja", "300ml natural", 8.0);

            Pedido pedido1 = new Pedido();
            pedido1.adicionarProduto(p1);
            pedido1.adicionarProduto(p2);

            System.out.println("Total do model.Pedido 1: R$ " + pedido1.calcularTotal());
            pedido1.finalizarPedido();
            minhaLanchonete.registrarPedido(pedido1);

            LocalDate hoje = LocalDate.now();
            double faturamento = minhaLanchonete.consultarFaturamentoPorData(hoje);

            System.out.println("Faturamento total do dia (" + hoje + "): R$ " + faturamento);

        } catch (Exception e) {
            System.err.println("Erro no sistema: " + e.getMessage());
        }
    }
}