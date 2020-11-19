package com.example.crud_biblio;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class Adaptador extends ArrayAdapter<Libros> {

    Context context;
    List<Libros>arrayalistaLibros;


    public Adaptador(@NonNull Context context, List<Libros>arrayalistaLibros) {
        super(context,R.layout.my_listitem,arrayalistaLibros);
        this.context=context;
        this.arrayalistaLibros= arrayalistaLibros;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_listitem,null,true);
        TextView txtid = view.findViewById(R.id.id_book);
        TextView txttitulo = view.findViewById(R.id.titu_book);

        txtid.setText(arrayalistaLibros.get(position).getId());
        txttitulo.setText(arrayalistaLibros.get(position).getTitulo());
        return super.getView(position,convertView,parent);
    }
}
