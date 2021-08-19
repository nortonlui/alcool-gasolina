package com.example.alcoolougasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText editPrecoAlcool, editPrecoGasolina;
    private TextView textResultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editPrecoAlcool = findViewById(R.id.textInputAlcool);
        editPrecoGasolina = findViewById(R.id.textInputGasolina);
        textResultado = findViewById(R.id.textResultado);
    }

    public void calcularPreco(View view){
        String precoAlcool = editPrecoAlcool.getText().toString();
        String precoGasolina = editPrecoGasolina.getText().toString();
        Boolean camposValidados = validarCampos(precoAlcool, precoGasolina);
        if(camposValidados) {
            Double valorAlcool = Double.parseDouble(precoAlcool);
            Double valorGasolina = Double.parseDouble(precoGasolina);
            Double resvalor = valorAlcool / valorGasolina;
            if(resvalor >= 0.7){
                textResultado.setText("Melhor utilizar gasolina");
            }else {
                textResultado.setText("Melhor utilizar alcool");
            }
        }else {
            textResultado.setText("Preencha os preços primeiro");
        }
    }

    public Boolean validarCampos(String pAlcool, String pGasolina) {
        Boolean camposValidados = true;
        if(pAlcool == null ||  pGasolina.equals("")) {
            camposValidados = false;
        }else if (pGasolina == null || pGasolina.equals("")){
            camposValidados = false;
        }
        return camposValidados;
    }
}
