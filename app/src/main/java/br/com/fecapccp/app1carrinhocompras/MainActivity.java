package br.com.fecapccp.app1carrinhocompras;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private TextView txtResultadoCompra;
    private CheckBox txtArroz, txtLeite, txtFeijao, txtCarne, txtRefrigerante;
    private Button btnSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        txtArroz = findViewById(R.id.txtArroz);
        txtLeite = findViewById(R.id.txtLeite);
        txtFeijao = findViewById(R.id.txtFeijao);
        txtCarne = findViewById(R.id.txtCarne);
        txtRefrigerante = findViewById(R.id.txtRefrigerante);

        txtResultadoCompra = findViewById(R.id.txtResultadoCompra);
        btnSet = findViewById(R.id.btnTotalCompra);

        btnSet.setOnClickListener(view -> calcularCompra());

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void calcularCompra() {
        double total = 0.0;

        if (txtArroz.isChecked()) {
            total += 2.69;
        }
        if (txtLeite.isChecked()) {
            total += 2.70;
        }
        if (txtFeijao.isChecked()) {
            total += 3.38;
        }
        if (txtCarne.isChecked()) {
            total += 16.70;
        }
        if (txtRefrigerante.isChecked()) {
            total += 3.00;
        }

        txtResultadoCompra.setText(String.format("Total: R$ %.2f", total));

    }
}