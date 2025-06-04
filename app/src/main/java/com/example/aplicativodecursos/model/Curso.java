package com.example.aplicativodecursos.model;

public class Curso {
    private String cursoDesejado;

    public Curso() {
        this.cursoDesejado = cursoDesejado;
    }

    public String getCurso() {
        return cursoDesejado;
    }

    public void setCurso(String cursoDesejado) {
        this.cursoDesejado = cursoDesejado;
    }

    @Override
    public String toString() {
        return "Curso: " + cursoDesejado;
    }
}
