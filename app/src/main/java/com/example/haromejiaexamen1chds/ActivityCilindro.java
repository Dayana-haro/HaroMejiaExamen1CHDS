package com.example.haromejiaexamen1chds;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class ActivityCilindro extends AppCompatActivity {

    private EditText edtRadioCilindro, edtAlturaCilindro;
    private Button bttCalcularCilindro;
    private TextView txtResultadoCilindro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cilindro);

        // Iniciar vistas
        edtRadioCilindro = findViewById(R.id.edtRadioCilindro);
        edtAlturaCilindro = findViewById(R.id.edtAlturaCilindro);
        bttCalcularCilindro = findViewById(R.id.bttCalcularCilindro);
        txtResultadoCilindro = findViewById(R.id.txtResultadoCilindro);

        bttCalcularCilindro.setOnClickListener(v -> enviarSolicitud());
    }

    private void enviarSolicitud() {

        String radio = edtRadioCilindro.getText().toString();
        String altura = edtAlturaCilindro.getText().toString();

        // Verificar si todos los campos están llenos
        if (radio.isEmpty() || altura.isEmpty()) {
            txtResultadoCilindro.setText("Por favor ingrese todos los valores.");
            return;
        }

        String url = "http://192.168.1.7:3001/cilindro/" + radio + "/" + altura;

        // Crear y agregar la solicitud a la cola de Volley
        Volley.newRequestQueue(this).add(new StringRequest(Request.Method.GET, url,
                response -> txtResultadoCilindro.setText("Resultado: " + response),  // Mostrar la respuesta directamente
                error -> txtResultadoCilindro.setText("Error en la solicitud: " + error.getMessage())
        ));
    }
}
