package com.example.sy3_2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button button=findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 加载login.xml文件
                View loginForm =View.inflate(getApplication(),R.layout.login,null);
                AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this)
                        .setView(loginForm);
                builder.create().show();
            }
        });

    }
}