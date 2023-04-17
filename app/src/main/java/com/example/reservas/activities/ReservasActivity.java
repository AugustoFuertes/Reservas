package com.example.reservas.activities;


import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.reservas.R;
import com.example.reservas.reserva.DiaMostrado;
import com.example.reservas.reserva.Reserva;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

public class ReservasActivity extends AppCompatActivity {

    private TextView textViewDiaActual;
    private int diasAMostrar = 0;
    private double x1,x2,y1,y2;
    private Calendar calendario = Calendar.getInstance();

    private Date fechaActual = calendario.getTime();

    List<Reserva> reservas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservas);

        //Codigo para voler al menu principal
        ImageView leftIcon = findViewById(R.id.left_icon);
        leftIcon.setOnClickListener(v -> {
            Intent intent = new Intent(ReservasActivity.this, MainMenu.class);
            startActivity(intent);
        });

        //prueba mosrar y agregar resrevas
        init();



        textViewDiaActual = findViewById(R.id.text_view_dia_actual);
        Button buttonDiaPrevio = findViewById(R.id.button_dia_previo);
        Button buttonSiguienteDia = findViewById(R.id.button_siguiente_dia);
        // Mostrar el día actual al inicio
        mostrarDiaActual();

        buttonDiaPrevio.setOnClickListener(v -> {
            // Restar un día al contador y mostrar el día correspondiente
            diasAMostrar--;
            mostrarDia(diasAMostrar);
        });

        buttonSiguienteDia.setOnClickListener(v -> {
            // Sumar un día al contador y mostrar el día correspondiente
            diasAMostrar++;
            mostrarDia(diasAMostrar);
        });

        Button volverHoy= findViewById(R.id.hoy);
        volverHoy.setOnClickListener(v ->{
            diasAMostrar = 0;
            mostrarDiaActual();
        });
    }


    public void init(){

        reservas= new ArrayList<>();
        reservas.add(new Reserva("Fausto", "10:30", fechaActual, "cancha 1", "pago seña"));
        reservas.add(new Reserva("Pedro", "11:30", fechaActual, "cancha 1", "pago seña"));
        reservas.add(new Reserva("Fran", "12:30", fechaActual, "cancha 1", "pago seña"));
        reservas.add(new Reserva("Lucho", "13:30", fechaActual, "cancha 1", "pago seña"));
        reservas.add(new Reserva("Agus", "14:30", fechaActual, "cancha 1", "pago seña"));
        reservas.add(new Reserva("Fausto", "10:30", fechaActual, "cancha 1", "pago seña"));
        reservas.add(new Reserva("Pedro", "11:30", fechaActual, "cancha 1", "pago seña"));
        reservas.add(new Reserva("Fran", "12:30", fechaActual, "cancha 1", "pago seña"));
        reservas.add(new Reserva("Lucho", "13:30", fechaActual, "cancha 1", "pago seña"));
        reservas.add(new Reserva("Agus", "14:30", fechaActual, "cancha 1", "pago seña"));
        reservas.add(new Reserva("Fausto", "10:30", fechaActual, "cancha 1", "pago seña"));
        reservas.add(new Reserva("Pedro", "11:30", fechaActual, "cancha 1", "pago seña"));
        reservas.add(new Reserva("Fran", "12:30", fechaActual, "cancha 1", "pago seña"));
        reservas.add(new Reserva("Lucho", "13:30", fechaActual, "cancha 1", "pago seña"));
        reservas.add(new Reserva("Agus", "14:30", fechaActual, "cancha 1", "pago seña"));

        DiaMostrado diaMostrado = new DiaMostrado(fechaActual,reservas,this);
        RecyclerView recyclerView= findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(diaMostrado);
    }


    public boolean onTouchEvent(MotionEvent touchEvent){
        switch(touchEvent.getAction()){
            case MotionEvent.ACTION_DOWN:
                x1 = touchEvent.getX();
                y1 = touchEvent.getY();
                break;
            case MotionEvent.ACTION_UP:
                x2 = touchEvent.getX();
                y2 = touchEvent.getY();
                if(x1 < x2){
                    diasAMostrar--;
                    mostrarDia(diasAMostrar);
            }else if(x1 > x2){
                    diasAMostrar++;
                    mostrarDia(diasAMostrar);
            }
            break;
        }
        return false;
    }



    private void mostrarDiaActual() {
        // Mostrar el día actual en la vista de texto
        mostrarDia(0);
    }


    private void mostrarDia(int diasAMostrar) {
        // Obtener la fecha correspondiente al número de días a mostrar
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, diasAMostrar);
        Date fecha = cal.getTime();

       // Formato de la fecha
        SimpleDateFormat formatoFecha = new SimpleDateFormat("EEEE, dd/MM/yyyy", new Locale("es", "ARG"));

        // Convertir la fecha en el formato deseado
        String dia = formatoFecha.format(fecha);
        String fechaFinal = dia.substring(0,1).toUpperCase() + dia.substring(1);

        // Mostrar el día en la vista de texto
       textViewDiaActual.setText(fechaFinal);
    }
}






