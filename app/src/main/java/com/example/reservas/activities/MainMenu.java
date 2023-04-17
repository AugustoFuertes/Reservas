package com.example.reservas.activities;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import com.example.reservas.R;


public class MainMenu extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu);

        //Codigo para acceder a las reservas
        CardView verReservas;
        verReservas = findViewById(R.id.ver_reservas);
        verReservas.setOnClickListener(view -> {
            Intent intent = new Intent(MainMenu.this, ReservasActivity.class);
            startActivity(intent);
        });

        //Codigo para acceder a crear reservas
        CardView crearReservas;
        crearReservas = findViewById(R.id.crear_reserva);
        crearReservas.setOnClickListener(view -> {
            Intent intent = new Intent(MainMenu.this, AddReservasAvtivity.class);
            startActivity(intent);
        });

    }
}