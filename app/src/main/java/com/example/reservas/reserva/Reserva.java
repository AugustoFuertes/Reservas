package com.example.reservas.reserva;

import java.sql.Time;
import java.util.Date;

public class Reserva {
    private String cliente;
    private String time;
    private Date date;
    private String cancha;

    private String descripcion;

    public Reserva(String cliente, String time, Date date, String cancha, String descripcion) {
        this.cliente = cliente;
        this.time = time;
        this.date = date;
        this.cancha = cancha;
        this.descripcion = descripcion;
    }

    public String getCliente() {
        return cliente;
    }

    public String getTime() {
        return time;
    }

    public Date getDate(){
        return date;
    }

    public String getCancha(){
        return cancha;}
}

