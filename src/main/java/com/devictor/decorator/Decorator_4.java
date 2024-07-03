package com.devictor.decorator;


// Decorator com Interface
public class Decorator_4 {

    public static void main(String[] args) {

        Endereco4 endereco = new Endereco4("Rua 4 Casa 123", "Centro", "São José", "RN", "50930-123");

        Enderecador4 enderecador = new EnderecadorSimples4();
        enderecador = new EnderecadorCaixaAlta4(enderecador);
        enderecador = new EnderecadorComBorda4(enderecador);

        String enderecoFormatado = enderecador.preparaEndereco(endereco);

        System.out.println(enderecoFormatado);
    }
}

//----------------------------------------------


class Endereco4 {
    final String logradouro;
    final String bairro;
    final String cidade;
    final String uf;
    final String cep;

    public Endereco4(String logradouro, String bairro, String cidade, String uf, String cep) {
        super();
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
        this.cep = cep;
    }
}

//-----------------------------------------------------


interface Enderecador4 {

    String preparaEndereco(Endereco4 endereco);

}

//-----------------------------------------------------

// Implementação
class EnderecadorSimples4 implements Enderecador4 {

    public String preparaEndereco(Endereco4 endereco) {
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

// Decorator Abstrato
abstract class EnderecadorDecorator implements Enderecador4 {
    Enderecador4 enderecador;

    public EnderecadorDecorator(Enderecador4 enderecador) {
        super();
        this.enderecador = enderecador;
    }
}

//-----------------------------------------------------------

// Decorator
class EnderecadorCaixaAlta4 extends EnderecadorDecorator {

    public EnderecadorCaixaAlta4(Enderecador4 enderecador) {
        super(enderecador);
    }

    public String preparaEndereco(Endereco4 endereco) {
        return enderecador.preparaEndereco(endereco).toUpperCase();
    }
}

//-----------------------------------------------------------

// Decorator
class EnderecadorComBorda4 extends EnderecadorDecorator {

    public EnderecadorComBorda4(Enderecador4 enderecador) {
        super(enderecador);
    }

    public String preparaEndereco(Endereco4 endereco) {
        String preparaEndereco = enderecador.preparaEndereco(endereco);
        StringBuilder sb = new StringBuilder();
        sb.append("-------------------------\n");
        preparaEndereco.lines().forEach(l -> sb.append("| " + l + "\n"));
        sb.append("-------------------------\n");
        return sb.toString();
    }
}

