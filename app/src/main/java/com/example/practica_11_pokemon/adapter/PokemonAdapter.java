package com.example.practica_11_pokemon.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.practica_11_pokemon.MainActivity3;
import com.example.practica_11_pokemon.R;
import com.example.practica_11_pokemon.model.Pokemon;
import com.example.practica_11_pokemon.model.Result;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PokemonAdapter extends RecyclerView.Adapter<PokemonAdapter.ViewHolder> {

    private List<Result> listaPokemon;
    private Context context;


    public PokemonAdapter(List<Result> listaPokemon, Context context) {
        this.listaPokemon = listaPokemon;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.itempokemon, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Result pokemon = listaPokemon.get(position);
        Picasso.get().load(pokemon.getImageUrl()).into(holder.imgPokemon);
        holder.bind(pokemon);

        // Set OnClickListener for the txtDesc TextView
        holder.txtDesc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create an Intent to start MainActivity3
                Intent intent = new Intent(context, MainActivity3.class);

                // Pass data to MainActivity3
                intent.putExtra("imageUrl", pokemon.getImageUrl());
                intent.putExtra("description", "This is a sample description.");

                // Start MainActivity3
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listaPokemon.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView txtPokemon;
        private TextView txtDesc;
        private ImageView imgPokemon;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtPokemon = itemView.findViewById(R.id.txtPokemon);
            txtDesc = itemView.findViewById(R.id.txtDesc);
            imgPokemon = itemView.findViewById(R.id.imgPokemon);
        }

        public void bind(Result pokemon) {
            txtPokemon.setText(pokemon.getName());
        }
    }
}

