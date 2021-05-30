package com.example.viewmodellivedata.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.viewmodellivedata.R;
import com.example.viewmodellivedata.viewmodel.Sumar;
import com.example.viewmodellivedata.viewmodel.SumarViewModel;

public class ViewModelSumarActivity extends AppCompatActivity {

    private TextView tvSumar, tvSumarViewModel;
    private Button btSumar;
    private SumarViewModel sumarViewModel;
    private int numero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_model_sumar);
        configView();
    }

    private void configView() {

        sumarViewModel = new ViewModelProvider(this).get(SumarViewModel.class);

        tvSumar=findViewById(R.id.idtxtsumar);
        tvSumarViewModel=findViewById(R.id.idtxtsumarViewModel);

        tvSumar.setText(" " + numero);
        tvSumarViewModel.setText(" " + sumarViewModel.getResultado());

        btSumar=findViewById(R.id.idbtsumar);
        btSumar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numero = Sumar.sumar(numero);
                tvSumar.setText(" " + numero);
                sumarViewModel.setResultado(Sumar.sumar(sumarViewModel.getResultado()));
                tvSumarViewModel.setText(" " + sumarViewModel.getResultado());
            }
        });
    }
}