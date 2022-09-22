package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private boolean iniciarLectura=false;

    Button button;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView actionEvent = findViewById(R.id.actionEvent);
        actionEvent.setText("Action Down");

        button = findViewById(R.id.button);

        button.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    button.setText("Button Pressed");
                    System.out.println(event.getAction());
                }
                if(event.getAction() == MotionEvent.ACTION_UP){
                    button.setText("Iniciar"); //finger was lifted
                }
                return true;
            }
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == 293){
            button.setText("Presionando");
            System.out.println(keyCode);
            event.startTracking();
            return true;
        }
        if (event.getAction() == KeyEvent.ACTION_UP ){
            button.setText("Iniciar");
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if (keyCode == 293 ){
            button.setText("Presionando");
            System.out.println("presionando");
        }
        if (event.getAction() == KeyEvent.ACTION_UP){
            button.setText("Iniciar");
        }
        return super.onKeyUp(keyCode, event);
    }
}