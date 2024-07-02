package com.devictor.singleton;

// Singleton com Enum
public class Singleton_2 {


    public static void main(String[] args) {
        ProdutoFactory2.INSTANCE.novoProduto(1);

    }
}


interface Produto5 {
}


class ProdutoPadrao5 implements Produto5 {
}


class ProdutoDigital5 extends ProdutoPadrao5 {
}


class ProdutoFisico5 extends ProdutoPadrao5 {
}


//-------------------------------------------------------------

// ProdutoFactory.java
enum ProdutoFactory2 {
    INSTANCE;

    public Produto5 novoProduto(int tipoProduto) {
        switch (tipoProduto) {
            case 1:
                return new ProdutoPadrao5();
            case 2:
                return new ProdutoDigital5();
            case 3:
                return new ProdutoFisico5();
            default:
                throw new IllegalArgumentException();
        }
    }
}

