package com.example.haromejiaexamen1chds;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;

public class ActivityNombre extends AppCompatActivity {

    private TextView txtResq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nombre);

        txtResq = findViewById(R.id.txtResqLista);
        findViewById(R.id.bttComunicacionLista).setOnClickListener(v -> enviarSolicitud());
    }

    private void enviarSolicitud() {
        String url = "http://192.168.1.7:3001/nombres";
        Volley.newRequestQueue(this).add(new StringRequest(Request.Method.GET, url,
                response -> {
                    StringBuilder nombres = new StringBuilder();
                    try {
                        JSONArray jsonArray = new JSONArray(response);
                        for (int i = 0; i < jsonArray.length(); i++) {
                            nombres.append(jsonArray.getJSONObject(i).optString("nombre", "Nombre no disponible"))
                                    .append("\n");
                        }
                    } catch (Exception e) {
                        nombres = new StringBuilder("Error al procesar la respuesta: " + e.getMessage());
                    }
                    txtResq.setText(nombres.toString());
                },
                error -> txtResq.setText("Error en la solicitud: " + (error.getMessage() != null ? error.getMessage() : "Error desconocido"))
        ));
    }
}
