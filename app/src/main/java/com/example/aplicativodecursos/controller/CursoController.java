package com.example.aplicativodecursos.controller;

import android.content.Context;
import android.content.SharedPreferences;
import com.example.aplicativodecursos.model.Curso;

public class CursoController {
    private static final String SHARED_PREFS = "dados_prefs";
    private static SharedPreferences sharedPreferences;

    public CursoController(Context context) {
        sharedPreferences = context.getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);
    }

    public void salvarCurso(Curso curso) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("cursoDesejado", curso.getCursoDesejado());
        editor.apply();
    }

    public static Curso carregarCurso() {
        String cursoDesejado = sharedPreferences.getString("cursoDesejado", "");
        return new Curso(cursoDesejado);
    }
}
