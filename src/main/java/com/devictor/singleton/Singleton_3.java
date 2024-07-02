package com.devictor.singleton;

// Singleton com Subclasses
public class Singleton_3 {


    public static void main(String[] args) {

    }

}

//-------------------------------------------------------------------
class ConfiguracaoAplicacao {

    private static ConfiguracaoAplicacao instance;

    public String nomeAplicacao;
    public String versao;
    public String cor;

    // propriedades a serem recuperadas
    // construtor protected !!
    protected ConfiguracaoAplicacao() {
        this.nomeAplicacao = "Singleton";
        this.versao = "3.0";
        this.cor = "Azul";
    }

    // parâmetro jvm
    // mapa - registro dos singletons
    // arquivo de config no classpath


    public ConfiguracaoAplicacao getInstance() {
        if (instance == null) {
            String configuracao = System.getProperty("class.configuracao");
            if (configuracao == "teste") {
                instance = new ConfiguracaoAplicacaoTeste();
            }
            instance = new ConfiguracaoAplicacao();
        }
        return instance;
    }
}

//---------------------------------------------------------------------


class ConfiguracaoAplicacaoTeste extends ConfiguracaoAplicacao {

    protected ConfiguracaoAplicacaoTeste() {
        this.nomeAplicacao = "Singleton Teste";
        this.versao = "3.0";
        this.cor = "Vermelho";
    }
}

