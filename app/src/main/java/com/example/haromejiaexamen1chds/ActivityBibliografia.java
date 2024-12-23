package com.example.haromejiaexamen1chds;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class ActivityBibliografia extends AppCompatActivity {


    private TextView txtResq;
    private Button bttBibliografiaComu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bibliografia);

        // Inicializar vistas
        txtResq = findViewById(R.id.txtBibliografiaDescr);
        bttBibliografiaComu = findViewById(R.id.bttBibliografiaComu);

        // Configurar botón para enviar solicitud
        bttBibliografiaComu.setOnClickListener(v -> enviarSolicitud());
    }

    private void enviarSolicitud() {
        String url = "http://10.10.13.47:3001/dayana";

        // Crear y agregar la solicitud a la cola de Volley
        Volley.newRequestQueue(this).add(new StringRequest(Request.Method.GET, url,
                response -> txtResq.setText(response),  // Mostrar la respuesta directamente
                error -> txtResq.setText("Error en la solicitud: " + obtenerMensajeError(error))
        ));
    }
    private String obtenerMensajeError(Exception error) {
        if (error.getMessage() != null) {
            return error.getMessage();
        }
        return "Error desconocido";
    }
}
