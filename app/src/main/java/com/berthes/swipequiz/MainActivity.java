package com.berthes.swipequiz;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class MainActivity extends AppCompatActivity {

    private ConstraintLayout tela ;
    private TextView tvSwipePerguntas;
    private TextView tvSwipeRespostas;
    String[] perguntas, respostasCertas;
    int i, acertos;
    String[] alternativas = new String[5];



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvSwipePerguntas = findViewById(R.id.tvSwipePerguntas);
        tvSwipeRespostas = findViewById(R.id.tvSwipeRespostas);
        for (int x=0; x < alternativas.length;x++){
            alternativas[x] = "O que você acha?";
        }

        tela = findViewById(R.id.tela);
        i = -1;
        acertos = 0;

        tela.setOnTouchListener(new OnSwipeTouchListener(getApplicationContext()){

            @Override
            public void onSwipeBottom() {
                super.onSwipeBottom();
                alternativas[i] = "NÃO";
                tvSwipeRespostas.setText(alternativas[i]);

            }

            @Override
            public void onSwipeTop() {
                super.onSwipeTop();
                alternativas[i] = "SIM";
                tvSwipeRespostas.setText(alternativas[i]);
            }

            @Override
            public void onSwipeLeft() {
                super.onSwipeLeft();
                perguntas = getResources().getStringArray(R.array.perguntas);
                respostasCertas = getResources().getStringArray(R.array.respostasCertas);
                i++;
                if(i==5){
                    if(alternativas[i-1].equals(respostasCertas[i-1]) && i>-1){
                        Toast.makeText(getApplicationContext(), "RESPOSTA CERTA!", Toast.LENGTH_SHORT).show();
                        acertos++;
                    }else{
                        Toast.makeText(getApplicationContext(), "OPS! ERROU...", Toast.LENGTH_SHORT).show();
                    }
                    i=0;
                    Toast.makeText(getApplicationContext(), "Você acertou "+acertos+" perguntas", Toast.LENGTH_LONG).show();
                    acertos=0;
                }
                tvSwipePerguntas.setText(perguntas[i]);
                tvSwipeRespostas.setText(alternativas[i]);

                if(alternativas[i-1].equals(respostasCertas[i-1]) && i>-1){
                    Toast.makeText(getApplicationContext(), "RESPOSTA CERTA!", Toast.LENGTH_SHORT).show();
                    acertos++;
                }else{
                    Toast.makeText(getApplicationContext(), "OPS! ERROU...", Toast.LENGTH_SHORT).show();
                }






            }

            @Override
            public void onSwipeRight() {
                super.onSwipeRight();
                perguntas = getResources().getStringArray(R.array.perguntas);
                i--;
                if(i==-1){
                    i=4;
                }
                tvSwipePerguntas.setText(perguntas[i]);
                tvSwipeRespostas.setText(alternativas[i]);

            }
        });

    }


}
