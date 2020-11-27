package com.example.brainationproject.ClassePessoa;

public class Provas {

    private String disciplina;
    private String assunto;
    private String data;

    public Provas() {
    }

    public Provas(String data, String disciplina, String assunto) {
        this.data = data;
        this.disciplina = disciplina;
        this.assunto = assunto;
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
                ", data='" + data + '\'' +
                ", assunto='" + assunto + '\'' +
                ", disciplina='" + disciplina + '\'' +

                '}';
    }
}