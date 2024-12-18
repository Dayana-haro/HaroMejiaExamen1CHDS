package com.example.haromejiaexamen1chds;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class ActivityPentagono extends AppCompatActivity {

    private EditText edtLadoPentagono, edtApotemaPentagono;
    private Button bttCalcularPentagono;
    private TextView txtResultadoPentagono;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_pentagono);

        // Inicializar vistas
        edtLadoPentagono = findViewById(R.id.edtLadoPentagono);
        edtApotemaPentagono = findViewById(R.id.edtApotemaPentagono);
        bttCalcularPentagono = findViewById(R.id.bttCalcularPentagono);
        txtResultadoPentagono = findViewById(R.id.txtResultadoPentagono);

        // Configurar el listener del botón para enviar la solicitud
        bttCalcularPentagono.setOnClickListener(v -> enviarSolicitud());
    }

    private void enviarSolicitud() {
        // Obtener los valores de los campos de entrada
        String lado = edtLadoPentagono.getText().toString();
        String apotema = edtApotemaPentagono.getText().toString();

        // Verificar si los campos están llenos
        if (lado.isEmpty() || apotema.isEmpty()) {
            txtResultadoPentagono.setText("Por favor ingrese todos los valores.");
            return;
        }

        // Construir la URL con los parámetros
        String url = "http://192.168.1.7:3001/pentagono/" + lado + "/" + apotema;

        // Crear la solicitud Volley para obtener los resultados
        Volley.newRequestQueue(this).add(new StringRequest(Request.Method.GET, url,
                response -> txtResultadoPentagono.setText("Resultado: " + response),  // Mostrar la respuesta
                error -> txtResultadoPentagono.setText("Error en la solicitud: " + error.getMessage())  // Manejo de errores
        ));
    }
}
