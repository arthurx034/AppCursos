package com.example.aplicativodecursos.view;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.aplicativodecursos.R;
import com.example.aplicativodecursos.controller.CursoController;
import com.example.aplicativodecursos.controller.PessoaController;
import com.example.aplicativodecursos.model.Curso;
import com.example.aplicativodecursos.model.Pessoa;

public class MainActivity extends AppCompatActivity {

    public static final String SHARED_PREFS = "dados_prefs";

    EditText editPrimeiroNome;
    EditText editSobrenome;
    Spinner spinCursoDesejado;
    EditText editTelefoneContato;

    Button btnLimpar;
    Button btnSalvar;
    Button btnFinalizar;

    ArrayAdapter<CharSequence> adapter;
    Curso curso;
    PessoaController pessoaController;
    CursoController cursoController;

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

        // Inicialização dos componentes
        editPrimeiroNome = findViewById(R.id.editPrimeiroNome);
        editSobrenome = findViewById(R.id.editSobrenome);
        spinCursoDesejado = findViewById(R.id.spinCursoDesejado);
        editTelefoneContato = findViewById(R.id.editTelefone);

        btnLimpar = findViewById(R.id.btnLimpar);
        btnSalvar = findViewById(R.id.btnSalvar);
        btnFinalizar = findViewById(R.id.btnFinalizar);

        // Spinner adapter
        adapter = ArrayAdapter.createFromResource(
                this,
                R.array.cursos_array,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinCursoDesejado.setAdapter(adapter);

        spinCursoDesejado.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedCourse = parent.getItemAtPosition(position).toString();
                if (selectedCourse.equals("Selecione")) {
                    return;
                }
                Toast.makeText(MainActivity.this, "Selecionado: " + selectedCourse, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        // Controllers
        pessoaController = new PessoaController(this);
        cursoController = new CursoController(this);

        // Botão Limpar
        btnLimpar.setOnClickListener(view -> {
            editPrimeiroNome.getText().clear();
            editSobrenome.getText().clear();
            editTelefoneContato.getText().clear();
            spinCursoDesejado.setSelection(0);
            pessoaController.limparDados();
        });

        // Botão Finalizar
        btnFinalizar.setOnClickListener(view -> {
            Toast.makeText(MainActivity.this, "Volte Sempre", Toast.LENGTH_LONG).show();
            finish();
        });

        // Botão Salvar
        btnSalvar.setOnClickListener(view -> {
            String cursoDesejado = spinCursoDesejado.getSelectedItem().toString();

            String primeiroNome = editPrimeiroNome.getText().toString().trim();
            String sobrenome = editSobrenome.getText().toString().trim();
            String telefoneContato = editTelefoneContato.getText().toString().trim();

            Pessoa pessoa = new Pessoa(primeiroNome, sobrenome, telefoneContato);
            Curso curso = new Curso(cursoDesejado);

            boolean dadosPessoaValidos = !primeiroNome.isEmpty() && !sobrenome.isEmpty() && !telefoneContato.isEmpty();
            boolean cursoValido = !cursoDesejado.equals("Selecione");

            if (dadosPessoaValidos && cursoValido) {
                pessoaController.salvarPessoa(pessoa);
                cursoController.salvarCurso(curso);

                Toast.makeText(MainActivity.this, pessoa.toString(), Toast.LENGTH_LONG).show();
                Toast.makeText(MainActivity.this, curso.toString(), Toast.LENGTH_LONG).show();
            } else {
                if (!cursoValido) {
                    Toast.makeText(MainActivity.this, "Selecione um curso", Toast.LENGTH_SHORT).show();
                }
                if (!dadosPessoaValidos) {
                    Toast.makeText(MainActivity.this, "Digite os dados corretamente", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Carrega dados ao iniciar
        carregarDados();
    }

    public void carregarDados() {
        if (pessoaController.carregarPessoa() != null && cursoController.carregarCurso() != null) {
            Pessoa pessoa = PessoaController.carregarPessoa();
            Curso curso = CursoController.carregarCurso();

            editPrimeiroNome.setText(pessoa.getPrimeiroNome());
            editSobrenome.setText(pessoa.getSobrenome());
            editTelefoneContato.setText(pessoa.getTelefoneContato());

            String cursoSalvo = curso.getCursoDesejado();
            ArrayAdapter<CharSequence> adapter = (ArrayAdapter<CharSequence>) spinCursoDesejado.getAdapter();
            int position = adapter.getPosition(cursoSalvo);
            if (position >= 0) {
                spinCursoDesejado.setSelection(position);
            }
        }
    }
}