package com.example.haromejiaexamen1chds;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class ActivitySumaIngresoN extends AppCompatActivity {
    private EditText edtNumeroSuma, edtNumero2Suma;
    private TextView txtResqSumaNum;
    private Button bttSumaComuNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suma_ingreso_n);

        // Inicializar vistas
        edtNumeroSuma = findViewById(R.id.edtNumeroSuma);
        edtNumero2Suma = findViewById(R.id.edtNumeroSuma2);
        txtResqSumaNum = findViewById(R.id.txtResultadoSumaN);
        bttSumaComuNum = findViewById(R.id.bttSumaNumer);

        // Configurar el botón para enviar la solicitud
        bttSumaComuNum.setOnClickListener(v -> realizarSuma());
    }

    private void realizarSuma() {
        String input1 = edtNumeroSuma.getText().toString().trim(); // Obtener el número ingresado
        String input2 = edtNumero2Suma.getText().toString().trim(); // Obtener el número ingresado

        // Validar que ambos inputs no estén vacíos y sean números
        if (input1.isEmpty() || input2.isEmpty()) {
            Toast.makeText(this, "Por favor, ingresa ambos números", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            int a = Integer.parseInt(input1); // Convertir el primer número ingresado
            int b = Integer.parseInt(input2); // Convertir el segundo número ingresado

            // Agregar logs para ver los valores de a y b
            Log.d("SumaIngresoN", "Parámetro a: " + a);
            Log.d("SumaIngresoN", "Parámetro b: " + b);

            // Crear el objeto JSON con los parámetros a y b
            JSONObject par = new JSONObject();
            par.put("a", a) ;
            par.put("b", b);

            // URL de la API
            String url = "https://nnbxpu6bkf.execute-api.us-east-2.amazonaws.com/Movil/"; // URL de la API

            // Crear la solicitud POST
            JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, url, par,
                    response -> {
                        // Manejar la respuesta
                        try {
                            String resultado = response.getString("body").trim(); // Obtener el cuerpo de la respuesta

                            // Verificar si la respuesta es válida
                            if (resultado.contains("La Suma es: ")) {
                                resultado = resultado.replace("La Suma es: ", "").trim();

                                // Si el resultado es NaN, mostrar un mensaje de error
                                if (resultado.equals("NaN")) {
                                    txtResqSumaNum.setText("Error: La suma no es válida.");
                                } else {
                                    txtResqSumaNum.setText("Resultado: " + resultado);
                                }
                            } else {
                                txtResqSumaNum.setText("Respuesta inesperada: " + resultado);
                            }
                        } catch (Exception e) {
                            txtResqSumaNum.setText("Error al procesar la respuesta: " + e.getMessage());
                        }
                    },
                    error -> txtResqSumaNum.setText("Error en la solicitud: " + error.getMessage())
            );

            // Agregar la solicitud a la cola
            Volley.newRequestQueue(this).add(request);

        } catch (NumberFormatException | JSONException e) {
            // Mostrar un mensaje si ocurre un error en la conversión de números
            Toast.makeText(this, "Por favor, ingresa valores numéricos válidos", Toast.LENGTH_SHORT).show();
        }
    }
}
