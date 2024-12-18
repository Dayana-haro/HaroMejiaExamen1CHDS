package com.example.haromejiaexamen1chds;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.android.volley.Request;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class ActivitySuma extends AppCompatActivity {
    private TextView txtResqSuma;
    private Button bttSumaComu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_suma);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        txtResqSuma = findViewById(R.id.txtResqSuma);
        bttSumaComu = findViewById(R.id.bttComunicacionSuma);

        // Configurar botón para enviar solicitud
        bttSumaComu.setOnClickListener(v -> enviarSolicitud());
    }

    private void enviarSolicitud() {
        String url = "http://192.168.1.7:3001/suma";

        // Crear y agregar la solicitud a la cola de Volley
        Volley.newRequestQueue(this).add(new StringRequest(Request.Method.GET, url,
                response -> txtResqSuma.setText(response),  // Mostrar la respuesta directamente
                error -> txtResqSuma.setText("Error en la solicitud: " + obtenerMensajeError(error))
        ));
    }
    private String obtenerMensajeError(Exception error) {
        if (error.getMessage() != null) {
            return error.getMessage();
        }
        return "Error desconocido";
    }
}