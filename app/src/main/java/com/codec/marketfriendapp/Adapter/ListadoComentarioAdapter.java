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
import com.codec.marketfriendapp.Response.ResponseListaComentario;

import java.util.List;

public class ListadoComentarioAdapter extends RecyclerView.Adapter<ListadoComentarioAdapter.MyViewHolder> {
    private Context context;
    private List<ResponseListaComentario> responseListaComentarios;

    public ListadoComentarioAdapter(Context context, List<ResponseListaComentario> responseListaComentarios) {
        this.context = context;
        this.responseListaComentarios = responseListaComentarios;
    }

    @Override
    public ListadoComentarioAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_listado_comentario, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListadoComentarioAdapter.MyViewHolder holder, final int position) {
        holder.tvComentario.setText(responseListaComentarios.get(position).getComentario());
        holder.tvUsuario.setText(responseListaComentarios.get(position).getUsuario());
        holder.tvFecha.setText(responseListaComentarios.get(position).getFecha());

    }

    @Override
    public int getItemCount() {
        return responseListaComentarios.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvComentario, tvUsuario, tvFecha;


        public MyViewHolder(View itemView) {
            super(itemView);
            tvComentario = (TextView) itemView.findViewById(R.id.tvNombreComercio);
            tvUsuario = (TextView) itemView.findViewById(R.id.tvTelefono);
            tvFecha = (TextView) itemView.findViewById(R.id.tvCategoria);
        }
    }
}
