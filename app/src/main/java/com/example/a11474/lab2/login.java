package com.example.a11474.lab2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

public class login extends AppCompatActivity {
    TextView textView,textView2;
    EditText youremail,yourpassword;
    Button login;
    SharedPreferences sharedPreferences;
    CheckBox RM;
    String serverurl ="http://lsb1996614.000webhostapp.com";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        youremail=findViewById(R.id.youremail);
        yourpassword=findViewById(R.id.yourpassword);
        login=findViewById(R.id.login);
        RM = findViewById(R.id.RM);
        textView=findViewById(R.id.textView);
        textView2=findViewById(R.id.textView2);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(login.this,register.class);
                startActivity(i);
                finish();
            }


        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email =youremail.getText().toString();
                String password =yourpassword.getText().toString();
                Login(email,password);
            }

            private void Login(final String email,final String password) {
              class log extends AsyncTask<Void,Void,String>  {

                  @Override
                  protected void onPostExecute(String s) {
                      super.onPostExecute(s);
                      if (s.equals("success")){
                          Toast.makeText(login.this,"success",Toast.LENGTH_LONG).show();
                          Intent i =new Intent(login.this,MainActivity.class);
                          Bundle bundle = new Bundle();
                          bundle.putString("email", email);
                          i.putExtras(bundle);
                          startActivity(i);
                          finish();
                      }
                      else {
                          Toast.makeText(login.this,"failed",Toast.LENGTH_LONG).show();
                      }
                  }

                  @Override
                  protected String doInBackground(Void... voids) {
                      HashMap<String, String> hashMap = new HashMap<>();
                      hashMap.put("email", email);
                      hashMap.put("password", password);
                      RequestHandler rh = new RequestHandler();
                      String s =rh.sendPostRequest(serverurl+"/login.php",hashMap);
                      return  s;

                  }
              }
              try{
                  log l =new log();
                  l.execute();

              }
              catch(Exception e){

                }
            }
        });



    }
}
