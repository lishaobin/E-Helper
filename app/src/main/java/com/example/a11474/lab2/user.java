package com.example.a11474.lab2;


import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class user extends Fragment {
    Button logout;
    TextView username,userinformation,phone;
    String serverurl ="http://lsb1996614.000webhostapp.com";
    String userinfo,name,phones;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        logout =getActivity().findViewById(R.id.button);
        username = getActivity().findViewById(R.id.textView8);
        userinformation=getActivity().findViewById(R.id.mname);
        phone=getActivity().findViewById(R.id.myphoneNo);


        Bundle bundle = this.getArguments();

        String email = bundle.getString("email");

        username.setText(email);
        displayuser(email);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(),login.class);
                startActivity(i);
                getActivity().finish();
            }
        });
    }

    private void displayuser(final String email) {
        class display extends AsyncTask<Void,Void,String> {


            @Override
            protected String doInBackground(Void... voids) {
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("email", email);
                RequestHandler rh = new RequestHandler();
                String s =rh.sendPostRequest(serverurl+"/displayuser.php",hashMap);
                return  s;
            }
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                if (s.equals(null)){
                  userinfo="no data";

                }
                else {
                    userinfo=s;

//         str = str.replaceAll("[\\pP\\pS\\pZ]","");
                    Pattern p1 = Pattern.compile("phoneno\":\"+\\d+");
                    Pattern p2 = Pattern.compile("\\d+");
                    Pattern p3 = Pattern.compile("username\":\"+\\w+\\s+\\w+");
                    Matcher m1=p1.matcher(userinfo);
                    while(m1.find()){
                        Matcher m2=p2.matcher(m1.group());

                        while(m2.find())
                            phone.setText(m2.group());

                    }
                    Matcher m3=p3.matcher(userinfo);
                    while(m3.find()){
                        Pattern p = Pattern.compile("username\":\"");
                        Matcher m = p.matcher(m3.group());
                        String name= m.replaceAll("");
                        userinformation.setText(name);


                    }




                }

            }
        }
        try{
            display d =new display();
            d.execute();

        }
        catch(Exception e){

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_user, container, false);
    }

}