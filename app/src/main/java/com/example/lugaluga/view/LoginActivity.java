package com.example.lugaluga.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.lugaluga.R;
import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity {

    private Button buttonlogin;

    private TextInputLayout inputEmail, inputSenha;

    private TextView FazerCadasto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        inputEmail = findViewById(R.id.input_email);
        inputSenha = findViewById(R.id.input_senha);
        buttonlogin = findViewById(R.id.bnt);
        FazerCadasto = findViewById(R.id.cadastro);

        Intent intent = new Intent(this, MainActivity2.class);
        buttonlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validaEmailSenha()) {
                    startActivity(intent);
                }
            }
        });

        Intent intentCadastro = new Intent(this,cadastrousuarioActivity.class);
        FazerCadasto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentCadastro);
            }
        });

    }

    public boolean validaEmailSenha(){
        if (inputEmail.getEditText() !=null
                && inputEmail.getEditText().getText().toString().equals("") ){
            inputEmail.setError("informe o email");
            return false;

        }
        if (inputSenha.getEditText() !=null
                && inputSenha.getEditText().getText().toString().equals("")){
            inputSenha.setError("informe a senha");
            return true;

        }
        return true;
    }

}