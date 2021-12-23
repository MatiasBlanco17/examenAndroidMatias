package com.example.examenandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import objetos.enfermedad;
import objetos.tipos;

public class INGRESOS_ACT extends AppCompatActivity {
    private TextView resultado;
    private Spinner tipo, enfermedades;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingresos);

        resultado =

        findViewById(R.id.result);

     tipo =

        findViewById(R.id.spTipo);

     enfermedades =

        findViewById(R.id.spEnfer);

        tipos tip = new tipos();
        enfermedad enfer = new enfermedad();
     String[] ListarClientes = tip.getTipos();
     String[] ListarProductos = enfer.getEnfermedad();


        ArrayAdapter adaptClientes = new ArrayAdapter(this, android.R.layout.simple_list_item_1, ListarClientes);
        ArrayAdapter adaptProductos = new ArrayAdapter(this, android.R.layout.simple_list_item_1, ListarProductos);


    tipo.setAdapter(adaptClientes);
    enfermedades.setAdapter(adaptProductos);

}
    public void Calcular (View v) {

        tipos tip = new tipos();
        enfermedad enfer = new enfermedad();

        String opcion = enfermedades.getSelectedItem().toString();


        int result = 0;


        switch (tipo.getSelectedItemPosition()) {
            case 0:
                if (tipo.getSelectedItem().toString().equals("animales domesticos")) {
                    for (int i = 0; i < opcion.length(); i++) {
                        if (opcion.equals(enfer.getEnfermedad()[i])) {


                            result = enfer.Final(enfer.getPrecios()[i], 25000);
                            resultado.setText("" + result);


                            break;
                        }


                    }
                }
                break;
            case 1:
                if (tipo.getSelectedItem().toString().equals("animales salvajes")) {
                    for (int i = 0; i < opcion.length(); i++) {
                        if (opcion.equals(enfer.getEnfermedad()[i])) {


                            result = enfer.Final(enfer.getPrecios()[i], 45000);
                            resultado.setText("" + result);


                            break;
                        }


                    }
                }
                break;
            case 2:
                if (tipo.getSelectedItem().toString().equals("otros")) {
                    for (int i = 0; i < opcion.length(); i++) {
                        if (opcion.equals(enfer.getEnfermedad()[i])) {


                            result = enfer.Final(enfer.getPrecios()[i], 18000);
                            resultado.setText("" + result);


                            break;
                        }


                    }
                }
                break;
        }
        }

    }

}