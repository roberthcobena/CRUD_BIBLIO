package com.example.crud_biblio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Home extends AppCompatActivity {

    private ListView list;
    Adaptador adaptador;
    public static ArrayList<Libros>libros=new ArrayList<>();

    String Url="http://192.168.100.60/crud/mostrar.php";
    Libros books;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        list=findViewById(R.id.listview);
        adaptador = new Adaptador(this,libros);
        list.setAdapter(adaptador);
        mostrardatos();
    }
    public void mostrardatos(){
        StringRequest request = new StringRequest(Request.Method.POST, Url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                libros.clear();
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    String succes=jsonObject.getString("succes");
                    JSONArray jsonArray = jsonObject.getJSONArray("datos");
                    if (succes.equals("1")){
                        for (int i=0;i<jsonArray.length();i++){
                            JSONObject object=jsonArray.getJSONObject(i);
                            String id=object.getString("id");
                            String titulo=object.getString("titulo");
                            String autor=object.getString("autor");
                            String categoria=object.getString("categoria");
                            String paginas=object.getString("nro_paginas");
                            String editorial=object.getString("editorial");
                            String referencia=object.getString("referencias");
                            String estado=object.getString("estado");

                            books=new Libros(id,titulo,autor,categoria,paginas,editorial,referencia,estado);

                            libros.add(books);
                            adaptador.notifyDataSetChanged();
                        }
                    }
                }catch (JSONException e){
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Home.this,error.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);
    }

    public void btnAgr(View view){
        startActivity(new Intent(getApplicationContext(), Insertar.class));
    }
}