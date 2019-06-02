package com.example.a11474.lab2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

public class register extends AppCompatActivity {
    TextView textView3;
    EditText editText3,editText4,editText5,editText6,editText;
    Button register;
    String serverurl ="http://lsb1996614.000webhostapp.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        editText =findViewById(R.id.editText);
        textView3=findViewById(R.id.textView3);
        editText3=findViewById(R.id.editText3);
        editText4=findViewById(R.id.editText4);
        editText5=findViewById(R.id.editText5);
        editText6=findViewById(R.id.editText6);
        register=findViewById(R.id.register);

        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(register.this,login.class);
                startActivity(i);
                finish();
            }
        });
       register.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               String email=editText3.getText().toString().trim();
               String password=editText4.getText().toString().trim();
               String cpassword =editText6.getText().toString().trim();
               String phoneno=editText5.getText().toString().trim();
               String name=editText.getText().toString().trim();
               if(!email.equals("")) {
                   if(!password.equals("")){
                    if (password.equals(cpassword))
                       Register(email, password,phoneno,name);
                    else {
                        editText6.setError("Password is not same  !");

                        }
                     }
                     else {
                       editText4.setError("Please enter valid password !");
                   }
                 }

               else {
                   editText3.setError("Please enter valid email address !");

               }
           }
       });
    }

    private void Register(final String email,final String password,final String phoneno,final String name) {
        @SuppressLint("StaticFieldLeak")
        class reg extends AsyncTask<Void,Void,String> {
            @Override
            protected String doInBackground(Void... voids) {
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("email", email);
                hashMap.put("password", password);
                hashMap.put("phoneno",phoneno);
                hashMap.put("username",name);
                RequestHandler rh = new RequestHandler();
                String s =rh.sendPostRequest(serverurl+"/register.php",hashMap);
                return  s;
            }
            @Override
            protected void onPostExecute(String s) {
              super.onPostExecute(s);
              if (s.equals("success")){
                  Toast.makeText(register.this,"success",Toast.LENGTH_LONG).show();
                  Intent i =new Intent(register.this,login.class);
                  startActivity(i);
                  finish();
              }
              else {
                  Toast.makeText(register.this,"faild",Toast.LENGTH_LONG).show();
              }

            }

        }
        try{
            reg r =new reg();
            r.execute();
        }
        catch (Exception e)
        {}
    }

}
