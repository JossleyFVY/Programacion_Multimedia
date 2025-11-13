package com.example.tareatema5;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.*;


import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private EditText textoCorreo;
    private EditText textoContraseña;
    private Button bContinuar;
    private Switch Switch1;
    private TextView textoModificable;

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
        textoCorreo = findViewById(R.id.cajaTextoCorreo);
        textoContraseña = findViewById(R.id.cajaTextoContraseña);
        bContinuar = findViewById(R.id.bContinuar);
        Switch1 = findViewById(R.id.switch1);
        textoModificable = findViewById(R.id.textoModificar);

        bContinuar.setOnClickListener( v -> {
            /* CODIGO PARA QUE MUESTRE EL MENSAJE PERO AHORA AL CAMBIAR DE PANTALLA NO VA TENER UN  USO REAL
            String correo = textoCorreo.getText().toString();
            String contraseña = textoContraseña.getText().toString();
            if(correo.equals("correo@correo.com") && contraseña.equals("123")){
                textoModificable.setTextColor(Color.GREEN);
                textoModificable.setText("Bienvenido,Usuario y Contraseña correctos");
            }
            else {
                textoModificable.setTextColor(Color.RED);
                textoModificable.setText("Usuarios y contraseñas incorrectos");
            }*/

            Intent intent = new Intent(this, SegundaPantalla.class);
            intent.putExtra("correo",textoCorreo.getText().toString());
            textoCorreo.setText("");
            textoContraseña.setText("");
            startActivity(intent);

        });

    }
}