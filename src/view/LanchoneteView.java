package view;

import model.Produto;
import java.util.List;

public class LanchoneteView {

    public void exibirMenuPrincipal() {
        System.out.println("\nSISTEMA DA LANCHONETE");
        System.out.println("1. Novo Pedido");
        System.out.println("2. Ver Faturamento do Dia");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }

    public void exibirRecibo(List<Produto> itens, double total) {
        System.out.println("\nCOMPROVANTE DO PEDIDO");
        for (Produto p : itens) {
            System.out.printf("- %s: R$ %.2f\n", p.getNome(), p.getPreco());
        }
        System.out.println("-----------------------------");
        System.out.printf("TOTAL A PAGAR: R$ %.2f\n", total);
        System.out.println("-----------------------------");
    }

    public void exibirMensagem(String msg) {
        System.out.println("[INFO]: " + msg);
    }

    public void exibirErro(String erro) {
        System.err.println("[ERRO]: " + erro);
    }
}