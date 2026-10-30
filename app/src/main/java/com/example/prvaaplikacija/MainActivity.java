package com.example.prvaaplikacija;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);

        button.setOnClickListener(v -> {
            Toast.makeText(
                    MainActivity.this,
                    "My first Android Studio application!",
                    Toast.LENGTH_SHORT
            ).show();
        });

        Snackbar snackbar = Snackbar.make(
                findViewById(R.id.main),
                "Just another option for button",
                Snackbar.LENGTH_LONG
        );

        // Background color and corner radius
        View snackbarView = snackbar.getView();
        android.graphics.drawable.GradientDrawable shape = new android.graphics.drawable.GradientDrawable();
        shape.setShape(android.graphics.drawable.GradientDrawable.RECTANGLE);
        shape.setCornerRadius(30f);
        shape.setColor(Color.parseColor("#eeedf2"));
        snackbarView.setBackground(shape);

        // Text color
        snackbar.setTextColor(Color.BLACK);

        findViewById(R.id.floatingActionButton).setOnClickListener(v -> {
            snackbar.show();
        });



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}