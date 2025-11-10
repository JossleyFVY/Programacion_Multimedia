package com.example.tareatema5_listas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class adaptadorPeliculas extends RecyclerView.Adapter<adaptadorPeliculas.PeliculasViewHolder> {

    private Peliculas[] listaPeliculas;

    public adaptadorPeliculas(Peliculas[] listaPeliculas) {
        this.listaPeliculas = listaPeliculas;
    }

    public static class PeliculasViewHolder extends RecyclerView.ViewHolder {
        public TextView textoTitulo;
        public ImageView imagenPelicula;
        private Context context;

        public PeliculasViewHolder(View view, Context context) {
            super(view);
            this.context = context;
            textoTitulo = view.findViewById(R.id.textoTitulo);
            imagenPelicula = view.findViewById(R.id.imagenPeliculas);
        }

        public void bindPelicula(Peliculas pelicula) {
            textoTitulo.setText(pelicula.GetTitulo());
            int idImagen = context.getResources().getIdentifier(
                    pelicula.GetImagen(),
                    "drawable",
                    context.getPackageName()
            );
            imagenPelicula.setImageResource(idImagen);
        }
    }

    @NonNull
    @Override
    public PeliculasViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.objetos_peliculas, parent, false);
        return new PeliculasViewHolder(view, parent.getContext());
    }

    @Override
    public void onBindViewHolder(@NonNull PeliculasViewHolder holder, int position) {
        holder.bindPelicula(listaPeliculas[position]);
    }

    @Override
    public int getItemCount() {
        return listaPeliculas.length;
    }
}




