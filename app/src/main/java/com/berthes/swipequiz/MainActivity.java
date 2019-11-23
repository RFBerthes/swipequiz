package com.berthes.swipequiz;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class MainActivity extends AppCompatActivity {

    private ConstraintLayout tela ;
    private TextView tvSwipe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvSwipe = findViewById(R.id.tvSwipe);
        tela = findViewById(R.id.tela);

        tela.setOnTouchListener(new OnSwipeTouchListener(this){

            @Override
            public void onSwipeBottom() {
                super.onSwipeBottom();
                tvSwipe.setText("Para baixo");
            }

            @Override
            public void onSwipeTop() {
                super.onSwipeTop();
                tvSwipe.setText("Para cima");
            }

            @Override
            public void onSwipeLeft() {
                super.onSwipeLeft();
                tvSwipe.setText("Para esquerda");
            }

            @Override
            public void onSwipeRight() {
                super.onSwipeRight();
                tvSwipe.setText("Para direita");
            }
        });

    }


}
