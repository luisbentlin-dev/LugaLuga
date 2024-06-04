package com.example.lugaluga.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;


import com.example.lugaluga.R;
import com.example.lugaluga.controler.UsuarioController;
import com.example.lugaluga.model.Usuario;
import com.google.android.material.textfield.TextInputLayout;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class cadastrousuarioActivity extends AppCompatActivity {

    private Spinner spinneruf;

    private TextInputLayout input_cpf,input_nome,input_data,input_CEP,
            input_cidade,input_logradouro,input_numero,input_complemento,
            input_bairro,inputEmail,input_senha;
    private Button btnCadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrousuario);
        
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        myToolbar.setTitle("cadastro");
        setSupportActionBar(myToolbar);

        input_cpf = findViewById(R.id.input_cpf);
        input_nome = findViewById(R.id.input_nome);
        input_data = findViewById(R.id.input_data);
        input_CEP = findViewById(R.id.input_cep);
        input_cidade = findViewById(R.id.input_cidade);
        input_logradouro = findViewById(R.id.input_logradouro);
        input_numero = findViewById(R.id.input_numero);
        input_complemento = findViewById(R.id.input_complemento);
        input_bairro = findViewById(R.id.input_bairro);
        inputEmail = findViewById(R.id.input_email);
        input_senha = findViewById(R.id.input_senha);
        btnCadastrar = findViewById(R.id.btn_cadastrar);
        input_cpf.getEditText().addTextChangedListener(new TextWatcher() {

            private static final String maskCPF = "###.###.###-##";

            boolean isUpdating;

            String old = "";

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String str = s.toString().replaceAll("[^0-9]*", "");
                String mask = maskCPF;

                String mascara = "";
                if (isUpdating){
                    old = str;
                    isUpdating = false;
                    return;
                }
                int i = 0;
                for (char m : mask.toCharArray()) {
                    if ((m != '#' && str.length() > old.length()) || (m != '#' && str.length() < old.length() && str.length() != i)) {
                        mascara += m;
                        continue;
                    }


                    try {
                        mascara += str.charAt(i);
                    } catch (Exception e) {
                        break;
                    }
                    i++;
                }
                isUpdating = true;
                input_cpf.getEditText().setText(mascara);
                input_cpf.getEditText().setSelection(mascara.length());

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        spinneruf = (Spinner) findViewById(R.id.spinner_uf);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.uf_cadastro,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinneruf.setAdapter(adapter);

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                UsuarioController crud = new UsuarioController(getApplicationContext());
                Usuario usuario = new Usuario();
                usuario.setNome(input_nome.getEditText().getText().toString());
                usuario.setCpf(input_cpf.getEditText().getText().toString());
                usuario.setData(input_data.getEditText().getText().toString());
                usuario.setCep(input_CEP.getEditText().getText().toString());
                usuario.setCidade(input_cidade.getEditText().getText().toString());
                usuario.setUf(spinneruf.getSelectedItem().toString());
                usuario.setLogradouro(input_logradouro.getEditText().getText().toString());
                usuario.setNumero(input_numero.getEditText().getText().toString());
                usuario.setComplemento(input_complemento.getEditText().getText().toString());
                usuario.setBairro(input_bairro.getEditText().getText().toString());
                usuario.setEmail(inputEmail.getEditText().getText().toString());
                usuario.setSenha(input_senha.getEditText().getText().toString());

                String resultado;

                resultado = crud.insereDados(usuario.getNome(), usuario.getCpf(),usuario.getData(),usuario.getCep(),
                        usuario.getCidade(),usuario.getUf(),usuario.getLogradouro(),usuario.getNumero(),
                        usuario.getComplemento(),usuario.getBairro(),0,usuario.getEmail(),usuario.getSenha());

                Toast.makeText(getApplicationContext(),resultado, Toast.LENGTH_LONG).show();


            }
        });

        inputEmail = findViewById(R.id.input_email);

        inputEmail.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                Pattern pattern;
                Matcher matcher;
                String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
                pattern = Pattern.compile(EMAIL_PATTERN);
                CharSequence cs = (CharSequence) s;
                matcher = pattern.matcher(cs);
                if (!(matcher.matches() == true)) {
                    inputEmail.setError("Invalid email");
                } else {
                    inputEmail.setError("");
                }
            }
        });

        input_CEP = findViewById(R.id.input_cep);

        input_CEP.getEditText().addTextChangedListener(new TextWatcher() {

            private static final String maskCEP = "#####-###";

            boolean isUpdating;

            String old = "";

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String str = s.toString().replaceAll("[^0-9]*", "");
                String mask = maskCEP;

                String mascara = "";
                if (isUpdating){
                    old = str;
                    isUpdating = false;
                    return;
                }
                int i = 0;
                for (char m : mask.toCharArray()) {
                    if ((m != '#' && str.length() > old.length()) || (m != '#' && str.length() < old.length() && str.length() != i)) {
                        mascara += m;
                        continue;
                    }


                    try {
                        mascara += str.charAt(i);
                    } catch (Exception e) {
                        break;
                    }
                    i++;
                }
                isUpdating = true;
                input_CEP.getEditText().setText(mascara);
                input_CEP.getEditText().setSelection(mascara.length());

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        input_data = findViewById(R.id.input_data);

        input_data.getEditText().addTextChangedListener(new TextWatcher() {

            private static final String maskDATANASC = "##/##/####";

            boolean isUpdating;

            String old = "";

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String str = s.toString().replaceAll("[^0-9]*", "");
                String mask = maskDATANASC;

                String mascara = "";
                if (isUpdating){
                    old = str;
                    isUpdating = false;
                    return;
                }
                int i = 0;
                for (char m : mask.toCharArray()) {
                    if ((m != '#' && str.length() > old.length()) || (m != '#' && str.length() < old.length() && str.length() != i)) {
                        mascara += m;
                        continue;
                    }


                    try {
                        mascara += str.charAt(i);
                    } catch (Exception e) {
                        break;
                    }
                    i++;
                }
                isUpdating = true;
                input_data.getEditText().setText(mascara);
                input_data.getEditText().setSelection(mascara.length());

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}