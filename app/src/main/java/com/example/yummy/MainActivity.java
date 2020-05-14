package com.example.yummy;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    Button profile;
    EditText nombreReceta;
    TextView categorias;
    Typeface chewy;
    Typeface glacial;
    Button logout;
    private GridView gridView;
    private Categorias adaptador;

    ArrayList<InfoReceta> listaRecetas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        profile=findViewById(R.id.perfil);
        nombreReceta=findViewById(R.id.name_recipe);
        categorias=findViewById(R.id.textCategorias);
        logout=findViewById(R.id.ButtonCerrarSesion);

        String font1= "fuentes/Chewy.ttf";
        String font2= "fuentes/Glacial.otf";
        this.chewy=Typeface.createFromAsset(getAssets(),font1);
        this.glacial=Typeface.createFromAsset(getAssets(),font2);
        profile.setTypeface(chewy);
        categorias.setTypeface(chewy);
        nombreReceta.setTypeface(glacial);

        gridView = findViewById(R.id.gridCategoria);
        gridView.setAdapter(new AdapterCategoria(this));
        gridView.setOnItemClickListener(this);
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainActivity.this, ProfileActivity.class);
                startActivity(intent);
            }
        });
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent =new Intent(MainActivity.this, RecycleViewRecetas.class);

        if(position == 0) {
            ArrayList<String> listaRecetas = new ArrayList<>();
            listaRecetas.add("Trucha al Horno");
            listaRecetas.add("Espagueti a la crema de queso");
            listaRecetas.add("Milanesa de carne");

            intent.putExtra("recetas", listaRecetas);
        }
        if(position == 1) {
            ArrayList<String> listaRecetas = new ArrayList<>();
            listaRecetas.add("Papas asadas al horno");
            listaRecetas.add("Arroz a la jardinera");
            listaRecetas.add("Pure de papas con ajo");
            listaRecetas.add("Quinua hervida");

            intent.putExtra("recetas", listaRecetas);
        }
        if(position == 2) {
            ArrayList<String> listaRecetas = new ArrayList<>();
            listaRecetas.add("Ensalada Cesar");
            listaRecetas.add("Ensalada rusa");
            listaRecetas.add("Coleslaw");

            intent.putExtra("recetas", listaRecetas);
        }

        if(position == 3) {
            ArrayList<String> listaRecetas = new ArrayList<>();
            listaRecetas.add("Smoothie de piña, manzana y menta");
            listaRecetas.add("Margarita frozen");
            listaRecetas.add("Cafe dalgona");

            intent.putExtra("recetas", listaRecetas);
        }
        if(position == 4) {
            ArrayList<String> listaRecetas = new ArrayList<>();
            listaRecetas.add("Salsa blanca");
            listaRecetas.add("Caramelo");
            listaRecetas.add("Pesto");

            intent.putExtra("recetas", listaRecetas);
        }
        if(position == 5) {
            ArrayList<String> listaRecetas = new ArrayList<>();
            listaRecetas.add("Bolitas de cupi");
            listaRecetas.add("Bocadillos de coco");
            listaRecetas.add("Nachos conn guacamole");

            intent.putExtra("recetas", listaRecetas);
        }
        if(position == 6) {
            ArrayList<String> listaRecetas = new ArrayList<>();
            listaRecetas.add("Pudin de vainilla");
            listaRecetas.add("Mousse de chocolate");
            listaRecetas.add("Pie de limon (Sin horno)");

            intent.putExtra("recetas", listaRecetas);
        }

        if(position == 7) {
            ArrayList<String> listaRecetas = new ArrayList<>();
            listaRecetas.add("Lemonies");
            listaRecetas.add("Queque de plátano");
            listaRecetas.add("Empanadas de queso");

            intent.putExtra("recetas", listaRecetas);
        }
        if(position == 8) {
            ArrayList<String> listaRecetas = new ArrayList<>();
            listaRecetas.add("Panqueques");
            listaRecetas.add("Huevos revueltos con jamón");
            listaRecetas.add("Bowl de granola con fruta");

            intent.putExtra("recetas", listaRecetas);
        }
        if(position == 9) {
            ArrayList<String> listaRecetas = new ArrayList<>();
            listaRecetas.add("Arvejada");
            listaRecetas.add("Silpancho");
            listaRecetas.add("Plato paceño");

            intent.putExtra("recetas", listaRecetas);
        }
        startActivity(intent);

    }
}
