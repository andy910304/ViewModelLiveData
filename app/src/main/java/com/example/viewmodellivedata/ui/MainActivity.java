package com.example.viewmodellivedata.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.viewmodellivedata.R;

public class MainActivity extends AppCompatActivity {

    private Button btViewModel, btViewModelUserActivity, btLiveDataActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        configView();
    }

    private void configView() {
        btViewModel = findViewById(R.id.idButton);
        btViewModel.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),ViewModelSumarActivity.class));
            }
        });

        btViewModelUserActivity = findViewById(R.id.mainActivityBtViewModelUser);
        btViewModelUserActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),ViewModelUserActivity.class));
            }
        });

        btLiveDataActivity = findViewById(R.id.mainActivityBtLiveData);
        btLiveDataActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), LiveDataActivity.class));
            }
        });
    }
}