package com.example.haromejiaexamen1chds;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.android.volley.Request;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class ActivitySumaIngresoN extends AppCompatActivity {
    private EditText edtNumeroSuma;
    private TextView txtResqSumaNum;
    private Button bttSumaComuNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_suma_ingreso_n);

        // Inicializar vistas
        edtNumeroSuma = findViewById(R.id.edtNumeroSuma);
        txtResqSumaNum = findViewById(R.id.txtResultadoSumaN);
        bttSumaComuNum = findViewById(R.id.bttSumaNumer);

        // Configurar el botón para enviar la solicitud
        bttSumaComuNum.setOnClickListener(v -> realizarSuma());
    }

    private void realizarSuma() {
        String input = edtNumeroSuma.getText().toString();  // Obtener el número ingresado

        // Verificar que el input no esté vacío y sea un número válido
        if (!input.isEmpty()) {
            int num1 = Integer.parseInt(input);  // Convertir el número ingresado

            // Crear la URL con el número ingresado
            String url = "http://192.168.1.7:3001/sumas/" + num1;

            // Realizar la solicitud HTTP
            Volley.newRequestQueue(this).add(new StringRequest(Request.Method.GET, url,
                    response -> txtResqSumaNum.setText("Resultado: " + response),  // Mostrar la respuesta
                    error -> txtResqSumaNum.setText("Error en la solicitud: " + obtenerMensajeError(error)) // Manejo de errores
            ));
        } else {
            // Si el número no es válido, mostrar un mensaje de error
            Toast.makeText(this, "Por favor, ingresa un número válido", Toast.LENGTH_SHORT).show();
        }
    }


    private String obtenerMensajeError(Exception error) {
        if (error.getMessage() != null) {
            return error.getMessage();
        }
        return "Error desconocido";
    }
}
