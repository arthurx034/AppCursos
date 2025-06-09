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

    public void salvarPessoa(Pessoa pessoa) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("primeiroNome", pessoa.getPrimeiroNome());
        editor.putString("sobrenome", pessoa.getSobrenome());
        editor.putString("telefoneContato", pessoa.getTelefoneContato());
        editor.apply();
    }

    public static Pessoa carregarPessoa() {
        String primeiroNome = sharedPreferences.getString("primeiroNome", "");
        String sobrenome = sharedPreferences.getString("sobrenome", "");
        String telefoneContato = sharedPreferences.getString("telefoneContato", "");
        return new Pessoa(primeiroNome, sobrenome, telefoneContato);
    }

    public void limparDados() {
        sharedPreferences.edit().clear().apply();
    }
}
