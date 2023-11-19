package com.example.practica_11_pokemon.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.practica_11_pokemon.R;
import com.example.practica_11_pokemon.model.Pokemon;
import com.example.practica_11_pokemon.model.Result;

import java.util.List;

public class PokemonAdapter extends RecyclerView.Adapter<PokemonAdapter.ViewHolder> {

    private List<Result> listaPokemon;

    public PokemonAdapter(List<Result> listaPokemon) {
        this.listaPokemon = listaPokemon;
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
        holder.bind(pokemon);
    }

    @Override
    public int getItemCount() {
        return listaPokemon.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView txtPokemon;
        private TextView txtDesc;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtPokemon = itemView.findViewById(R.id.txtPokemon);
            txtDesc = itemView.findViewById(R.id.txtDesc);
        }

        public void bind(Result pokemon) {
            txtPokemon.setText(pokemon.getName());
            txtDesc.setText(pokemon.geturl());
        }
    }
}

