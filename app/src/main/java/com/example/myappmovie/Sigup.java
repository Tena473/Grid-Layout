package com.example.myappmovie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.vishnusivadas.advanced_httpurlconnection.PutData;

public class Sigup extends AppCompatActivity {
    TextInputEditText textInputEditTextName,textInputEditTextPassword,textInputEditTextEmail,textInputEditTextPhone;
    Button button_sig;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sigup);

        textView=(TextView)findViewById(R.id.textLogin);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Sigup.this,MainActivity.class);
                startActivity(intent);
            }
        });

        textInputEditTextName = findViewById(R.id.name);
        textInputEditTextPassword = findViewById(R.id.password);
        textInputEditTextEmail = findViewById(R.id.email);
        textInputEditTextPhone = findViewById(R.id.phone);

        button_sig = findViewById(R.id.button_sig);

        button_sig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name,password,email,phone;
                name = String.valueOf(textInputEditTextName.getText());
                password = String.valueOf(textInputEditTextPassword.getText());
                email = String.valueOf(textInputEditTextEmail.getText());
                phone = String.valueOf(textInputEditTextPhone.getText());

                if (!name.equals("") && !password.equals("") && !email.equals("") && !phone.equals("")) {
                    //Start ProgressBar first (Set visibility VISIBLE)
                    Handler handler = new Handler(Looper.getMainLooper());
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            //Starting Write and Read data with URL
                            //Creating array for parameters
                            String[] field = new String[4];
                            field[0] = "name";
                            field[1] = "password";
                            field[2] = "email";
                            field[3] = "phone";
                            //Creating array for data
                            String[] data = new String[4];
                            data[0] = name;
                            data[1] = password;
                            data[2] = email;
                            data[3] = phone;
                            PutData putData = new PutData("http://192.168.100.5/android1/signup.php", "POST", field, data);
                            if (putData.startPut()) {
                                if (putData.onComplete()) {
                                    String result = putData.getResult();
                                    if (result.equals("Sign Up Success")){
                                        Toast.makeText(getApplicationContext(),result,Toast.LENGTH_LONG).show();
                                        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
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