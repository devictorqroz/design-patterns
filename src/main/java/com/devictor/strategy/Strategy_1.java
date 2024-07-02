package com.devictor.strategy;

import java.math.BigDecimal;

// Strategy - exemplo com dados
// o contexto fornece dados para a estrategia
// Desenvolvimento orientado a interface
public class Strategy_1 {

    // Estrategia - Interface
    // Estrategia - Concreta
    // Contexto - Compra


    public static void main(String[] args) {

        BigDecimal valor = new BigDecimal("10");
        Compra compra = new Compra(valor);

        compra.processarCompra(new PagamentoCartaoCredito());
        // compra.processarCompra(new PagamentoCartaoDebito());

    }

}

// -------------------------------------------------------------



// Contexto
class Compra {

    // ..
    BigDecimal valor;

    public Compra(BigDecimal valor) {
        this.valor = valor;
    }

    void processarCompra(EstrategiaPagamento estrategiaPagamento) {
        // ..
        estrategiaPagamento.pagar(valor);
    }

}

// -------------------------------------------------------------




// Estrategia - Interface
// PagamentoStrategy
interface EstrategiaPagamento {

    void pagar(BigDecimal valor);

}

// -------------------------------------------------------------



// Estrategia - Concreta
class PagamentoCartaoCredito implements EstrategiaPagamento {

    @Override
    public void pagar(BigDecimal valor) {
        System.out.println("Pagou no crédito " + valor);
    }

}

// ---------------------------------------------------------------



// Estrategia - Concreta
class PagamentoCartaoDebito implements EstrategiaPagamento {

    @Override
    public void pagar(BigDecimal valor) {
        System.out.println("Pagou no débito " + valor);
    }

}


