package com.devictor.decorator;


// Decorator com Interface
public class Decorator_3 {

    public static void main(String[] args) {

        Endereco3 endereco = new Endereco3("Rua 4 Casa 123", "Centro", "São José", "RN", "50930-123");

        Enderecador3 enderecador = new EnderecadorSimples3();
        enderecador = new EnderecadorCaixaAlta3(enderecador);
        enderecador = new EnderecadorComBorda3(enderecador);

        String enderecoFormatado = enderecador.preparaEndereco(endereco);

        System.out.println(enderecoFormatado);
    }
}

//----------------------------------------------


class Endereco3 {
    final String logradouro;
    final String bairro;
    final String cidade;
    final String uf;
    final String cep;

    public Endereco3(String logradouro, String bairro, String cidade, String uf, String cep) {
        super();
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
        this.cep = cep;
    }
}

//-----------------------------------------------------


interface Enderecador3 {

    String preparaEndereco(Endereco3 endereco);

}

//-----------------------------------------------------


class EnderecadorSimples3 implements Enderecador3 {

    public String preparaEndereco(Endereco3 endereco) {
        StringBuilder sb = new StringBuilder();
        sb.append(endereco.logradouro);
        sb.append("\n");
        sb.append(endereco.bairro);
        sb.append("\n");
        sb.append(endereco.cidade);
        sb.append("/");
        sb.append(endereco.uf);
        sb.append("\n");
        sb.append(endereco.cep);
        return sb.toString();
    }
}

//-----------------------------------------------------------

// Decorator
class EnderecadorCaixaAlta3 implements Enderecador3 {

    Enderecador3 enderecador;

    public EnderecadorCaixaAlta3(Enderecador3 enderecador) {
        super();
        this.enderecador = enderecador;
    }

    public String preparaEndereco(Endereco3 endereco) {
        return enderecador.preparaEndereco(endereco).toUpperCase();
    }
}

//-----------------------------------------------------------

class EnderecadorComBorda3 implements Enderecador3 {

    Enderecador3 enderecador;

    public EnderecadorComBorda3(Enderecador3 enderecador) {
        super();
        this.enderecador = enderecador;
    }

    public String preparaEndereco(Endereco3 endereco) {
        String preparaEndereco = enderecador.preparaEndereco(endereco);
        StringBuilder sb = new StringBuilder();
        sb.append("-------------------------\n");
        preparaEndereco.lines().forEach(l -> sb.append("| " + l + "\n"));
        sb.append("-------------------------\n");
        return sb.toString();
    }
}

