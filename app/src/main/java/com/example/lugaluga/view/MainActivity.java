package com.example.lugaluga.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.example.lugaluga.R;
import com.example.lugaluga.RecyclerItemClickListener;
import com.example.lugaluga.model.Produto;
import com.example.lugaluga.view.adapter.AdapterProduto;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    private AdapterProduto adapterProduto;

    private List<Produto> produtoList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.ListaProdutos);

        CriarListaProdutos();

        adapterProduto = new AdapterProduto(produtoList);


        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapterProduto);

        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getApplicationContext(), recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(MainActivity.this, ProdutoActivity.class);
                intent.putExtra("produto", produtoList.get(position));
                startActivity(intent);
            }

            @Override
            public void onLongItemClick(View view, int position) {
                Toast.makeText(getApplicationContext(),produtoList.get(position).getStatus(),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        }));



    }

    public void CriarListaProdutos(){

        Produto produto = new Produto(
                "Iphone13",
                "Iphone 64gb",
                "200,00",
                10,
                "disponível"
        );

        produtoList.add(produto);

         produto = new Produto(
                "Iphone12",
                "Iphone 128gb",
                "250,00",
                15,
                "disponível"
        );

        produtoList.add(produto);

         produto = new Produto(
                "Maquina de lavar",
                "Eletrolux",
                "150,00",
                20,
                "disponível"
        );

        produtoList.add(produto);

         produto = new Produto(
                "Fone",
                "Bluetooth",
                "100,00",
                14,
                "disponível"
        );

        produtoList.add(produto);

        produto = new Produto(
                "mouse",
                "Bluetooth",
                "50,00",
                18,
                "disponível"
        );

        produtoList.add(produto);

        produto = new Produto(
                "Ventilador",
                "Arno",
                "90,00",
                17,
                "disponível"
        );

        produtoList.add(produto);

        produto = new Produto(
                "Geladeira",
                "Brastemp",
                "150,00",
                10,
                "disponível"
        );

        produtoList.add(produto);

        produto = new Produto(
                "Micro-ondas",
                "Eletrolux",
                "125,00",
                13,
                "disponível"
        );

        produtoList.add(produto);

        produto = new Produto(
                "Computador",
                "Dell",
                "300,00",
                15,
                "disponível"
        );

        produtoList.add(produto);

        produto = new Produto(
                "Tenis nike",
                "Basquete",
                "100,00",
                20,
                "disponível"
        );

        produtoList.add(produto);
    }
}