package com.devictor.singleton;

public class Singleton_1 {


    public static void main(String[] args) {
//        new ProdutoFactory()

        // acessando mesmo instancia
//        ProdutoFactory.INSTANCE.novoProduto(1);
//        ProdutoFactory.INSTANCE.novoProduto(2);

        ProdutoFactory.getInstance().novoProduto(1);
        ProdutoFactory.getInstance().novoProduto(2);

    }

}


interface Produto4 {

}



class ProdutoPadrao4 implements Produto4 {

}



class ProdutoDigital4 extends ProdutoPadrao4 {

}



class ProdutoFisico4 extends ProdutoPadrao4 {

}


//-------------------------------------------------------------

// ProdutoFactory.java
class ProdutoFactory {

//    public static final ProdutoFactory INSTANCE = new ProdutoFactory();
    private static ProdutoFactory instance;

    private ProdutoFactory() {
    }


    // exemplo de uso em multithread
    // porém há alternativas melhores
//    public static synchronized ProdutoFactory getInstance() {
    public static ProdutoFactory getInstance() {
        if (instance == null ) {
            instance = new ProdutoFactory();
        }
        return instance;
    }


    public Produto4 novoProduto(int tipoProduto) {
        switch (tipoProduto) {
            case 1:
                return new ProdutoPadrao4();
            case 2:
                return new ProdutoDigital4();
            case 3:
                return new ProdutoFisico4();
            default:
                throw new IllegalArgumentException();
        }
    }
}





