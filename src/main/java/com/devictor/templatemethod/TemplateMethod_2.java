package com.devictor.templatemethod;

public class TemplateMethod_2 {

    // Abstratas
    // Concretas - Implementações

    public static void main(String[] args) {
        ProcessadorPagamento2 processadorPagamento = new ProcessadorPagamentoCredito2();
        processadorPagamento.processarPagamento();
    }
}

//------------------------------------------------

abstract class ProcessadorPagamento2 {

    // Template Method
    public void processarPagamento() {
        preparar();
        validar();
        debitar();
        notificar();
        notificarAdicional();
        finalizar();
        finalizarAdicional();
    }

    protected abstract void debitar();

    private void preparar() {
        System.out.println("Reservando produtos");
    }

    private void validar() {
        System.out.println("Validando cadastro");
    }

    private void notificar() {
        System.out.println("Notificando usuário");
    }

    private void finalizar() {
        System.out.println("Finalizando compra");
    }

    protected void notificarAdicional() {
        // vazio
    }

    protected void finalizarAdicional() {
        // vazio
    }

}

//------------------------------------------------

class ProcessadorPagamentoCredito2 extends ProcessadorPagamento2 {

    @Override
    protected void debitar() {
        System.out.println("Debitando...");
    }

    @Override
    protected void notificarAdicional() {
        System.out.println("Notificações adicionais...");
    }

    @Override
    protected void finalizarAdicional() {
        System.out.println("Finalização adicional...");
    }
}

