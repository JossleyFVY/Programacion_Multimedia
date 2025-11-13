package com.example.tareatema5;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.*;

public class SegundaPantalla extends AppCompatActivity {
    private TextView textoDelCorreo;
    private Button btnDesconectar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_segunda_pantalla);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Intent intent = getIntent();
        String correo = intent.getStringExtra("correo");
        textoDelCorreo = findViewById(R.id.textoDelCorreo);
        textoDelCorreo.setText(correo);

        btnDesconectar = findViewById(R.id.btnDesconectar);
        btnDesconectar.setOnClickListener(view -> {
            
            finish();

        });
    }
}