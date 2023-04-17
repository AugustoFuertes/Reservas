package com.example.reservas.reserva;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.reservas.R;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class DiaMostrado extends RecyclerView.Adapter<DiaMostrado.ViewHolder> {
    private Date date;
    private List<Reserva> reservas;
    private LayoutInflater inflater;
    private Context context;

    public DiaMostrado(Date date, List<Reserva> reservas , Context context) {
        this.date = date;
        this.inflater= LayoutInflater.from(context);
        this.context= context;
        this.reservas = reservas;
    }

    @Override
    public int getItemCount(){
        return reservas.size();
    }

    @Override
    public DiaMostrado.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = inflater.inflate(R.layout.list_elements, null);
        return new DiaMostrado.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final DiaMostrado.ViewHolder holder, final int position){
        holder.bindData(reservas.get(position));
    }


    public Date getDate(){
        return date;
    }

    public List getReservas(){
        return reservas;
    }

    public void addReserva(Reserva reserva){
        reservas.add(reserva);
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView cliente, hora;

        ViewHolder(View itemView){
            super(itemView);
            cliente=itemView.findViewById(R.id.nombreClienteReserva);
            hora=itemView.findViewById(R.id.horaReserva);
        }
        void bindData(final Reserva reserva){
            cliente.setText(reserva.getCliente());
            hora.setText(reserva.getTime());
        }
    }
}
