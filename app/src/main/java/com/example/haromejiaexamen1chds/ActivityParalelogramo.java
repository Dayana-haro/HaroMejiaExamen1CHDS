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

public class ActivityParalelogramo extends AppCompatActivity {

    private EditText edtBaseParalelogramo, edtAlturaParalelogramo, edtLadoParalelogramo;
    private Button bttCalcularParalelogramo;
    private TextView txtResultadoParalelogramo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paralelogramo);

        // Iniciar vistas
        edtBaseParalelogramo = findViewById(R.id.edtBaseParalelogramo);
        edtAlturaParalelogramo = findViewById(R.id.edtAlturaParalelogramo);
        edtLadoParalelogramo = findViewById(R.id.edtLadoParalelogramo);
        bttCalcularParalelogramo = findViewById(R.id.bttCalcularParalelogramo);
        txtResultadoParalelogramo = findViewById(R.id.txtResultadoParalelogramo);

        bttCalcularParalelogramo.setOnClickListener(v -> enviarSolicitud());
    }

    private void enviarSolicitud() {

        String base = edtBaseParalelogramo.getText().toString();
        String altura = edtAlturaParalelogramo.getText().toString();
        String lado = edtLadoParalelogramo.getText().toString();

        // Verificar si todos los campos están llenos
        if (base.isEmpty() || altura.isEmpty() || lado.isEmpty()) {
            txtResultadoParalelogramo.setText("Por favor ingrese todos los valores.");
            return;
        }

        String url = "http://192.168.1.7:3001/paralelogramo/" + base + "/" + altura + "/" + lado;

        // Crear y agregar la solicitud a la cola de Volley
        Volley.newRequestQueue(this).add(new StringRequest(Request.Method.GET, url,
                response -> txtResultadoParalelogramo.setText("Resultado: " + response),  // Mostrar la respuesta directamente
                error -> txtResultadoParalelogramo.setText("Error en la solicitud: " + error.getMessage())
        ));
    }
}
