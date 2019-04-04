package com.example.ejerciciolistas;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView mList;

    Sitios sitiosList;

    ArrayAdapter<Sitio> mAdapter;
    Button button;


    Button toJsonBtn, fromJsonBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SharedPreferences prefs =
                getSharedPreferences("MyPreferences", Context.MODE_PRIVATE);

        //Esto comprueba si hay datos en el SharedPreferences para cargalos y si no lo hay lo carga vaccio.
        String name = prefs.getString("names","Name");


        sitiosList = new Sitios();
        mList = findViewById(R.id.lista);


        if (!name.equals("Name")){
            sitiosList  = new Sitios(sitiosList.fromJSON(name).getSitiosList());
        }

        mAdapter = new SitiosAdapter(this,sitiosList.getSitiosList());
        mList.setAdapter(mAdapter);




        button = findViewById(R.id.siguiente);

        toJsonBtn = findViewById(R.id.tojson);

        toJsonBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String innerJson = sitiosList.toJSON();
                Log.i("gsonSitios",innerJson);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putString("names",innerJson);
                editor.apply();

            }
        });

       /* fromJsonBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = prefs.getString("names","Name");

                Sitios sitios = new Sitios();

                if (!name.equals("Name")){
                   sitios  = new Sitios(sitios.fromJSON(name).getSitiosList());
                }

                mAdapter = new SitiosAdapter(getApplicationContext(),sitios.getSitiosList());
                mList.setAdapter(mAdapter);

            }
        });*/

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Save.class );
                startActivityForResult(intent, 2);
            }

        });



    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 2) {
            String sitio = data.getStringExtra("sitio");
            Toast.makeText(this, sitio, Toast.LENGTH_SHORT).show();
            sitiosList.addSitio(new Sitio(sitio));
            mAdapter.notifyDataSetChanged();
        }
    }
}
