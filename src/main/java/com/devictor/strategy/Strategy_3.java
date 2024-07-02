package com.devictor.strategy;

import java.math.BigDecimal;

public class Strategy_3 {


    public static void main(String[] args) {
        BigDecimal valor = new BigDecimal("10");
        Compra3 compra = new Compra3(valor);

        compra.processar(new PagamentoCartaoCredito3());
        // compra.processar(new PagamentoCartaoDebito3());
    }
}

// --------------------------------------------------------


// Interface do contexto
interface Pagavel3 {
    BigDecimal getValor();
}

// --------------------------------------------------------


// Contexto
class Compra3 implements Pagavel3 {

    BigDecimal valor;

    public Compra3(BigDecimal valor) {
        this.valor = valor;
    }

    void processar(EstrategiaPagamento3 estrategiaPagamento) {
        estrategiaPagamento.pagar(this);
    }

    @Override
    public BigDecimal getValor() {
        return valor;
    }
}

// ---------------------------------------------------------------------


// Estrategia interface
interface EstrategiaPagamento3 {

    void pagar(Pagavel3 compra);

}

// -------------------------------------------------------------------------


// Estrategia concreta
class PagamentoCartaoCredito3 implements EstrategiaPagamento3 {

    @Override
    public void pagar(Pagavel3 pagavel) {
        System.out.println("Pagou no crédito " + pagavel.getValor());
    }
}

// ---------------------------------------------------------------------------


// Estrategia concreta
class PagamentoCartaoDebito3 implements EstrategiaPagamento3 {

    @Override
    public void pagar(Pagavel3 pagavel) {
        System.out.println("Pagou no débito " + pagavel.getValor());
    }
}

