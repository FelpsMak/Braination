package com.example.brainationproject.ClassePessoa;

public class Aviso {
    private String texto;
    private String data;

    public Aviso() {
    }

    public Aviso(String texto, String data) {
        this.texto = texto;
        this.data = data;
    }


    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Atividade{" +
                ", titulo='" + texto + '\'' +
                ", data='" + data + '\'' +
                '}';
    }

}
