package com.example.ejerciciolistas;

import android.app.Activity;
import android.app.AppComponentFactory;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Save extends AppCompatActivity {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inserccion_datos);

        button = findViewById(R.id.anadir);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
/*
                //Esto es lo del Gson para guardar los datos que se inserten y salir sin que se borren.
                SharedPreferences preferences = getSharedPreferences("MyPreferences", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("sitio","NombreCiudad");*/



                EditText sitio = findViewById(R.id.texto);
                String s = sitio.getText().toString();
                Intent intent = new Intent();
                intent.putExtra("sitio", s);
                setResult(2,intent);
                finish();
            }
        });

    }
}
