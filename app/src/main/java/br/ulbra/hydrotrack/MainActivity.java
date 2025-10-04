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
    EditText txtPeso, txtIdade;
    TextView txtConsumo,txtvMeta,txtvRestante ;
    RadioGroup btnGrupo;



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
        btnGrupo = findViewById(R.id.rbtAtividade);
        txtConsumo = findViewById(R.id.txtConsumo);
        txtvRestante = findViewById(R.id.txtvRestante);
        txtvMeta = findViewById(R.id.txtvMeta);



        btnCalcularMeta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double consumo_base, peso, consumo_total, restante, extra =0;

                peso = Double.parseDouble(txtPeso.getText().toString());
                consumo_base = peso * 35;
                consumo_total = consumo_base + extra;
                restante = consumo_total - consumo_base;

                int idSelecionado = btnGrupo.getCheckedRadioButtonId();

                if(idSelecionado == btnSedentario){
                    extra = 0;
                } else if (idSelecionado == R.id.btnModerado) {
                    extra = 300;
                } else if (idSelecionado == R.id.btnIntenso) {
                    extra = 600;
                }
            }
        });


    }
}