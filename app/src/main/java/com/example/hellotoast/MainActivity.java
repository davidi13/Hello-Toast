package com.example.hellotoast;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private TextView showCountTextView;
    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Configuración del sistema de márgenes para el layout principal
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Inicializar el TextView
        showCountTextView = findViewById(R.id.show_count);

        // Configurar el botón de TOAST
        Button toastButton = findViewById(R.id.button_toast);
        toastButton.setOnClickListener(v -> {
            Toast.makeText(MainActivity.this, "¡Hola! Este es un mensaje de Toast.", Toast.LENGTH_SHORT).show();
        });

        // Configurar el botón de COUNT
        Button countButton = findViewById(R.id.button_count);
        countButton.setOnClickListener(v -> {
            count++;
            showCountTextView.setText(String.valueOf(count));
        });
    }
}
