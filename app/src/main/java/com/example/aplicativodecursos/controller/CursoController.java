package com.example.aplicativodecursos.controller;

import android.util.Log;

import com.example.aplicativodecursos.model.Curso;

public class CursoController {
    public String toString() {
        Log.d("MVC_Curso", "Curso iniciado...");
        return super.toString();
    }

    public void salvar(Curso curso) {
        Log.d("MVC_Curso", "Curso salvo: " + curso.toString());
    }
}
