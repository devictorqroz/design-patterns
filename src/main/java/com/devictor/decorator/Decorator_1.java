package com.devictor.decorator;


// Decorator simples
public class Decorator_1 {

    public static void main(String[] args) {

        Endereco endereco = new Endereco("Rua 4 Casa 123", "Centro", "São José", "RN", "50930-123");

        EnderecadorSimples enderecador = new EnderecadorSimples();
        EnderecadorCaixaAlta enderecadorCaixaAlta = new EnderecadorCaixaAlta(enderecador);

//        String enderecoFormatado = enderecador.preparaEndereco(endereco);
        String enderecoFormatado = enderecadorCaixaAlta.preparaEndereco(endereco);

        System.out.println(enderecoFormatado);
    }
}

//----------------------------------------------


class Endereco {
    final String logradouro;
    final String bairro;
    final String cidade;
    final String uf;
    final String cep;

    public Endereco(String logradouro, String bairro, String cidade, String uf, String cep) {
        super();
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
        this.cep = cep;
    }
}

//-----------------------------------------------------


class EnderecadorSimples {

    public String preparaEndereco(Endereco endereco) {
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
class EnderecadorCaixaAlta {

    EnderecadorSimples enderecador;

    public EnderecadorCaixaAlta(EnderecadorSimples enderecador) {
        super();
        this.enderecador = enderecador;
    }

    public String preparaEndereco(Endereco endereco) {
        return enderecador.preparaEndereco(endereco).toUpperCase();
    }
}

