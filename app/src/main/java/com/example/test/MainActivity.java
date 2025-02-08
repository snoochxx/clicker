package com.example.test;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private Integer Primogems = 0;
    private Integer Wishes = 0;


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
    }
    public void onClickButton(View view) {
        Primogems++;
        TextView txt = findViewById(R.id.Primogems);
        txt.setText("Gems: " + Primogems.toString());
    }
    public void onClickButton2(View view) {
        if (Primogems >= 160) {
            Wishes++;
            Primogems -= 160;
            TextView txt = findViewById(R.id.Wishes);
            txt.setText("Wishes: " + Wishes.toString());
        }
    }

}