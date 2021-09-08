package com.example.recyclelist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class AdapterList extends RecyclerView.Adapter<AdapterList.ViewHolderDatos> {
    ArrayList<Item> items;


    public AdapterList(ArrayList<Item> items) {
        this.items = items;
    }

    @NonNull
    @org.jetbrains.annotations.NotNull
    @Override
    public ViewHolderDatos onCreateViewHolder(@NonNull @org.jetbrains.annotations.NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,null,false);
        return new ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @org.jetbrains.annotations.NotNull AdapterList.ViewHolderDatos holder, int position) {
        holder.name.setText(items.get(position).getName());
        holder.last_name.setText(items.get(position).getLast_name());
        holder.avatar.setImageResource(items.get(position).getPhoto());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder {
        TextView name;
        TextView last_name;
        ImageView avatar;
        public ViewHolderDatos(@NonNull @NotNull View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.textView);
            last_name = (TextView) itemView.findViewById(R.id.textView2);
            avatar = (ImageView) itemView.findViewById(R.id.imageView2);
        }
    }
}
