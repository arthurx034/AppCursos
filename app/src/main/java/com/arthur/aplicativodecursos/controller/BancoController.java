package com.arthur.aplicativodecursos.controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.arthur.aplicativodecursos.DB.CriaBanco;

public class BancoController {
    private SQLiteDatabase db;
    private CriaBanco banco;

    public BancoController(Context context) {
        banco = new CriaBanco(context);
    }

    public String insereDado(String primeiroNome, String sobrenome, String telefoneContato, String cursoDesejado) {
        ContentValues valores = new ContentValues();
        valores.put(CriaBanco.primeiroNome, primeiroNome);
        valores.put(CriaBanco.sobrenome, sobrenome);
        valores.put(CriaBanco.telefoneContato, telefoneContato);
        valores.put(CriaBanco.cursoDesejado, cursoDesejado);

        try {
            db = banco.getWritableDatabase();
            long resultado = db.insert(CriaBanco.TABELA, null, valores);

            return (resultado == -1) ? "Erro ao inserir registro" : "Registro inserido com sucesso";
        } catch (Exception e) {
            return "Erro ao inserir: " + e.getMessage();
        }
    }
}
