package com.example.reservas.activities;


import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.reservas.R;
import com.example.reservas.reserva.DiaMostrado;
import com.example.reservas.reserva.Reserva;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class ReservasActivity extends AppCompatActivity {

    private TextView textViewDiaActual;
    private int diasAMostrar = 0;
    private Calendar calendario = Calendar.getInstance();
    private Date fechaActual = calendario.getTime();

    private Date fechaAMostrar;

    private Map<Date,List<Reserva>> reservass = new HashMap<Date,List<Reserva>>();
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
            fechaAMostrar= mostrarDia(diasAMostrar);
        });

        buttonSiguienteDia.setOnClickListener(v -> {
            // Sumar un día al contador y mostrar el día correspondiente
            diasAMostrar++;
            fechaAMostrar= mostrarDia(diasAMostrar);
        });

        Button volverHoy= findViewById(R.id.hoy);
        volverHoy.setOnClickListener(v ->{
            diasAMostrar = 0;
            fechaAMostrar= mostrarDia(diasAMostrar);
        });
    }


    public void init(){

        // Sumar un día
        calendario.add(Calendar.DAY_OF_YEAR, 1);

        // Obtener la fecha del día siguiente
        Date fechaSiguiente = calendario.getTime();



//        reservas= new ArrayList<>();
//        reservas.add(new Reserva("Fausto", "10:00", fechaActual, 5, "pago seña"));
//        reservas.add(new Reserva("Pedro", "11:00", fechaActual, 5, "pago seña"));
//        reservas.add(new Reserva("Fran", "12:00", fechaActual, 5, "pago seña"));
//        reservas.add(new Reserva("Lucho", "13:00", fechaActual, 8, "pago seña"));
//        reservas.add(new Reserva("Agus", "14:00", fechaActual, 8, "pago seña"));
//        reservas.add(new Reserva("Fausto", "10:00", fechaActual, 8, "pago seña"));
//        reservas.add(new Reserva("Pedro", "11:00", fechaActual, 8, "pago seña"));
//        reservas.add(new Reserva("Fran", "12:00", fechaActual, 8, "pago seña"));
//
//        reservass.put(fechaActual,reservas);
//
//        List<Reserva> reservaMañana = new ArrayList<>();
//        reservaMañana.add(new Reserva("Lucho", "13:30", fechaSiguiente, 8, "pago seña"));
//        reservaMañana.add(new Reserva("Agus", "14:30", fechaSiguiente, 8, "pago seña"));
//        reservaMañana.add(new Reserva("Fausto", "10:30", fechaSiguiente, 8, "pago seña"));
//        reservaMañana.add(new Reserva("Pedro", "11:30", fechaSiguiente, 8, "pago seña"));
//        reservaMañana.add(new Reserva("Fran", "12:30", fechaSiguiente, 8, "pago seña"));
//        reservaMañana.add(new Reserva("Lucho", "13:30", fechaSiguiente, 5, "pago seña"));
//        reservaMañana.add(new Reserva("Agus", "14:30", fechaSiguiente, 5, "pago seña"));
//
//        reservass.put(fechaSiguiente,reservaMañana);

        DiaMostrado diaMostrado = new DiaMostrado(reservass.get(fechaAMostrar),this);
        RecyclerView recyclerView= findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(diaMostrado);
    }


    private void mostrarDiaActual() {
        // Mostrar el día actual en la vista de texto
        mostrarDia(0);
    }


    private Date mostrarDia(int diasAMostrar) {
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

        return fecha;
    }
}






