package com.devictor.proxy;

// Proxy Lazy
public class Proxy_3 {

    // RealSubject / Implementação - ProdutoDAO3
    // Proxy - LazyProdutoDAO3
    // Subject - Interface

    public static void main(String[] args) {

//        IProdutoDAO3 produtoDAO = new ProdutoDAO3();
        IProdutoDAO3 produtoDAO = new LazyProdutoDAO3();
        ProdutoService3 produtoService = new ProdutoService3(produtoDAO);
        System.out.println("Produto service criado.");

        produtoService.buscarProduto(1);
        produtoService.buscarProduto(2);
        produtoService.buscarProduto(3);
    }
}

//---------------------------------------------


class ProdutoService3 {

    private IProdutoDAO3 produtoDAO;

    public ProdutoService3(IProdutoDAO3 produtoDAO) {
        this.produtoDAO = produtoDAO;
    }

    public Object buscarProduto(long id) {
        return produtoDAO.find(id);
    }
}

//-------------------------------------------------


interface IProdutoDAO3 {

    Object find(long id);

}

//-------------------------------------------------


class ProdutoDAO3 implements IProdutoDAO3 {

    public ProdutoDAO3() {
        System.out.println("Criando conexão com  o banco.");
        simulaTempoAlto();
    }

    public Object find(long id) {
        // Busca produto e retorna
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

// Escolher entre composição (interface) ou herança.

// Composição

class LazyProdutoDAO3 implements IProdutoDAO3 {

    private IProdutoDAO3 daoReal;

    @Override
    public Object find(long id) {
        inicializaDAO();
        return daoReal.find(id);
    }

    private void inicializaDAO() {
        if (daoReal == null) {
            daoReal = new ProdutoDAO3();
        }
    }
}


// Exemplos
// @Inject - @Autowired - @EJB
// RMI / java.rmi - Remote Method Invocation

