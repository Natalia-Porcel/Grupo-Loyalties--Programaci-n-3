package com.example.yummy;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ReciclerViewAdapter extends RecyclerView.Adapter<ReciclerViewAdapter.ViewHolder> implements View.OnClickListener {
    ArrayList<String> recetas;
    private View.OnClickListener listener;

    public ReciclerViewAdapter(ArrayList<String> recetas) {
        this.recetas = recetas;
    }

    @NonNull
    @Override
    public ReciclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_receta, parent,false);
        view.setOnClickListener(this);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ReciclerViewAdapter.ViewHolder holder, int position) {
        holder.asignarNombres(recetas.get(position));
    }

    @Override
    public int getItemCount() {
        return recetas.size();
    }

    public void setOnClickListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onClick(View v) {
        if (listener!=null){
            listener.onClick(v);
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nombreReceta;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nombreReceta=itemView.findViewById(R.id.nameOfRecipe);
        }

        public void asignarNombres(String nombre) {
            nombreReceta.setText(nombre);
        }
    }
}
