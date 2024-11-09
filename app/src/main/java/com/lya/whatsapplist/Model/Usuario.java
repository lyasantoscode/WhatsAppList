package com.lya.whatsapplist.Model;

public class Usuario {


    //modelo de usuario

    //aqui vamos colocar as propriedade para esse objeto: foto, nome, e mensagem
    private int foto ;///como vamos pegar o dado dentro do android studio, essa foto é uma string
    private String nome;
    private String mensagem;


    //apos criar as propriedades, vamos criar o get e o set delas
    // Feito isso, dai criamos construtor para a nossa propriedade, para quando for criar um obbjeto para lista de forma estatica precisamos do construtor


    public Usuario(int foto, String nome, String mensagem) {
        this.foto = foto;
        this.nome = nome;
        this.mensagem = mensagem;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
