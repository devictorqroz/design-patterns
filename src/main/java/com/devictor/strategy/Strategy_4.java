package com.devictor.strategy;

import java.math.BigDecimal;


// Strategy com Lambdas
public class Strategy_4 {


    public static void main(String[] args) {
        BigDecimal valor = new BigDecimal("10");
        Compra4 compra = new Compra4(valor);

        // Implementação direto como função lambda
//        compra.processarCompra(v -> out.println("Pagou no crédito " + v));
    }
}

// --------------------------------------------------------


// Contexto
class Compra4 {

    BigDecimal valor;

    public Compra4(BigDecimal valor) {
        this.valor = valor;
    }

    void processarCompra(EstrategiaPagamento4 estrategiaPagamento) {
        estrategiaPagamento.pagar(valor);
    }

}

// ---------------------------------------------------------------------


// Estrategia interface
interface EstrategiaPagamento4 {
    void pagar(BigDecimal valor);
}

