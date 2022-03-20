package br.com.caraoucoroa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageView botaoJogar,imageFrontCoroa,imageFrontCara;
    TextView textoSelecaoFront;
    Integer selecao = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botaoJogar      = findViewById(R.id.imageJogar);
        imageFrontCoroa = findViewById(R.id.imageFrontCoroa);
        imageFrontCara  = findViewById(R.id.imageFrontCara);
        textoSelecaoFront = findViewById(R.id.lableObjetoSelecionado);


        imageFrontCara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textoSelecaoFront.setText("VOCÊ SELECIONOU CARA");
                selecao = 0;

            }
        });

        imageFrontCoroa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textoSelecaoFront.setText("VOCÊ SELECIONOU COROA");
                selecao = 1;

            }
        });

        botaoJogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (textoSelecaoFront.getText().equals("SELECIONE UM LADO")){
                    Toast.makeText(MainActivity.this, "ESCOLHA UM LADO DA MOEDA", Toast.LENGTH_SHORT).show();
                }else {
                    Intent intent = new Intent(getApplicationContext(), ResultadoActivity.class);
                    intent.putExtra("selecao", selecao);
                    startActivity(intent);
                }
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void onStop() {
        super.onStop();
        textoSelecaoFront.setText("SELECIONE UM LADO");
    }
}