package com.example.viewmodellivedata.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.viewmodellivedata.R;
import com.example.viewmodellivedata.User;
import com.example.viewmodellivedata.viewmodel.LiveDataUserViewModel;
import com.example.viewmodellivedata.viewmodel.SumarViewModel;

import java.util.List;

public class LiveDataActivity extends AppCompatActivity {

    private TextView tvLiveData;
    private Button btSalvar;
    private int numero = 0;
    private LiveDataUserViewModel liveDataUserViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_data);
        configView();
    }

    private void configView() {
        liveDataUserViewModel = new ViewModelProvider(this).get(LiveDataUserViewModel.class);
        tvLiveData = findViewById(R.id.liveDataTv);
        btSalvar = findViewById(R.id.liveDataBtSalvar);
        btSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(numero == 0){
                    User user =  new User();
                    user.setNombre("Alberto");
                    user.setEdad("30");
                    liveDataUserViewModel.addUser(user);
                }

                if(numero == 1){
                    User user =  new User();
                    user.setNombre("Maria");
                    user.setEdad("23");
                    liveDataUserViewModel.addUser(user);
                }

                if(numero == 2){
                    User user =  new User();
                    user.setNombre("Manuel");
                    user.setEdad("40");
                    liveDataUserViewModel.addUser(user);
                }
                numero++;

            }
        });

        // Creacion del Observer para mostrar los datos del usuario

        final Observer<List<User>> listObserver = new Observer<List<User>>() {
            @Override
            public void onChanged(List<User> userList) {
                StringBuilder texto = new StringBuilder();
                for(int i = 0; i < userList.size(); i++){
                    texto.append(userList.get(i).getNombre()).append(userList.get(i).getEdad()).append("\n");
                }
                tvLiveData.setText(texto);

            }
        };

        liveDataUserViewModel.getUserList().observe(this, listObserver);
    }
}