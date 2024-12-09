package com.example.haromejiaexamen1chds;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {
    private TextView txtResq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtResq = findViewById(R.id.txtResq);
        Button sendRequestButton = findViewById(R.id.bttComunicacion);

        sendRequestButton.setOnClickListener(v -> enviarSolicitud());
    }

    private void enviarSolicitud() {
        String url = "http://10.10.13.47:3001/haromejia";

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                response -> {
                    txtResq.setText(response);
                },
                error -> {
                    txtResq.setText("Error en la solicitud: " + error.getMessage());
                });
        Volley.newRequestQueue(this).add(stringRequest);
    }
}
