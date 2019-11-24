package com.berthes.swipequiz;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class MainActivity extends AppCompatActivity {

    private ConstraintLayout tela ;
    private TextView tvSwipePerguntas;
    private TextView tvSwipeRespostas;
    String[] perguntas, alternativas;
    int i, y;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvSwipePerguntas = findViewById(R.id.tvSwipePerguntas);
        tvSwipeRespostas = findViewById(R.id.tvSwipeRespostas);
        tela = findViewById(R.id.tela);
        i = 0;
        y = -1;


        tela.setOnTouchListener(new OnSwipeTouchListener(this){

            @Override
            public void onSwipeBottom() {
                super.onSwipeBottom();
                alternativas = getResources().getStringArray(R.array.alternativas);
                i++;
                if(i==2){
                    i=0;
                }
                tvSwipeRespostas.setText(alternativas[i]);

            }

            @Override
            public void onSwipeTop() {
                super.onSwipeTop();
                alternativas = getResources().getStringArray(R.array.alternativas);
                i--;
                if(i==-1){
                    i=1;
                }
                tvSwipeRespostas.setText(alternativas[i]);
            }

            @Override
            public void onSwipeLeft() {
                super.onSwipeLeft();
                perguntas = getResources().getStringArray(R.array.perguntas);
                y++;
                if(y==5){
                    y=0;
                }
                tvSwipePerguntas.setText(perguntas[y]);
            }

            @Override
            public void onSwipeRight() {
                super.onSwipeRight();
                perguntas = getResources().getStringArray(R.array.perguntas);
                y--;
                if(y==-1){
                    y=4;
                }
                tvSwipePerguntas.setText(perguntas[y]);
            }
        });

    }


}
