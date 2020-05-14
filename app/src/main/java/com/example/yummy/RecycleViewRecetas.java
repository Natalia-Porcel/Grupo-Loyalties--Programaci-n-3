package com.example.yummy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import java.util.ArrayList;

public class RecycleViewRecetas extends AppCompatActivity {
    ArrayList<String> listaRecetas = new ArrayList<>();
    RecyclerView recyclerViewRecetas;
    ImageButton like;

    public RecycleViewRecetas(RecycleViewRecetas recycleViewRecetas, ArrayList<String> listaRecetas) {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_view_recetas);
        recyclerViewRecetas = (RecyclerView) findViewById(R.id.rvRecetas);
        like=findViewById(R.id.ibLike);

        recyclerViewRecetas.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        Intent intent = getIntent();

        if(intent.hasExtra("recetas")){
            listaRecetas = intent.getStringArrayListExtra("recetas");
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

        RecycleViewRecetas adapter1 = new RecycleViewRecetas(this, listaRecetas);

        like.setOnClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                RecetasFavoritasSharedPreferences.addToFav (listaRecetas.get(position));
            }
        });
        recyclerViewRecetas.setAdapter(adapter);
    }

}
