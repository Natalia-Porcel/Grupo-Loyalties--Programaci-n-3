package com.example.yummy;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecycleViewRecetas extends AppCompatActivity {
    ArrayList<Receta> listaRecetas = new ArrayList<>();
    ArrayList<String> listaRecetas1 = new ArrayList<>();
    RecyclerView recyclerViewRecetas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_view_recetas);
        recyclerViewRecetas = findViewById(R.id.rvRecetas);

        listaRecetas.add(new Receta("Trucha al horno", "-\t2 C de mantequilla derretida, divididas\n" +
                "-\t2 C de aceite de oliva\n" +
                "-\t2 c de sal de ajo\n" +
                "-\t2 c de comino\n" +
                "-\t2 c de pimienta molida fresca\n" +
                "-\t1 mitad de una trucha entera de 8-12 oz, sin cabeza ni espinas\n" +
                "-\t4 rodajas de limón\n" +
                "-\t½ taza de cilantro lavado y picado\n", "1.\tPrecalentar el horno a 350°F. Cubrir una bandeja con aceite en spray\n" +
                "2.\tEn un recipiente pequeño, mezclar la mantequilla, el aceite de oliva, la sal de ajo, el comino y la pimienta.\n" +
                "3.\tColocar la trucha en la bandeja y aplica la mezcla de la mantequilla. \n" +
                "4.\tColocar rodajas de limón encima y hornear hasta que la trucha se desarme fácilmente, por unos 15 minutos.\n" +
                "5.\tRetirar del horno y esparcir cilantro encima. \n" +
                "6.\tServir de inmediato.\n", R.drawable.trucha_horno));
        listaRecetas.add(new Receta("Espagueti a la crema de queso", "- 200 g de espagueti\n" +
                "- 150 ml de crema de leche\n" +
                "- 2 dientes de ajo picado\n" +
                "- 200 g de queso \n" +
                "- Perejil picado\n" +
                "- Sal y pimienta \n" +
                "- Aceite\n", "1. Poner a hervir agua en una olla, agregar una pizca de sal y poner el espagueti.\n" +
                "2. Remover de vez en cuando para que no se peguen en el fondo de la olla, cuando ya esté cocido el espagueti, escurrir el agua.\n" +
                "3. En un sartén grande poner a calentar a fuego fuerte un chorro de aceite, añadir ajo y dejar cocinar hasta que doren.\n" +
                "4. Añadir la crema de leche y el queso y dejar cocinar un par de minutos removiendo contantemente.\n" +
                "5. Añadir el espagueti al sartén, junto con un puñado de perejil picado y remover a fuego lento, luego servir.\n", R.drawable.espagheti_crema));
        listaRecetas.add(new Receta("Milanesa de carne", "-\t6 bifes de carne blanda\n" +
                "-\t1 taza de pan molido\n" +
                "-\tSal y pimienta a gusto\n" +
                "-\t2 huevos’\n", "1.\tSazonar los bifes con la sal y pimienta, golpear y aplanar.\n" +
                "2.\tBatir los huevos, agregarles un poco de sal y pasar os bifes por la mezcla.\n" +
                "3.\tLuego rebozar por el pan molido.\n" +
                "4.\tFreír en aceite caliente hasta que este dorado por los 2 lados.\n" +
                "5.\tEscurrir el aceite y servir. \n", R.drawable.milanesa));

        recyclerViewRecetas.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

            Intent intent = getIntent();

            if(intent.hasExtra("recetas")){
                listaRecetas1 = intent.getStringArrayListExtra("recetas");
            }

            ReciclerViewAdapter adapter= new ReciclerViewAdapter(listaRecetas1);
            recyclerViewRecetas.setAdapter(adapter);

    }

}
