package com.example.lugaluga.view;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lugaluga.R;
import com.example.lugaluga.model.Produto;

public class ProdutoActivity extends AppCompatActivity {

    private Produto produto;

    private TextView nomeProduto, qtdProdutos, precoProduto, descProduto;

    private Button btnAluga;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_produto);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        nomeProduto = findViewById(R.id.tv_nomeProdutoTv);
        qtdProdutos = findViewById(R.id.qtdProdutoTv);
        precoProduto = findViewById(R.id.precoProduto);
        descProduto = findViewById(R.id.descricaoTv);

        btnAluga = findViewById(R.id.alugaBtn);

        produto = getIntent().getExtras().getParcelable("produto");

        nomeProduto.setText(produto.getNome());
        qtdProdutos.setText(String.valueOf(produto.getQtd()));
        precoProduto.setText(String.valueOf(produto.getPreco()));
        descProduto.setText(produto.getDescricao());

        btnAluga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ProdutoActivity.this);
                builder.setMessage("Deseja realmente alugar este produto");
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), "Concluido", Toast.LENGTH_SHORT).show();
                    }
                });

                builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });

    }
}