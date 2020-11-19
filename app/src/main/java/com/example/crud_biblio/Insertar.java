package com.example.crud_biblio;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class Insertar extends AppCompatActivity {
//iniciamos proyecto
    EditText txttitulo, txtautor,txtcategoria,txtpaginas,txteditorial,txtreferencia;
    Button btn_reg, btn_back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txttitulo = findViewById(R.id.titulo_book);
        txtautor = findViewById(R.id.autor_book);
        txtcategoria = findViewById(R.id.categoria_book);
        txtpaginas = findViewById(R.id.paginas_book);
        txteditorial = findViewById(R.id.editorial_book);
        txtreferencia = findViewById(R.id.referencia_book);

        btn_reg = findViewById(R.id.btn_registrar);
        btn_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertar();
            }
        });

        btn_back=findViewById(R.id.btn_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Home.class));
            }
        });{

        }
    }

    private void insertar() {
        String titulo=txttitulo.getText().toString().trim();
        String autor=txtautor.getText().toString().trim();
        String categoria=txtcategoria.getText().toString().trim();
        String nro_paginas=txtpaginas.getText().toString().trim();
        String editorial=txteditorial.getText().toString().trim();
        String referencia=txtreferencia.getText().toString().trim();

        ProgressDialog progressDialog= new ProgressDialog(this);
        if(titulo.isEmpty()){
            txttitulo.setError("Falta el título");
        } else if (autor.isEmpty()) {
            txtautor.setError("Falta el autor");
        } else if (categoria.isEmpty()) {
            txtcategoria.setError("Falta la categoría");
        } else if (nro_paginas.isEmpty()) {
            txtpaginas.setError("Falta número de páginas");
        } else if (editorial.isEmpty()) {
            txteditorial.setError("Falta la editorial");
        } else if (referencia.isEmpty()) {
            txtreferencia.setError("Falta la referencia");
        } else {
            progressDialog.show();
            StringRequest request = new StringRequest(Request.Method.POST, "http://192.168.100.60/crud/insertar.php", new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    if (response.equalsIgnoreCase("Datos ingresados correctamente")) {
                        Toast.makeText(Insertar.this, "Datos ingresados", Toast.LENGTH_LONG).show();
                        progressDialog.dismiss();
                    } else {
                        Toast.makeText(Insertar.this, response, Toast.LENGTH_SHORT).show();
                        progressDialog.dismiss();

                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(Insertar.this,error.getMessage(),Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss();
                }
            }){
                @Override
                protected Map<String, String> getParams() throws AuthFailureError{
                    Map<String, String>params= new HashMap<String, String>();
                    params.put("titulo",titulo);
                    params.put("autor",autor);
                    params.put("categoria",categoria);
                    params.put("nro_paginas",nro_paginas);
                    params.put("editorial",editorial);
                    params.put("referencia",referencia);
                    return params;
                }
            };
            RequestQueue requestQueue= Volley.newRequestQueue( Insertar.this);
            requestQueue.add(request);
        }
    }
}