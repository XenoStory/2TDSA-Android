package br.com.fiap.fiapzapv2;

public class Contato
{
    private String nome;
    private String telefone;
    private String status;
    private int imagem;

    public Contato() {}

    public Contato(String nome, String telefone, String status, int imagem)
    {
        this.nome = nome;
        this.telefone = telefone;
        this.status = status;
        this.imagem = imagem;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public void setTelefone(String telefone)
    {
        this.telefone = telefone;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public void setImagem(int imagem)
    {
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

    public String getStatus() {
        return status;
    }

    public int getImagem() {
        return imagem;
    }
}
