package com.example.haromejiaexamen1chds;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.android.volley.Request;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class ActivityTrapecio extends AppCompatActivity {

    private EditText edtBaseMayorTrapecio, edtBaseMenorTrapecio, edtAlturaTrapecio, edtLado1Trapecio, edtLado2Trapecio;
    private Button bttCalcularTrapecio;
    private TextView txtResultadoTrapecio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_trapecio);

        // Iniciar vistas
        edtBaseMayorTrapecio = findViewById(R.id.edtBaseMayorTrapecio);
        edtBaseMenorTrapecio = findViewById(R.id.edtBaseMenorTrapecio);
        edtAlturaTrapecio = findViewById(R.id.edtAlturaTrapecio);
        edtLado1Trapecio = findViewById(R.id.edtLado1Trapecio);
        edtLado2Trapecio = findViewById(R.id.edtLado2Trapecio);
        bttCalcularTrapecio = findViewById(R.id.bttCalcularTrapecio);
        txtResultadoTrapecio = findViewById(R.id.txtResultadoTrapecio);
        bttCalcularTrapecio.setOnClickListener(v -> enviarSolicitud());
    }

    private void enviarSolicitud() {

        String baseMayor = edtBaseMayorTrapecio.getText().toString();
        String baseMenor = edtBaseMenorTrapecio.getText().toString();
        String altura = edtAlturaTrapecio.getText().toString();
        String lado1 = edtLado1Trapecio.getText().toString();
        String lado2 = edtLado2Trapecio.getText().toString();

        // Verificar si todos los campos están llenos
        if (baseMayor.isEmpty() || baseMenor.isEmpty() || altura.isEmpty() || lado1.isEmpty() || lado2.isEmpty()) {
            txtResultadoTrapecio.setText("Por favor ingrese todos los valores.");
            return;
        }

        String url = "http://192.168.1.7:3001/trapecio/" + baseMayor + "/" + baseMenor + "/" + altura + "/" + lado1 + "/" + lado2;

        // Crear y agregar la solicitud a la cola de Volley
        Volley.newRequestQueue(this).add(new StringRequest(Request.Method.GET, url,
                response -> txtResultadoTrapecio.setText("Resultado: " + response),  // Mostrar la respuesta directamente
                error -> txtResultadoTrapecio.setText("Error en la solicitud: " + error.getMessage())
        ));
    }
}
