package com.devictor.prototype;

import java.util.HashMap;
import java.util.Map;

// Prototype Registry estático
public class Prototype_2 {

    // Prototype (Cloneable)
    // ConcretePrototype
    // Cliente

    public static void main(String[] args) throws CloneNotSupportedException {

        DocumentosRegistry2 registry = DocumentosRegistry2.getInstance();
        Documento2 pdfRegistro = registry.getDocumento2("PDF RESTRITO");
        System.out.println(pdfRegistro);
        pdfRegistro.nome = "Lista em pdf";
        System.out.println(pdfRegistro);

        pdfRegistro = registry.getDocumento2("PDF RESTRITO");
        System.out.println(pdfRegistro);
    }
}

//---------------------------------------------

final class Documento2 implements Cloneable {

    String nome;
    String visibilidade;
    String tipo;
    String localizacao; // url, path..

    @Override
    public Documento2 clone() throws CloneNotSupportedException {
        return (Documento2) super.clone();
    }

    @Override
    public String toString() {
        return "Documento2 [nome=" + nome + ", visibilidade=" + visibilidade
                + ", tipo=" + tipo + ", localização=" + localizacao + "]";
    }
}

//---------------------------------------------


final class DocumentosRegistry2 {

    private static final DocumentosRegistry2 INSTANCE = new DocumentosRegistry2();

    private static final Map<String, Documento2> REGISTRY = new HashMap<>();

    static {
        Documento2 d1 = new Documento2();
        d1.tipo = "PDF";
        d1.visibilidade = "RESTRITO";
        REGISTRY.put("PDF RESTRITO", d1);

        Documento2 d2 = new Documento2();
        d2.tipo = "PDF";
        d2.visibilidade = "PUBLICO";
        REGISTRY.put("PDF PUBLICO", d2);

        Documento2 d3 = new Documento2();
        d3.tipo = "DOC";
        d3.visibilidade = "RESTRITO";
        REGISTRY.put("DOC RESTRITO", d3);

        Documento2 d4 = new Documento2();
        d4.tipo = "DOC";
        d4.visibilidade = "PUBLICO";
        REGISTRY.put("DOC PUBLICO ", d4);
    }

    public static DocumentosRegistry2 getInstance() {
        return INSTANCE;
    }

    public Documento2 getDocumento2(String chave) {
        try {
            return REGISTRY.get(chave).clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}

