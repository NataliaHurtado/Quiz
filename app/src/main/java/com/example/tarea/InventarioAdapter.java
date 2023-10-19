package com.example.tarea;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class InventarioAdapter extends RecyclerView.Adapter<InventarioAdapter.ViewHolder>{

    private List<Inventario> inventarioList;
    private OnItemClickListener clickListener;

    public InventarioAdapter(List<Inventario> inventarioList, OnItemClickListener clickListener) {
        this.inventarioList = inventarioList;
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_inventario, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Inventario inventario = inventarioList.get(position);
        holder.inventarioName.setText(inventario.getName());

        holder.itemView.setOnClickListener(view -> clickListener.onItemClick(inventario));
    }

    @Override
    public int getItemCount() {
        return inventarioList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView inventarioName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            inventarioName = itemView.findViewById(R.id.inventarioName);
        }
    }

    public interface OnItemClickListener {
        void onItemClick(Inventario inventario);
    }
}
