package com.devictor.adapter;

import java.math.BigDecimal;

// Client
public class Adapter_1 {

    // Client
    // Adapter
    // Adaptee

    // Client
    public static void main(String[] args) {

        MeuPagamentoCredito credito = new MeuPagamentoCredito();
        credito.debitar(new BigDecimal("100"));

    }

}


// --------------------------------------------------------------------------------

// Adapter
class MeuPagamentoCredito { // Você tem acesso. Uma classe sua.

    SdkPagamentoCredito sdkPagamentoCredito = new SdkPagamentoCredito();

    public void debitar(BigDecimal valor) {
        sdkPagamentoCredito.autorizar(valor);
        sdkPagamentoCredito.capturar(valor);
    }

    public void creditar(BigDecimal valor) {
        sdkPagamentoCredito.creditar(valor);
    }

}


// -----------------------------------------------------------------------

// Adaptee
class SdkPagamentoCredito { // sdk fechada! você não tem acesso!

    public void autorizar(BigDecimal valor) {
        // autoriza
    }

    public void capturar(BigDecimal valor) {
        // captura
    }

    public void creditar(BigDecimal valor) {
        // credita
    }

}

