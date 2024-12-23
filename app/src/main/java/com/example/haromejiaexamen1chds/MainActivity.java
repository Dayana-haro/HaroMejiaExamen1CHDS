package com.example.haromejiaexamen1chds;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Botón Bibliografía
        Button bttBibliografia = findViewById(R.id.btnBibliografia);
        bttBibliografia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ActivityBibliografia.class);
                startActivity(intent);
            }
        });

        // Botón Lista
        Button bttLista = findViewById(R.id.btnLista);
        bttLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ActivityNombre.class);
                startActivity(intent);
            }
        });

        // Botón Suma
        Button bttSuma = findViewById(R.id.btnSuma);
        bttSuma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ActivitySuma.class);
                startActivity(intent);
            }
        });

        // Botón Suma con ingreso de número
        Button bttSumaNum = findViewById(R.id.btnSumaNum);
        bttSumaNum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ActivitySumaIngresoN.class);
                startActivity(intent);
            }
        });

        // Botón Trapecio
        Button bttTrapecio = findViewById(R.id.btnTrapecio);
        bttTrapecio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ActivityTrapecio.class);
                startActivity(intent);
            }
        });

        // Botón Paralelogramo
        Button bttParalelogramo = findViewById(R.id.btnParalelogramo);
        bttParalelogramo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ActivityParalelogramo.class);
                startActivity(intent);
            }
        });

        // Botón Pentágono
        Button bttPentagono = findViewById(R.id.btnPentagono);
        bttPentagono.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ActivityPentagono.class);
                startActivity(intent);
            }
        });

        // Botón Cilindro
        Button bttCilindro = findViewById(R.id.btnCilindro);
        bttCilindro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ActivityCilindro.class);
                startActivity(intent);
            }
        });
        Button bttCuadrado = findViewById(R.id.btnCuadradoTrinomio);
        bttCuadrado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ActivityCuadrado.class);
                startActivity(intent);
            }
        });
    }
}
