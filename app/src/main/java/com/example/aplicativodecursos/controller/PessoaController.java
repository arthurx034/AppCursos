package com.example.aplicativodecursos.controller;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.aplicativodecursos.model.Pessoa;
import com.example.aplicativodecursos.model.Curso;

public class PessoaController {
    private static final String SHARED_PREFS = "dados_prefs";
    private static SharedPreferences sharedPreferences;

    public PessoaController(Context context) {
        sharedPreferences = context.getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);
    }

    public void salvarPessoa(Pessoa pessoa, Curso curso) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("nome", pessoa.getPrimeiroNome());
        editor.putString("sobrenome", pessoa.getSobrenome());
        editor.putString("telefone", pessoa.getTelefoneContato());
        editor.putString("curso", curso.getCursoDesejado());
        editor.apply();
    }

    public static Pessoa carregarPessoa() {
        String primeiroNome = sharedPreferences.getString("nome", "NA");
        String sobrenome = sharedPreferences.getString("sobrenome", "NA");
        String telefoneContato = sharedPreferences.getString("telefone", "NA");
        return new Pessoa(primeiroNome, sobrenome, telefoneContato);
    }

    public static Curso carregarCurso() {
        String cursoDesejado = sharedPreferences.getString("curso", "NA");
        return new Curso(cursoDesejado);
    }
}
