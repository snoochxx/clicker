package com.example.test;

import android.annotation.SuppressLint;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private Integer Primogems = 0;
    private Integer Wishes = 0;
    private TextView wishesTextView;


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
    @Override
    protected void onStart() {
        super.onStart();
        Log.d("onStart", "onStart");
        Toast.makeText(this, "onStart!",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("Primogems", Primogems);
        Log.d("save", Primogems.toString());
        Toast.makeText(this, "onStart!", Toast.LENGTH_LONG).show();
    }
    @Override
    protected void onRestoreInstanceState(Bundle SavedState){
        super.onRestoreInstanceState(SavedState);
        Log.d("res", Primogems.toString());
        if(SavedState.containsKey("Primogems")){
            Primogems = SavedState.getInt("Primogems");
        }
        Log.d("onRestoreInstanceState","onRestoreInstanceState");
        Toast.makeText(this, "onRestoreInstanceState",Toast.LENGTH_LONG).show();
    }
    @Override
    protected void onPause() {
        super.onPause();
        Log.d("onPause", "onPause");
        Toast.makeText(this, "onPause!",Toast.LENGTH_LONG).show();
    }
    @Override
    protected void onResume(){
        super.onResume();
        Log.d("onResume", "onResume");
        Toast.makeText(this, "onResume!",Toast.LENGTH_LONG).show();
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d("onDestroy", "onDestroy");
        Toast.makeText(this, "onDestroy!",Toast.LENGTH_LONG).show();
    }
    @Override
    protected void onStop(){
        super.onStop();
        Log.d("onStop", "onStop");
        Toast.makeText(this, "onStop!",Toast.LENGTH_LONG).show();
    }

    @SuppressLint("SetTextI18n")
    public void onClickButton(View view) {
        Primogems++;
        TextView txt = findViewById(R.id.Primogems);
        txt.setText("Gems: " + Primogems.toString());

    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        ImageView imageView = findViewById(R.id.imageView13);
        TextView wishesTextView = findViewById(R.id.Wishes);
        ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) wishesTextView.getLayoutParams();
        TextView primogemsTextView = findViewById(R.id.Primogems);
        ViewGroup.MarginLayoutParams params2 = (ViewGroup.MarginLayoutParams) primogemsTextView.getLayoutParams();
        Button button = findViewById(R.id.button);
        ViewGroup.MarginLayoutParams params3 = (ViewGroup.MarginLayoutParams) button.getLayoutParams();
        
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            imageView.setVisibility(View.GONE);
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            imageView.setVisibility(View.VISIBLE);
        }
        
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            params.topMargin = (int) TypedValue.applyDimension(
                    TypedValue.COMPLEX_UNIT_DIP, -20, getResources().getDisplayMetrics()
            );
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            params.topMargin = (int) TypedValue.applyDimension(
                    TypedValue.COMPLEX_UNIT_DIP, 0, getResources().getDisplayMetrics()
            );
        }
        
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            params2.topMargin = (int) TypedValue.applyDimension(
                    TypedValue.COMPLEX_UNIT_DIP, 100, getResources().getDisplayMetrics()
            );
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            params2.topMargin = (int) TypedValue.applyDimension(
                    TypedValue.COMPLEX_UNIT_DIP, 0, getResources().getDisplayMetrics()
            );
        }
        
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            params3.topMargin = (int) TypedValue.applyDimension(
                    TypedValue.COMPLEX_UNIT_DIP, 145, getResources().getDisplayMetrics()
            );
        } else {
            params3.topMargin = (int) TypedValue.applyDimension(
                    TypedValue.COMPLEX_UNIT_DIP, 0, getResources().getDisplayMetrics()
            );
        }
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
