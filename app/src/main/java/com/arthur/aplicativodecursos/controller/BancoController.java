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
        ContentValues valores;
        long resultado;

        db = banco.getWritableDatabase();
        valores = new ContentValues();
        valores.put(CriaBanco.primeiroNome, primeiroNome);
        valores.put(CriaBanco.sobrenome, sobrenome);
        valores.put(CriaBanco.telefoneContato, telefoneContato);
        valores.put(CriaBanco.cursoDesejado, cursoDesejado);

        resultado = db.insert(CriaBanco.TABELA, null, valores);
        db.close();

        if (resultado == -1)
            return "Erro ao inserir registro";
        else
            return "Registro Inserido com sucesso";

    }
}
