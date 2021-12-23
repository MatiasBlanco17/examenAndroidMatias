package com.example.examenandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.VideoView;

public class HOME_ACT extends AppCompatActivity {

    private VideoView vw ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        vw = findViewById(R.id.video);



        String ruta = "android.resource://" + getPackageName() + "/" + R.raw.video;



        Uri uri = Uri.parse(ruta);



        vw.setVideoURI(uri);



        vw.start();
//controles



/*MediaController media = new MediaController(this);
vw.setMediaController(media);*/
    }
    public void gestiosDeAnimales(View view)
    {
        Intent i = new Intent(this ,GESTION_ANIMALES_ACT.class);
        startActivity(i);
    }
    public void ingresos(View view)
    {
        Intent i = new Intent(this , INGRESOS_ACT.class);
        startActivity(i);
    }
}

