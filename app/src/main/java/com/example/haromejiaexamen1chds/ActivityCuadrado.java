package com.example.haromejiaexamen1chds;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.android.volley.Request;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class ActivityCuadrado extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuadrado);

        // Vincular vistas
        EditText edtNumero1 = findViewById(R.id.edtNumero1Cuadrado);
        EditText edtNumero2 = findViewById(R.id.edtNumero2Cuadrado);
        Button btnCalcularCuadrado = findViewById(R.id.bttCalcularCuadrado);
        TextView txtResultadCuadrado = findViewById(R.id.txtResultadCuadrado);

        // Aplicar insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Lógica al hacer clic en el botón
        btnCalcularCuadrado.setOnClickListener(v -> CuadrodoP(edtNumero1, edtNumero2, txtResultadCuadrado));
    }

    private void CuadrodoP(EditText edtNumero1, EditText edtNumero2, TextView txtResultadCuadrado) {
        String input = edtNumero1.getText().toString();  // Obtener el número ingresado
        String input1 = edtNumero2.getText().toString();

        // Verificar que ambos inputs no estén vacíos y sean números válidos
        if (!input.isEmpty() && !input1.isEmpty()) {
            try {
                int num1 = Integer.parseInt(input);  // Convertir el número ingresado
                int num2 = Integer.parseInt(input1);

                // Crear la URL con el número ingresado
                String url = "http://10.10.13.47:3001/cuadradoperfecto/" + num1 + "/" + num2;

                // Realizar la solicitud HTTP
                Volley.newRequestQueue(this).add(new StringRequest(Request.Method.GET, url,
                        response -> txtResultadCuadrado.setText("Resultado: " + response),  // Mostrar la respuesta
                        error -> txtResultadCuadrado.setText("Error en la solicitud: " + obtenerMensajeError(error)) // Manejo de errores
                ));
            } catch (NumberFormatException e) {
                // Si la conversión falla, mostrar un mensaje de error
                Toast.makeText(this, "Por favor, ingresa números válidos", Toast.LENGTH_SHORT).show();
            }
        } else {
            // Si algún campo está vacío, mostrar un mensaje de error
            Toast.makeText(this, "Por favor, ingresa ambos números", Toast.LENGTH_SHORT).show();
        }
    }

    private String obtenerMensajeError(Exception error) {
        if (error.getMessage() != null) {
            return error.getMessage();
        }
        return "Error desconocido";
    }
}
