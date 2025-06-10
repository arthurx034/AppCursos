package com.arthur.aplicativodecursos.model;

import com.arthur.aplicativodecursos.controller.PessoaController;

public class Curso {
    private String cursoDesejado;

    public Curso(String cursoDesejado) {
        this.cursoDesejado = cursoDesejado;
    }

    public String getCursoDesejado() {
        return cursoDesejado;
    }

    public void setCursoDesejado(String cursoDesejado) {
        this.cursoDesejado = cursoDesejado;
    }

    @Override
    public String toString() {
        Pessoa pessoa = PessoaController.carregarPessoa();

        boolean cursoValido = cursoDesejado != null && !cursoDesejado.equals("Selecione") && !cursoDesejado.isEmpty();
        boolean dadosPessoaValidos = pessoa != null &&
                pessoa.getPrimeiroNome() != null && !pessoa.getPrimeiroNome().isEmpty() &&
                pessoa.getSobrenome() != null && !pessoa.getSobrenome().isEmpty() &&
                pessoa.getTelefoneContato() != null && !pessoa.getTelefoneContato().isEmpty();

        if (cursoValido && dadosPessoaValidos) {
            return "Curso: " + cursoDesejado;
        }

        if (cursoValido) {
            return "Digite os dados da pessoa";
        }

        return "Nenhum curso selecionado";
    }


}
