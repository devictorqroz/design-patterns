package com.devictor.factorymethod;

import java.security.ProtectionDomain;

public class FactoryMethod_2 {

    // Criador Concreto
    // Produto Abstrato
    // Produto Concreto


    @SuppressWarnings("unused")
    public static void main(String[] args) {

//        Categoria2 categoria2 = new Categoria2();
//        Produto2 produto2 = new categoria2.novoProduto();

    }

}


// Produto Abstrato
interface Produto2 {
}


// Produto Concreto
class ProdutoDigital2 implements Produto2 {
}


// Produto Concreto
class ProdutoFisico2 implements Produto2 {
}


// Criador Concreto
class Categoria2 {

//    private String nome;
//    private Tipo tipo;
//    private Integer prioridade;

    // Factory Method
    public Produto2 novoProduto() {
        // ... lógica para produto físico
        return new ProdutoFisico2();
    }
}


// Criador concreto
// Especialização do criador
class CategoriaDigital extends Categoria2 {

    // Sobrescrita do Factory Method
    public Produto2 novoProduto() {
        // ... lógica da subclasse
        // ... lógica para produto digital
        return new ProdutoDigital2();
    }
}

// "Terceirizando" a criação do produto
// Passando a lógica para as classes Fábricas, Criadoras.

// Com as classes de produto não necessitando ter essas lógicas dentro delas.


