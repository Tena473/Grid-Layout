package com.example.myappmovie;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.vishnusivadas.advanced_httpurlconnection.PutData;

public class MainActivity extends AppCompatActivity {

    TextInputEditText textInputEditTextName,textInputEditTextPassword;
    Button button_log;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textSign);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Sigup.class);
                startActivity(intent);
            }
        });

        textInputEditTextName = findViewById(R.id.name);
        textInputEditTextPassword = findViewById(R.id.password);
        button_log = findViewById(R.id.button_log);

        button_log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name,password;
                name = String.valueOf(textInputEditTextName.getText());
                password = String.valueOf(textInputEditTextPassword.getText());


                if (!name.equals("") && !password.equals("")) {
                    //Start ProgressBar first (Set visibility VISIBLE)
                    Handler handler = new Handler(Looper.getMainLooper());
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            //Starting Write and Read data with URL
                            //Creating array for parameters
                            String[] field = new String[2];
                            field[0] = "name";
                            field[1] = "password";
                            //Creating array for data
                            String[] data = new String[2];
                            data[0] = name;
                            data[1] = password;
                            PutData putData = new PutData("https://mobileshop01.000webhostapp.com/login.php", "POST", field, data);
                            if (putData.startPut()) {
                                if (putData.onComplete()) {
                                    String result = putData.getResult();
                                    if (result.equals("Login Success")){
                                        Toast.makeText(getApplicationContext(),result,Toast.LENGTH_LONG).show();
                                        Intent intent = new Intent(getApplicationContext(),Index.class);
                                        startActivity(intent);
                                        finish();
                                    }else {
                                        Toast.makeText(getApplicationContext(),result,Toast.LENGTH_LONG).show();
                                    }

                                }
                            }
                            //End Write and Read data with URL
                        }
                    });
                } else {
                    Toast.makeText(getApplicationContext(),"ປ້ອນຂໍ້ມູນໃຫ້ຄົບ",Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}