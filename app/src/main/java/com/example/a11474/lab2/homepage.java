package com.example.a11474.lab2;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class homepage extends Fragment {
    Button hospital,police,carpolice,fire,forestfire,emass;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        hospital=getActivity().findViewById(R.id.button3);
        police=getActivity().findViewById(R.id.button4);
        carpolice=getActivity().findViewById(R.id.button6);
        fire=getActivity().findViewById(R.id.button5);
        forestfire=getActivity().findViewById(R.id.button7);
        emass=getActivity().findViewById(R.id.button8);

        hospital.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(),contect_infor.class);
                Bundle bundle = new Bundle();
                bundle.putString("name","hospital");
                i.putExtras(bundle);
                startActivity(i);

            }
        });

        police.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(),contect_infor.class);
                Bundle bundle = new Bundle();
                bundle.putString("name","police");
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        carpolice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(),contect_infor.class);
                String name="carpolice";
                Bundle bundle = new Bundle();
                bundle.putString("name",name);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        fire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(),contect_infor.class);
                String name="fire";
                Bundle bundle = new Bundle();
                bundle.putString("name",name);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        forestfire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(),contect_infor.class);
                String name="forestfire";
                Bundle bundle = new Bundle();
                bundle.putString("name",name);
                i.putExtras(bundle);
                startActivity(i);            }
        });

        emass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(),contect_infor.class);
                String name="emass";
                Bundle bundle = new Bundle();
                bundle.putString("name",name);
                i.putExtras(bundle);
                startActivity(i);
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_homepage, container, false);
    }
}