package com.lei.retrofit;

import java.io.Serializable;

public class Contato implements Serializable
{
    private String nome;
    private  String telefone;
    private String status;
    private String imagem;

    public Contato() { }

    public Contato(String nome, String telefone, String status, String imagem)
    {
        this.nome = nome;
        this.telefone = telefone;
        this.status = status;
        this.imagem = imagem;
    }

    public String getNome()
    {
        return nome;
    }

    public String getTelefone()
    {
        return telefone;
    }

    public String getStatus()
    {
        return status;
    }

    public String getImagem()
    {
        return imagem;
    }
}
