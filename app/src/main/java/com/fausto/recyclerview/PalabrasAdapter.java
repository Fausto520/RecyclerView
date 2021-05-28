package com.fausto.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PalabrasAdapter extends RecyclerView.Adapter<PalabrasAdapter.PalabraHolder> {

    private Context context;
    private ArrayList<String> listapalabras;
    private LayoutInflater inflater;


    public  PalabrasAdapter(ArrayList<String> listapalabras, Context context){
        this.listapalabras = listapalabras;
        this.context = context;
        this.inflater = LayoutInflater.from(this.context);
    }

    @Override
    public PalabraHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View item = inflater.inflate(R.layout.palabras_item,parent,false);
        return new PalabraHolder(item);
    }

    @Override
    public void onBindViewHolder(PalabrasAdapter.PalabraHolder holder, int position) {
     String palabra = listapalabras.get(position);
     holder.txtPalabra.setText(palabra);

    }

    @Override
    public int getItemCount() {
        return listapalabras.size();
    }

    class PalabraHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView txtPalabra;

        public PalabraHolder(View itemView) {
            super(itemView);

            txtPalabra = itemView.findViewById(R.id.txtPalabra);

            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            int  posicion = getLayoutPosition();
            String palabra =listapalabras.get(posicion);
            listapalabras.set(posicion,"Seleccionado " + palabra);
            PalabrasAdapter.this.notifyDataSetChanged();
        }
    }

}
