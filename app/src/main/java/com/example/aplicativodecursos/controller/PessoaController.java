package com.example.aplicativodecursos.controller;

import android.util.Log;

import com.example.aplicativodecursos.model.Pessoa;

public class PessoaController {
    public String toString() {
        Log.d("MVC_Controller", "Controller iniciado...");
        return super.toString();
    }

    public void salvar(Pessoa pessoa) {
        Log.d("MVC_Controller", "Pessoa salva: " + pessoa.toString());
    }
}
