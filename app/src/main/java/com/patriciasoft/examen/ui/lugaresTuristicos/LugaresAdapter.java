package com.patriciasoft.examen.ui.lugaresTuristicos;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;
import java.io.Serializable;

import com.patriciasoft.examen.R;

import java.util.List;

public class LugaresAdapter extends RecyclerView.Adapter<LugaresAdapter.ViewHolder> {
private List<Lugares> lugares;

private Context context;

private LayoutInflater li;

    public LugaresAdapter(List<Lugares> lugares, Context context, LayoutInflater li) {
        this.lugares = lugares;
        this.context = context;
        this.li = li;
    }

    public void setLugares(List<Lugares> lugares) {
        this.lugares = lugares;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = li.inflate(R.layout.item_lugares,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.nombre.setText(lugares.get(position).getNombre());
        holder.descripcion.setText(lugares.get(position).getDescripcion());

    }

    @Override
    public int getItemCount() {
        return lugares.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView nombre, descripcion;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.tvNombre);
            descripcion = itemView.findViewById(R.id.tvDescripcion);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("lugares",(Serializable)lugares);

                    Navigation.findNavController(view).navigate(R.id.nav_detalleLugares, bundle);


                }
            });

        }
    }
}
