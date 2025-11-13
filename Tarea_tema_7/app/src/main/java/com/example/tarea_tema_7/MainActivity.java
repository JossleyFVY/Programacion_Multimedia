package com.example.tarea_tema_7;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    private TextView mostrarTiempo;
    private TextView tiempoTotal;
    private Button btnPlay;
    private Button btnPausa;
    private SeekBar reproduccionBarra;

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
        mostrarTiempo = findViewById(R.id.mostrarTiempo);
        tiempoTotal = findViewById(R.id.tiempoTotal);
        btnPlay = findViewById(R.id.btnPlay);
        btnPausa = findViewById(R.id.btnPausa);
        reproduccionBarra = findViewById(R.id.reproduccionBarra);

    }
}