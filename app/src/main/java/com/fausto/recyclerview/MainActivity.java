package com.fausto.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> listaPalabras;
    private RecyclerView recycler;
    private PalabrasAdapter adapter;
    private FloatingActionButton botonAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       listaPalabras = new ArrayList<String>();

       for(int i = 0; i<20 ; i++) {
           listaPalabras.add("Palabra " + i);
       }

       recycler = findViewById(R.id.recyclerPalabra);
       adapter = new PalabrasAdapter(listaPalabras,this);
       recycler.setAdapter(adapter);
       recycler.setLayoutManager(new LinearLayoutManager(this));

       botonAdd = findViewById(R.id.botonAdd);
       botonAdd.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               //creo un nuevo elemento en la lista
               listaPalabras.add("Palabra " + listaPalabras.size());
               //Informo al adapter que se ha insertado un nuevo item
               adapter.notifyItemInserted(listaPalabras.size());
               //hago que la lista se desplace hasta el ultima posicion
               recycler.smoothScrollToPosition(listaPalabras.size());
           }
       });


    }

}