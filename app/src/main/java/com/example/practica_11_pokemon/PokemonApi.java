package com.example.practica_11_pokemon;

import com.example.practica_11_pokemon.model.Pokemon;
import com.example.practica_11_pokemon.model.Result;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface PokemonApi {

    @GET("pokemon")
    Call<Pokemon> getPokemonList(@Query("limit") int limit, @Query("offset") int offset);

    @GET("pokemon/{id}")
    Call<Result> getPokemonDetails(@Path("id") int id);
}



