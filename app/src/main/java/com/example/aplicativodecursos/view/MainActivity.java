package com.example.aplicativodecursos.view;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.aplicativodecursos.R;
import com.example.aplicativodecursos.controller.PessoaController;
import com.example.aplicativodecursos.model.Curso;
import com.example.aplicativodecursos.model.Pessoa;

public class MainActivity extends AppCompatActivity {

    SharedPreferences preferences;
    String dadosPessoa;
    String dadosOutrapessoa;

    EditText editPrimeiroNome;
    EditText editSobrenome;
    EditText editCursoDesejado;
    EditText editTelefoneContato;

    Button btnLimpar;
    Button btnSalvar;
    Button btnFinalizar;
    public static final String SHARED_PREFS = "dados_prefs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        preferences = getSharedPreferences(SHARED_PREFS, 0);
        SharedPreferences.Editor listaVip = preferences.edit();

        PessoaController pessoaController = new PessoaController(this);

        Pessoa pessoa = new Pessoa();
        Curso curso = new Curso();

        //criar o metodo findViewById

        editPrimeiroNome = findViewById(R.id.editPrimeiroNome);
        editSobrenome = findViewById(R.id.editSobrenome);
        editCursoDesejado = findViewById(R.id.editCurso);
        editTelefoneContato = findViewById(R.id.editTelefone);
        btnLimpar = findViewById(R.id.btnLimpar);
        btnFinalizar = findViewById(R.id.btnFinalizar);
        btnSalvar = findViewById(R.id.btnSalvar);

        editPrimeiroNome.setText(pessoa.getPrimeiroNome());
        editSobrenome.setText(curso.getCursoDesejado());
        editCursoDesejado.setText(curso.getCursoDesejado());
        editTelefoneContato.setText(pessoa.getTelefoneContato());

        //criando os eventos/metodos

        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editPrimeiroNome.getText().clear();
                editSobrenome.getText().clear();
                editCursoDesejado.getText().clear();
                editTelefoneContato.getText().clear();
                limparDados();
            }
        });

        btnFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Volte Sempre", Toast.LENGTH_LONG).show();
                finish();
            }
        });

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pessoa.setPrimeiroNome(editPrimeiroNome.getText().toString());
                pessoa.setSobrenome(editSobrenome.getText().toString());
                curso.setCursoDesejado(editCursoDesejado.getText().toString());
                pessoa.setTelefoneContato(editTelefoneContato.getText().toString());


                Toast.makeText(MainActivity.this, pessoa.toString(), Toast.LENGTH_LONG).show();
                Toast.makeText(MainActivity.this, curso.toString(), Toast.LENGTH_LONG).show();

                pessoaController.salvarPessoa(pessoa, curso);
            }
        });

        carregarDados();
    }

    public void carregarDados() {
        Pessoa pessoa = PessoaController.carregarPessoa();
        Curso curso = PessoaController.carregarCurso();


        editPrimeiroNome.setText(pessoa.getPrimeiroNome());
        editSobrenome.setText(pessoa.getSobrenome());
        editCursoDesejado.setText(curso.getCursoDesejado());
        editTelefoneContato.setText(pessoa.getTelefoneContato());
    }

    public void limparDados() {
        SharedPreferences.Editor editor = preferences.edit();
        editor.clear();
        editor.apply();
    }

}