package com.devictor.adapter;

import java.math.BigDecimal;


public class Adapter_2 {

    // Client
    // Adapter
    // Adaptee
    // Target

    // Client
    public static void main(String[] args) {

        ProcessorPagamento2 credito = new MeuPagamentoCredito2();
        credito.debitar(new BigDecimal("100"));
    }
}


// --------------------------------------------------------------------------------

// Target
interface ProcessorPagamento2 {

    void debitar(BigDecimal valor);

    void creditar(BigDecimal valor);

}


// --------------------------------------------------------------------------------

// Adapter
class MeuPagamentoCredito2 implements ProcessorPagamento2 { // Você tem acesso. Uma classe sua.

    SdkPagamentoCredito2 sdkPagamentoCredito2 = new SdkPagamentoCredito2();

    public void debitar(BigDecimal valor) {
        sdkPagamentoCredito2.autorizar(valor);
        sdkPagamentoCredito2.capturar(valor);
    }

    public void creditar(BigDecimal valor) {
        sdkPagamentoCredito2.creditar(valor);
    }

}


// -----------------------------------------------------------------------

// Adaptee
// sdk fechada! você não tem acesso!
// .jar adicionado no projeto / lib no maven, etc...
class SdkPagamentoCredito2 {

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

