package com.example.brainationproject.ClassePessoa;

public class Provas {

    private String titulo;
    private String disciplina;
    private String assunto;
    private String data;

    public Provas() {
    }

    public Provas(String titulo, String data, String disciplina, String assunto) {
        this.titulo = titulo;
        this.data = data;
        this.disciplina = disciplina;
        this.assunto = assunto;
    }


    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDisciplina() { return disciplina; }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }
    public String getAssunto() { return assunto; }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
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
                ", titulo='" + titulo + '\'' +
                ", data='" + data + '\'' +
                ", assunto='" + assunto + '\'' +
                ", disciplina='" + disciplina + '\'' +

                '}';
    }
}