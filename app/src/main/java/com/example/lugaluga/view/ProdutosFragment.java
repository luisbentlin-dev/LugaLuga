package com.example.lugaluga.view;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.lugaluga.R;
import com.example.lugaluga.RecyclerItemClickListener;
import com.example.lugaluga.model.Produto;
import com.example.lugaluga.view.adapter.AdapterProduto;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProdutosFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProdutosFragment extends Fragment {

    private RecyclerView recyclerView;

    private AdapterProduto adapterProduto;

    private List<Produto> produtoList = new ArrayList<>();


    public ProdutosFragment() {
        // Required empty public constructor
    }


    public static ProdutosFragment newInstance(String param1, String param2) {
        ProdutosFragment fragment = new ProdutosFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_produtos, container, false);

        recyclerView=view.findViewById(R.id.ListaProdutos);

        CriarListaProdutos();

        adapterProduto = new AdapterProduto(produtoList);


        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayout.VERTICAL));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapterProduto);

        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getContext(), recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(getContext(), ProdutoActivity.class);
                intent.putExtra("produto", produtoList.get(position));
                startActivity(intent);
            }

            @Override
            public void onLongItemClick(View view, int position) {
                Toast.makeText(getContext(),produtoList.get(position).getStatus(),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        }));
        return view;
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
                "indisponivel"
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
                "indisponivel"
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
                "indisponivel"
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
                "indisponivel"
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
                "indisponivel"
        );

        produtoList.add(produto);
    }
}