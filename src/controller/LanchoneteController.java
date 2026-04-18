package controller;

import model.*;
import view.LanchoneteView;
import java.time.LocalDate;

public class LanchoneteController {
    private Lanchonete modelLanchonete;
    private LanchoneteView view;

    public LanchoneteController(Lanchonete modelLanchonete, LanchoneteView view) {
        this.modelLanchonete = modelLanchonete;
        this.view = view;
    }

    public void processarFinalizacao(Pedido pedido) {
        try {
            pedido.finalizarPedido(); // O Model valida a regra (mínimo 1 item)
            modelLanchonete.registrarPedido(pedido); // O Model salva no histórico

            view.exibirRecibo(pedido.getItens(), pedido.calcularTotal());
            view.exibirMensagem("Pedido registrado com sucesso!");
        } catch (Exception e) {
            view.exibirErro(e.getMessage());
        }
    }

    public void mostrarFaturamento(LocalDate data) {
        double total = modelLanchonete.consultarFaturamentoPorData(data);
        view.exibirMensagem("Faturamento em " + data + ": R$ " + total);
    }
}