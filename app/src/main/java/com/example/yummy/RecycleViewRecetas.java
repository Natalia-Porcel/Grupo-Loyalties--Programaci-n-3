package com.example.yummy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import java.util.ArrayList;

public class RecycleViewRecetas extends AppCompatActivity {
    ArrayList<String> listaRecetas = new ArrayList<>();
    RecyclerView recyclerViewRecetas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_view_recetas);
        recyclerViewRecetas = (RecyclerView) findViewById(R.id.rvRecetas);

        recyclerViewRecetas.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        listaRecetas.add("Pollo al Horno");
        listaRecetas.add("Pollo a la Coca Cola");
        listaRecetas.add("Spaguetti a la Boloñesa");
        listaRecetas.add("Pescado al horno");
        for (int i=0; i<=20;i++){
            listaRecetas.add("Receta"+i);
        }
        ReciclerViewAdapter adapter= new ReciclerViewAdapter(listaRecetas);
        recyclerViewRecetas.setAdapter(adapter);

        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(RecycleViewRecetas.this, RecetaActivity.class);
                startActivity(intent);
            }
        });
    }

}
