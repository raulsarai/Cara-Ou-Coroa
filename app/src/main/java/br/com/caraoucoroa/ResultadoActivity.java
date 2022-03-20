package br.com.caraoucoroa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class ResultadoActivity extends AppCompatActivity {

    ImageView botaoVoltar, resultadoCaraCoroa;
    TextView textoResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        Bundle selecionado = getIntent().getExtras();
        Integer ladoselecionado = selecionado.getInt("selecao");

        botaoVoltar         = findViewById(R.id.imageVoltar);
        resultadoCaraCoroa  = findViewById(R.id.imageCaraCoroa);
        textoResultado      = findViewById(R.id.textResultado);


        Integer sorteio = new Random().nextInt(2);

        switch (sorteio){
            case 0:
                resultadoCaraCoroa.setImageResource(R.drawable.moeda_cara);
                if (ladoselecionado == 0){
                    textoResultado.setText("DEU CARA, VOCÊ GANHOU");
                }else{
                    textoResultado.setText("DEU CARA, VOCÊ PERDEU");
                }
                break;
            case 1:
                resultadoCaraCoroa.setImageResource(R.drawable.moeda_coroa);

                if (ladoselecionado == 1){
                    textoResultado.setText("DEU COROA, VOCÊ GANHOU");
                }else{
                    textoResultado.setText("DEU COROA, VOCÊ PERDEU");
                }
                break;
        }

        botaoVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }
}