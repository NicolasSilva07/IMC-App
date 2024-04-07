package com.example.imcatividade;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private TextView textResultado;
    private TextView editPeso, editAltura;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        textResultado = findViewById(R.id.textResultado);
        editPeso = findViewById(R.id.editPeso);
        editAltura = findViewById(R.id.editAltura);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void calcular(View view) {

        double peso = Double.parseDouble(editPeso.getText().toString());
        double altura = Double.parseDouble(editAltura.getText().toString());
        double resultado = peso / (altura * altura);


        String resultadoFormatado = String.format("%.2f", resultado);

        String informacoesCalculo = "Peso : " + peso + " kg\nAltura : " + altura + " m\n";

        if (resultado < 19) {
            textResultado.setText(informacoesCalculo + "RESULTADO : Abaixo do peso " + resultadoFormatado);
        } else if (resultado <= 19 || resultado < 25) {
            textResultado.setText(informacoesCalculo + "RESULTADO : Peso normal " + resultadoFormatado);

        } else if (resultado <= 25 || resultado < 30) {
            textResultado.setText(informacoesCalculo + "RESULTADO : Sobrepeso " + resultadoFormatado);

        } else if (resultado <= 30 || resultado < 40) {
            textResultado.setText(informacoesCalculo + "RESULTADO : Obesidade tipo I " + resultadoFormatado);

        } else if (resultado >= 40) {
            textResultado.setText(informacoesCalculo + "RESULTADO : Obesidade tipo 2 " + resultadoFormatado);
        }
    }
    public void reiniciarApp(View view) {
    recreate();
}
}