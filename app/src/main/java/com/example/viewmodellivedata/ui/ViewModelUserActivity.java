package com.example.viewmodellivedata.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.viewmodellivedata.R;
import com.example.viewmodellivedata.User;
import com.example.viewmodellivedata.viewmodel.UserViewModel;

import java.util.ArrayList;
import java.util.List;

public class ViewModelUserActivity extends AppCompatActivity {

    private EditText etNombre, etEdad;
    private Button btSalvar, btVerUser;
    private TextView tvUser, tvUserViewModel;

    private List<User> userList;
    private UserViewModel userViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_model_user);
        configView();
    }

    private void configView() {

       userViewModel = new ViewModelProvider(this).get(UserViewModel.class);
       userList = new ArrayList<>();

       tvUser = findViewById(R.id.userActivityTvUser);
       tvUserViewModel = findViewById(R.id.userActivityTvUserViewModel);

       etNombre = findViewById(R.id.userActivityEtNombre);
       etEdad = findViewById(R.id.userActivityEtEdad);

       btSalvar = findViewById(R.id.userActivityBtSalvar);
       btSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User user = new User();
                user.setEdad(etEdad.getText().toString());
                user.setNombre(etNombre.getText().toString());
                userList.add(user);
                userViewModel.addUser(user);
            }
        });

        btVerUser = findViewById(R.id.userActivityBtVer);
        btVerUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String texto = "";
                for(int i=0; i<userList.size(); i++){
                    texto += userList.get(i).getNombre() + " " + userList.get(i).getEdad()+"\n";
                }
                tvUser.setText(texto);
                texto = "";
                for(User user: userViewModel.getUserList()){
                    texto += user.getNombre() + " " + user.getEdad()+"\n";
                }
                tvUserViewModel.setText(texto);
            }
        });

    }
}