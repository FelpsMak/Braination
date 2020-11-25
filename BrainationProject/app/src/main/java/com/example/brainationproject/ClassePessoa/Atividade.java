package com.example.brainationproject.ClassePessoa;

public class Atividade {
    private String disciplina;
    private String titulo;
    private String data;

    public Atividade() {
    }

    public Atividade(String titulo, String data, String disciplina) {
        this.titulo = titulo;
        this.data = data;
        this.disciplina = disciplina;
    }



    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

}
