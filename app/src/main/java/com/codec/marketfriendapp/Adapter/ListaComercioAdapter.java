package com.codec.marketfriendapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.codec.marketfriendapp.R;
import com.codec.marketfriendapp.Response.ListaComercio;

import java.util.List;

public class ListaComercioAdapter extends RecyclerView.Adapter<ListaComercioAdapter.MyViewHolder> {
    private Context context;
    private List<ListaComercio> listaComercio;

    public ListaComercioAdapter(Context context, List<ListaComercio> listaComercio) {
        this.context = context;
        this.listaComercio = listaComercio;
    }

    @Override
    public ListaComercioAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_listado_comercio, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListaComercioAdapter.MyViewHolder holder, final int position) {
        holder.textViewNombre.setText(listaComercio.get(position).getNombre());
        holder.tvTelefono.setText(listaComercio.get(position).getTelefono());
        holder.tvCategoria.setText(listaComercio.get(position).getCategoria());
        holder.rbCalificacion.setProgress(Integer.valueOf(listaComercio.get(position).getCalidadProducto()));
        holder.tvIdComercio.setText(listaComercio.get(position).getCodigo());

    }

    @Override
    public int getItemCount() {
        return listaComercio.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textViewNombre, tvTelefono, tvCategoria, tvIdComercio;
        RatingBar rbCalificacion;

        public MyViewHolder(View itemView) {
            super(itemView);
            textViewNombre = (TextView) itemView.findViewById(R.id.tvNombreComercio);
            tvTelefono = (TextView) itemView.findViewById(R.id.tvTelefono);
            tvCategoria = (TextView) itemView.findViewById(R.id.tvCategoria);
            rbCalificacion = (RatingBar) itemView.findViewById(R.id.rbCalificacion);
            tvIdComercio = itemView.findViewById(R.id.tvIdComercio);
        }
    }
}
