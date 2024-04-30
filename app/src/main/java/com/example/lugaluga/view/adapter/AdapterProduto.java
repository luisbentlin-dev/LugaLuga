package com.example.lugaluga.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lugaluga.R;
import com.example.lugaluga.model.Produto;

import java.util.List;

public class AdapterProduto  extends RecyclerView.Adapter <AdapterProduto.Viewholder> {

    private List<Produto> produtoList;

    public AdapterProduto(List<Produto> produtoList) {
        this.produtoList = produtoList;
    }

    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View ListaProdutos = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_produto,parent,false);
        return new Viewholder(ListaProdutos);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterProduto.Viewholder holder, int position) {

        holder.nomeProd.setText(produtoList.get(position).getNome());
        holder.precoProd.setText(String.valueOf(produtoList.get(position).getPreco()));
        holder.descProd.setText(produtoList.get(position).getDescricao());



    }

    @Override
    public int getItemCount() {

        return produtoList.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {

        TextView nomeProd,precoProd,descProd;
        public Viewholder(@NonNull View itemView) {
            super(itemView);
            nomeProd = itemView.findViewById(R.id.tv_nomeProduto);
            precoProd = itemView.findViewById(R.id.tv_nomePreco);
            descProd = itemView.findViewById(R.id.tv_descProd);
        }
    }
}
