package com.devictor.adapter;

import java.math.BigDecimal;

// Adapter com herança

// Vantagens:
// Facilidade em criar um two-way
// Não precisa instanciar um novo objeto

// Desvantagens:
// Falta de flexibilidade


public class Adapter_3 {

    // Client
    // Adapter
    // Adaptee
    // Target

    // Client
    public static void main(String[] args) {

        MeuPagamentoCredito3 credito = new MeuPagamentoCredito3();
        credito.debitar(new BigDecimal("100"));
    }
}


// --------------------------------------------------------------------------------

// Target
interface ProcessorPagamento3 {

    void debitar(BigDecimal valor);

    void creditar(BigDecimal valor);

}


// --------------------------------------------------------------------------------

// Adapter - Two-way (Mão Dupla)
// Você tem acesso. Uma classe sua.
class MeuPagamentoCredito3 extends SdkPagamentoCredito3
                            implements ProcessorPagamento3 {

    // ...

    public void debitar(BigDecimal valor) {
        super.autorizar(valor);
        super.capturar(valor);
    }

    public void creditar(BigDecimal valor) {
        super.creditar(valor);
    }

//    @Override
//    public void autorizar(BigDecimal valor) {
//        // mudou o comportamento - não é mais two-way
//    }

}


// -----------------------------------------------------------------------

// Adaptee
// sdk fechada! você não tem acesso!
// .jar adicionado no projeto / lib no maven, etc...
class SdkPagamentoCredito3 {

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

