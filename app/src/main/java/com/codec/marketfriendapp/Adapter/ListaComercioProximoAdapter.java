package com.codec.marketfriendapp.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.codec.marketfriendapp.Activity.CalificarComercioActivity;
import com.codec.marketfriendapp.Activity.DetalleComercioActivity;
import com.codec.marketfriendapp.Config.ConfiguracionRetrofit;
import com.codec.marketfriendapp.Config.Globales;
import com.codec.marketfriendapp.Config.MarketFriend;
import com.codec.marketfriendapp.R;
import com.codec.marketfriendapp.Models.Response.ResponseListaMarket;

import java.util.List;

public class ListaComercioProximoAdapter extends RecyclerView.Adapter<ListaComercioProximoAdapter.MyViewHolder> {
    private Globales global = new Globales();
    private Context context;
    private List<ResponseListaMarket> listaComercio;

    public ListaComercioProximoAdapter(Context context, List<ResponseListaMarket> listaComercio) {
        this.context = context;
        this.listaComercio = listaComercio;
    }

    @Override
    public ListaComercioProximoAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_listado_comercio, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListaComercioProximoAdapter.MyViewHolder holder, final int position) {
        String comercio = global.wordFirstCap(listaComercio.get(position).getNombre());
        holder.textViewNombre.setText(comercio);
        holder.tvTelefono.setText(listaComercio.get(position).getTelefono());
        holder.tvCategoria.setText(listaComercio.get(position).getCategoria());
        holder.rbCalificacion.setProgress(Integer.valueOf(listaComercio.get(position).getCalidadAtencion()));
        holder.tvIdComercio.setText(listaComercio.get(position).getCodigo().toString());

        if(listaComercio.get(position).getImagen()==null)
        {
            Glide.with(MarketFriend.getContext()).load(ConfiguracionRetrofit.API_MARKETFRIEND_IMAGEN_URL+listaComercio.get(position).getImagen()).into(holder.ivImagenComercio);
        }
        else
        {
            Glide.with(MarketFriend.getContext()).load(ConfiguracionRetrofit.API_MARKETFRIEND_IMAGEN_URL+listaComercio.get(position).getImagen()).into(holder.ivImagenComercio);
        }
        holder.textViewNombre.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v){

                Intent clasificaComercio  = new Intent(context, CalificarComercioActivity.class);
                clasificaComercio.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                clasificaComercio.putExtra("NombreComercio",  listaComercio.get(position).getNombre() );
                clasificaComercio.putExtra("Categoria",  listaComercio.get(position).getCategoria() );
                clasificaComercio.putExtra("Codigo",  listaComercio.get(position).getCodigo().toString() );
                clasificaComercio.putExtra("CalidadProducto",  listaComercio.get(position).getCalidadAtencion() );
                context.startActivity(clasificaComercio);



            }
        });
        holder.ivDetalle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent detalleComercio  = new Intent(context, DetalleComercioActivity.class);
                detalleComercio.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                detalleComercio.putExtra("NombreComercio",  listaComercio.get(position).getNombre() );
                detalleComercio.putExtra("Categoria",  listaComercio.get(position).getCategoria() );
                detalleComercio.putExtra("Codigo",  listaComercio.get(position).getCodigo().toString() );
                detalleComercio.putExtra("Calificacion", listaComercio.get(position).getCalidadAtencion());
                context.startActivity(detalleComercio);
            }
        });

    }

    @Override
    public int getItemCount() {
        return listaComercio.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textViewNombre, tvTelefono, tvCategoria, tvIdComercio;
        RatingBar rbCalificacion;
        ImageView ivDetalle, ivImagenComercio;

        public MyViewHolder(View itemView) {
            super(itemView);
            textViewNombre = (TextView) itemView.findViewById(R.id.tvNombreComercio);
            tvTelefono = (TextView) itemView.findViewById(R.id.tvTelefono);
            tvCategoria = (TextView) itemView.findViewById(R.id.tvCategoria);
            rbCalificacion = (RatingBar) itemView.findViewById(R.id.rbCalificacion);
            tvIdComercio = itemView.findViewById(R.id.tvIdComercio);
            ivDetalle = (ImageView)itemView.findViewById(R.id.ivDetalle);
            ivImagenComercio = (ImageView) itemView.findViewById(R.id.ivComercioFavorito);
        }
    }
}
