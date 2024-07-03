package com.devictor.templatemethod;

public class TemplateMethod_1 {

    // Abstratas
    // Concretas - Implementações

    public static void main(String[] args) {
        ProcessadorPagamento processadorPagamento = new ProcessadorPagamentoCredito();
        processadorPagamento.processarPagamento();
    }
}

//------------------------------------------------

abstract class ProcessadorPagamento {

    // Template Method
    public void processarPagamento() {
        preparar();
        validar();
        debitar();
        notificar();
        finalizar();
    }

    protected abstract void debitar();

    private void preparar() {
        System.out.println("Reservando produtos");
    }

    private void validar() {
        System.out.println("Validando cadastro");
    }

    protected void notificar() {
        System.out.println("Notificando usuário");
    }

    protected void finalizar() {
        System.out.println("Finalizando compra");
    }
}

//------------------------------------------------

class ProcessadorPagamentoCredito extends ProcessadorPagamento {

    @Override
    protected void debitar() {
        System.out.println("Debitando...");
    }

    @Override
    protected void notificar() {
        super.notificar();
        System.out.println("Notificações adicionais...");
    }
}

