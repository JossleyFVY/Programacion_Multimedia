package com.example.tarea_tema_7;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.os.Handler;
import android.provider.MediaStore;
import android.widget.*;
import android.media.MediaPlayer;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private TextView mostrarTiempo;
    private TextView tiempoTotal;
    private Button btnPlay;
    private Button btnPausa;
    private SeekBar reproduccionBarra;
    private String formatTime(int ms){ // para convertir el tiempo de milisegundos
        int segundos= (ms / 1000) % 60;
        int minutos = (ms/1000) /60;
        return String.format("%02d:%02d", minutos , segundos);
    }
    MediaPlayer mediaPlayer;
    Handler handler = new Handler();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        // Enlazar lo del xml con el código
        mostrarTiempo = findViewById(R.id.mostrarTiempo);
        tiempoTotal = findViewById(R.id.tiempoTotal);
        btnPlay = findViewById(R.id.btnPlay);
        btnPausa = findViewById(R.id.btnPausa);
        reproduccionBarra = findViewById(R.id.reproduccionBarra);
        mediaPlayer = MediaPlayer.create(this,R.raw.golden);


        btnPlay.setOnClickListener(v ->{
            mediaPlayer.start();
        });
        btnPausa.setOnClickListener(v -> {
            mediaPlayer.pause();
        });
        //Prepara el archivo de audio y pondrá el texto a 0 y el tiempo total de la cancion
        mediaPlayer.setOnPreparedListener(mp -> {
            reproduccionBarra.setMax(mediaPlayer.getDuration());
            int duracion = mediaPlayer.getDuration();
            mostrarTiempo.setText("00:00");
            tiempoTotal.setText(formatTime(duracion));

        });
        // El handler que manejara la información y lo actualizara.
        Runnable actualizar = new Runnable() {
            @Override
            public void run() {
            reproduccionBarra.setProgress(mediaPlayer.getCurrentPosition());

            int minutos = mediaPlayer.getCurrentPosition()/1000/60;
            int segundos = mediaPlayer.getCurrentPosition()/1000%60;
            String tiempo = String.format("%02d:%02d", minutos, segundos);
            mostrarTiempo.setText(tiempo);

            handler.postDelayed(this,1000);
            }
        };
        handler.post(actualizar);
    }
}