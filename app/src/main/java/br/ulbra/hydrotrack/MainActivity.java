package br.ulbra.hydrotrack;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    RadioButton btnSedentario, btnModerado, btnIntenso;
    Button btnCalcularMeta;
    EditText txtPeso, txtIdade, txtIngestao;
    TextView txtvRestante,  txtMeta, txtSugestao;
    RadioGroup rbtAtividade;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        txtIdade = findViewById(R.id.txtIdade);
        txtPeso = findViewById(R.id.txtPeso);
        btnCalcularMeta = findViewById(R.id.btnCalcularMeta);
        btnSedentario = findViewById(R.id.btnSedentario);
        btnModerado = findViewById(R.id.btnModerado);
        btnIntenso = findViewById(R.id.btnIntenso);
        rbtAtividade = findViewById(R.id.rbtAtividade);
        txtvRestante = findViewById(R.id.txtvRestante);
        txtIngestao = findViewById(R.id.txtIngestao);
        txtMeta = findViewById(R.id.txtMeta);
        txtSugestao = findViewById(R.id.txtSugestao);



        btnCalcularMeta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double consumo_base, peso, consumo_total, restante, ingestao, extra =0;
                ingestao = Double.parseDouble(txtIngestao.getText().toString());
                peso = Double.parseDouble(txtPeso.getText().toString());

                consumo_base = peso * 35;
                consumo_total = consumo_base + extra;
                restante = consumo_total - ingestao;

                int idSelecionado = rbtAtividade.getCheckedRadioButtonId();

                if(idSelecionado == R.id.btnSedentario){
                    extra = 0;
                } else if (idSelecionado == R.id.btnModerado) {
                    extra = 300;
                } else if (idSelecionado == R.id.btnIntenso) {
                    extra = 600;
                }

                txtvRestante.setText("O restante será de: " + restante);
                txtMeta.setText("A meta será: " + consumo_total);

                if (idSelecionado == R.id.btnSedentario){
                    txtSugestao.setText("Beba mais água.");
                }else if (idSelecionado == R.id.btnModerado){
                    txtSugestao.setText("Beba um pouco mais de água.");
                }else if (idSelecionado == R.id.btnIntenso){
                    txtSugestao.setText("Continue assim!");
                }

            }
        });


    }
}