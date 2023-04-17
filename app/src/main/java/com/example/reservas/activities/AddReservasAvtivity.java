package com.example.reservas.activities;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.reservas.R;

import java.util.Calendar;
import java.util.Locale;

public class AddReservasAvtivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {

    Button buutonFecha;
    TextView textFecha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_reservas);

        //Configuracion spinner horas
        Spinner spinner = findViewById(R.id.mySpinnerHoras);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.horas, R.layout.color_spinner_layout);
        adapter.setDropDownViewResource(R.layout.spinner_dropdown_layout);
        spinner.setAdapter(adapter);
        TextView selectedTextView = (TextView) spinner.getSelectedView();
        spinner.setOnItemSelectedListener(this);

        //Configuracion spinner canchas
        Spinner spinnerCanchas = findViewById(R.id.spinnerCanchas);
        ArrayAdapter<CharSequence> adapterSpinnerCanchas = ArrayAdapter.createFromResource(this, R.array.canchas, R.layout.color_spinner_layout);
        adapterSpinnerCanchas.setDropDownViewResource(R.layout.spinner_dropdown_layout);
        spinnerCanchas.setAdapter(adapterSpinnerCanchas);
        TextView selectedTextViewCanchas = (TextView) spinnerCanchas.getSelectedView();
        spinnerCanchas.setOnItemSelectedListener(this);

        //Condiguracion date picker
        buutonFecha = findViewById(R.id.buttonSelectDate);
        textFecha = findViewById(R.id.textViewDate);
        buutonFecha.setOnClickListener(this);



        //Configuracion boton voler
        Button buttonVolver = findViewById(R.id.Volver);
        buttonVolver.setOnClickListener(v -> {
            Intent intent = new Intent(AddReservasAvtivity.this, MainMenu.class);
            startActivity(intent);
        });
    }

    @Override
    public void onClick(View v){
        if(v==buutonFecha){
            final Calendar calendar = Calendar.getInstance();
            int dia= calendar.get(Calendar.DAY_OF_MONTH);
            int mes=calendar.get(Calendar.MONTH);
            int año=calendar.get(Calendar.YEAR);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this, android.R.style.Theme_Holo_Light_Dialog_NoActionBar, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    textFecha.setText(dayOfMonth+"/"+(month+1)+"/"+year);
                }
            }, año, mes, dia);

            datePickerDialog.show();
        }
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}
