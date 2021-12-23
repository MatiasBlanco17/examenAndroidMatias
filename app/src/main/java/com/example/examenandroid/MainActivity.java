package com.example.examenandroid;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import objetos.admin;

public class MainActivity extends AppCompatActivity {
    EditText txt_user, txt_pass;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//
        txt_user = (EditText)findViewById(R.id.user);
        txt_pass = (EditText) findViewById(R.id.id_Password);
    }
    public void Inicio (View view)
    {
        if((txt_user.getText().toString().equals("matias")&&
                txt_pass.getText().toString().equals("123")))
        {



            Intent i = new Intent(this, HOME_ACT.class);
            startActivity(i);



        }
        else {
            AlertDialog.Builder myBuild = new AlertDialog.Builder(this);
            myBuild.setMessage("Error de autenticacion");
            myBuild.setTitle("Error");
            AlertDialog dialog = myBuild.create();
            dialog.show();
        }
    }
    public void Salir(View v){
       finish(); }


}

