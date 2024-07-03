package com.devictor.decorator;


// Decorator com Interface
public class Decorator_2 {

    public static void main(String[] args) {

        Endereco2 endereco = new Endereco2("Rua 4 Casa 123", "Centro", "São José", "RN", "50930-123");

        Enderecador2 enderecador = new EnderecadorSimples2();
        enderecador = new EnderecadorCaixaAlta2(enderecador);

        String enderecoFormatado = enderecador.preparaEndereco(endereco);

        System.out.println(enderecoFormatado);
    }
}

//----------------------------------------------


class Endereco2 {
    final String logradouro;
    final String bairro;
    final String cidade;
    final String uf;
    final String cep;

    public Endereco2(String logradouro, String bairro, String cidade, String uf, String cep) {
        super();
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
        this.cep = cep;
    }
}

//-----------------------------------------------------


interface Enderecador2 {

    String preparaEndereco(Endereco2 endereco);

}

//-----------------------------------------------------


class EnderecadorSimples2 implements Enderecador2 {

    public String preparaEndereco(Endereco2 endereco) {
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
class EnderecadorCaixaAlta2 implements Enderecador2 {

    Enderecador2 enderecador;

    public EnderecadorCaixaAlta2(Enderecador2 enderecador) {
        super();
        this.enderecador = enderecador;
    }

    public String preparaEndereco(Endereco2 endereco) {
        return enderecador.preparaEndereco(endereco).toUpperCase();
    }
}

