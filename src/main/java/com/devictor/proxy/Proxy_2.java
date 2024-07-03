package com.devictor.proxy;


import java.util.HashMap;

public class Proxy_2 {

    // RealSubject / Implementação
    // Proxy

    // Proxy para Cache

    public static void main(String[] args) {

//        ProdutoDAO2 produtoDAO = new ProdutoDAO2();
        CacheProdutoDAO2 produtoDAO = new CacheProdutoDAO2();
        ProdutoService2 produtoService = new ProdutoService2(produtoDAO);

        produtoService.buscarProduto(1);
        produtoService.buscarProduto(1);
        produtoService.buscarProduto(1);
    }
}

//---------------------------------------------


class ProdutoService2 {

    private ProdutoDAO2 produtoDAO;

    public ProdutoService2(ProdutoDAO2 produtoDAO) {
        this.produtoDAO = produtoDAO;
    }

    public Object buscarProduto(long id) {
        return produtoDAO.find(id);
    }
}

//-------------------------------------------------


class ProdutoDAO2 {

    public ProdutoDAO2() {
        simulaTempoAlto();
    }

    public Object find(long id) {
        // Busca produto e retorna
        System.out.println("Busca objeto na base.");
        simulaTempoAlto();
        return new Object();
    }

    private void simulaTempoAlto() {
        try {
            // Cria conexão com o banco
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

//------------------------------------------

// Sem alteração no Cliente
// Sem alteração na Implementação original
// Herança

class CacheProdutoDAO2 extends ProdutoDAO2 {

    private static final HashMap<Long, Object> CACHE = new HashMap<>();

    @Override
    public Object find(long id) {
        Object o = CACHE.get(id);
        if (o == null) {
            o = super.find(id);
            CACHE.put(id, o);
            return o;
        }
        System.out.println("Busca objeto no cache.");
        return o;
    }

}

