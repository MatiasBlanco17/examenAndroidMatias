package com.example.examenandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import basededatos.AdminSQLiteOpenHelper;

public class GESTION_ANIMALES_ACT extends AppCompatActivity {
    private EditText nFicha,nom,ingreTip,ingreEdad,ingreEnf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestion_animales);

        nFicha = findViewById(R.id.ficha);
        nom = findViewById(R.id.nombre);
        ingreTip = findViewById(R.id.ingresoTipo);
        ingreEdad = findViewById(R.id.ingresoEdad);
        ingreEnf = findViewById(R.id.ingresoEnfer);




    }



    public void AnadirFicha(View view)
    {
//obtener date base
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"VeticalCare", null,1 );
        SQLiteDatabase db = admin.getWritableDatabase();//sobreescritura de base de datos



        String numero = nFicha.getText().toString();
        String nombre =nom.getText().toString();
        String tipo =ingreTip.getText().toString();
        String edad =ingreEdad.getText().toString();
        String enfermedad =ingreEnf.getText().toString();

        if(!numero.isEmpty() && !nombre.isEmpty())
        {



            ContentValues cont = new ContentValues();
            cont.put("Ficha",numero);
            cont.put("boster", nombre);
            cont.put("tipo", tipo);
            cont.put("edad", edad);
            cont.put("enfermedad", enfermedad);


            db.insert("Gestion",null, cont);
            db.close();
            Clean();
            Toast.makeText(getBaseContext(), "Has agregado nueva informacion", Toast.LENGTH_SHORT).show();



        } else {
            Toast.makeText(getBaseContext(), "campos vacios, porfavor rellenar", Toast.LENGTH_SHORT).show();
        }



    }
    public void mostrar (View view)
    {

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"VeticalCare", null,1 );
        SQLiteDatabase db = admin.getWritableDatabase();//sobreescritura de base de datos



        String ficha = nFicha.getText().toString();



        if (!ficha.isEmpty())
        {
            Cursor file = db.rawQuery( "SELECT nom FROM Gestion WHERE Ficha="+ficha, null);



            if (file.moveToFirst()){



//mostrar campos
                nom.setText(file.getString(0));
                ingreTip.setText(file.getString(1));
                ingreEdad.setText(file.getString(2));
                ingreEnf.setText(file.getString(3));




            } else{
                Toast.makeText(getBaseContext(), "No hay nada asociado al codigo", Toast.LENGTH_SHORT).show();
            }



        }else {
            Toast.makeText(getBaseContext(), "El codigo esta vacio", Toast.LENGTH_SHORT).show();
        }



    }
    public void EliminarFicha(View view)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"VeticalCare", null,1 );
        SQLiteDatabase db = admin.getWritableDatabase();//sobreescritura de base de datos



        String ficha = nFicha.getText().toString();



        if (!ficha.isEmpty())
        {
            db.delete("Gestion", "Ficha="+ficha, null);
            db.close();
            Clean();
            Toast.makeText(getBaseContext(), "Has eliminado la ficha", Toast.LENGTH_SHORT).show();



        }else {
            Toast.makeText(getBaseContext(), "El codigo NO PUEDE venir vacio", Toast.LENGTH_SHORT).show();
        }



    }
    public void Clean()
    {
         nFicha.setText("");
         nom.setText("");
         ingreTip.setText("");
         ingreEdad.setText("");
         ingreEnf.setText("");
    }
}

