package com.example.appdodesconto;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText produto;
    EditText preco;
    EditText desconto;
    Button btnCalcular;
    TextView resultado;
    Activity activity = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        produto = findViewById(R.id.text_input_produto);
        preco = findViewById(R.id.text_input_preco);
        desconto = findViewById(R.id.text_input_desconto);
        btnCalcular = findViewById(R.id.button);
        //resultado = findViewById(R.id.resultado);

        btnCalcular.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String precoStr = preco.getText().toString();
                String descontoStr = desconto.getText().toString();
                float precoFlt = Float.parseFloat(precoStr);
                float descontoFlt = Float.parseFloat(descontoStr);


                if(precoStr.isEmpty() || descontoStr.isEmpty()){
                    Toast.makeText(activity, "Preecha todos os campos!", Toast.LENGTH_LONG).show();
                } else {
                    //resultado.setText(String.valueOf(calcular(precoFlt, descontoFlt)));
                    String result = String.valueOf(calcular(precoFlt, descontoFlt));
                    Toast.makeText(activity, "Valor total R$: "+result, Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    public float calcular(float preco, float desconto){
        return (preco * desconto) / 100 - preco;
    }
}
