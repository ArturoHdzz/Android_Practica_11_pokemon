package com.example.practica_11_pokemon;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        // Retrieve data from the intent
        String imageUrl = getIntent().getStringExtra("imageUrl");
        String description = getIntent().getStringExtra("description");

        // Initialize views in MainActivity3
        ImageView imgPokemon = findViewById(R.id.imgPokemon);
        TextView txtDesc = findViewById(R.id.txtDesc);

        // Load image using Picasso
        Picasso.get().load(imageUrl).into(imgPokemon);

        // Display description
        txtDesc.setText(description);
    }
}