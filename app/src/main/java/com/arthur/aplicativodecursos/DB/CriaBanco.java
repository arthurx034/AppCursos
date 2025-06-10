package com.arthur.aplicativodecursos.DB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by allanromanato on 5/27/15.
 */
public class CriaBanco extends SQLiteOpenHelper {
    private static final String NOME_BANCO = "banco.db";
    public static final String TABELA = "dadosUsuario";
    private static final String ID = "_id";
    public static final String primeiroNome = "primeiroNome";
    public static final String sobrenome = "sobrenome";
    public static final String telefoneContato = "telefoneContato";
    public static final String cursoDesejado = "cursoDesejado";
    private static final int VERSAO = 1;

    public CriaBanco(Context context) {
        super(context, NOME_BANCO, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE " + TABELA + "("
                + ID + " integer primary key autoincrement,"
                + primeiroNome + " primeiroNome,"
                + sobrenome + " sobrenome,"
                + telefoneContato + " telefoneContato,"
                + cursoDesejado + " cursoDesejado)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABELA);
        onCreate(db);
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
}