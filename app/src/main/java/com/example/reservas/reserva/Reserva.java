package com.example.reservas.reserva;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Reserva {
    private int id;
    private String cliente;
    private String time;
    private Date date;
    private int cancha;
    private boolean seña;
    private String descripcion;

    public Reserva(int id,String cliente, String time, Date date, int cancha,boolean seña ,String descripcion) {
        this.id = id;
        this.cliente = cliente;
        this.time = time;
        this.date = date;
        this.cancha = cancha;
        this.descripcion = descripcion;
        this.seña = seña;
    }

    public int getID(){
        return id;
    }
    public String getCliente() {
        return cliente;
    }

    public String getTime() {
        return time;
    }

    public String getDateString(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(date).toString();
    }

    public Date getDate() {
        return date;
    }

    public boolean getSEÑA(){
        return seña;
    }
    public String getDescripcion(){
        return descripcion;
    }

    public int getCancha(){
        return cancha;}
}

