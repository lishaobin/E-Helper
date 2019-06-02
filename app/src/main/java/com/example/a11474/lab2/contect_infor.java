package com.example.a11474.lab2;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;
import java.util.Locale;


public class contect_infor extends Activity {
    ImageView call, message, icon;
    TextView phoneno,location;
    private LocationManager locationManager;
    private String provider;
    String string;


    @SuppressWarnings("static-access")

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contect_infor);
        Bundle bundle = this.getIntent().getExtras();
        String name = bundle.getString("name");
        phoneno = findViewById(R.id.phones);
        icon = findViewById(R.id.icons);
        call = findViewById(R.id.call);
        message = findViewById(R.id.message);
        location=findViewById(R.id.location);
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        List<String> list = locationManager.getProviders(true);

        if (list.contains(LocationManager.GPS_PROVIDER)) {

            provider = LocationManager.GPS_PROVIDER;
            Toast.makeText(this, "GPS is turn on",
                    Toast.LENGTH_LONG).show();
        } else if (list.contains(LocationManager.NETWORK_PROVIDER)) {

            provider = LocationManager.NETWORK_PROVIDER;
            Toast.makeText(this, "Network is turn on",
                    Toast.LENGTH_LONG).show();

        } else {
            Toast.makeText(this, "Please check your network or GPS is turned on",
                    Toast.LENGTH_LONG).show();
            return;
        }

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        Location located = locationManager.getLastKnownLocation(provider);
        if (location != null) {
            string = "Latitude is ：" + located.getLatitude() + ",Longitude is ："
                    + located.getLongitude();



        }
        locationManager.requestLocationUpdates(provider, 0, 2,
                locationListener);


        switch (name) {

            case "hospital": {
                icon.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.hospital));
                phoneno.setText("Ambulance No : 999");
                call.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(Intent.ACTION_DIAL);
                        Uri data = Uri.parse("tel:" + 999);
                        intent.setData(data);
                        startActivity(intent);

                    }
                });

                message.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:" + 999));
                        intent.putExtra("sms_body", "I need an ambulance and my location is "+string);
                        startActivity(intent);


                    }
                });
                break;
            }

            case "police": {
                icon.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.police));
                phoneno.setText("Police No : 999");
                call.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(Intent.ACTION_DIAL);
                        Uri data = Uri.parse("tel:" + 999);
                        intent.setData(data);
                        startActivity(intent);

                    }
                });
                message.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:" + 999));
                        intent.putExtra("sms_body", "I am in danger ,help me ,my location is  "+string);
                        startActivity(intent);


                    }
                });
                break;
            }
            case "carpolice": {
                icon.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.car));
                phoneno.setText("Car Police No : 999");
                call.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(Intent.ACTION_DIAL);
                        Uri data = Uri.parse("tel:" + 999);
                        intent.setData(data);
                        startActivity(intent);

                    }
                });
                message.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:" + 999));
                        intent.putExtra("sms_body","There was a car accident and location is  "+ string);
                        startActivity(intent);


                    }
                });
                break;
            }

            case "fire": {
                icon.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.fire));
                phoneno.setText("Fire No : 994");
                call.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(Intent.ACTION_DIAL);
                        Uri data = Uri.parse("tel:" + 994);
                        intent.setData(data);
                        startActivity(intent);

                    }
                });
                message.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:" + 999));
                        intent.putExtra("sms_body", "There is a fire here now and location is  "+string);
                        startActivity(intent);


                    }
                });
                break;
            }


            case "forestfire": {
                icon.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.forst));
                phoneno.setText("Forest Fire No : 994");
                call.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(Intent.ACTION_DIAL);
                        Uri data = Uri.parse("tel:" + 994);
                        intent.setData(data);
                        startActivity(intent);

                    }
                });
                message.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:" + 999));
                        intent.putExtra("sms_body", "There is a forest fire here now and location is  "+string);
                        startActivity(intent);


                    }
                });
                break;
            }


            case "emass": {
                icon.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.dashiguan));
                phoneno.setText("Embassy in Malaysia Tel : (+60) 3 21428495");
                call.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(Intent.ACTION_DIAL);
                        Uri data = Uri.parse("tel:" + 321428495);
                        intent.setData(data);
                        startActivity(intent);

                    }
                });
                message.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:" + 999));
                        intent.putExtra("sms_body", "I need your help and my location is  "+string);
                        startActivity(intent);


                    }
                });
                break;
            }
        }


    }



    LocationListener locationListener = new LocationListener() {

        @Override
        public void onStatusChanged(String arg0, int arg1, Bundle arg2) {
            // TODO Auto-generated method stub

        }

        @Override
        public void onProviderEnabled(String arg0) {
            // TODO Auto-generated method stub

        }

        @Override
        public void onProviderDisabled(String arg0) {
            // TODO Auto-generated method stub

        }

        @Override
        public void onLocationChanged(Location arg0) {

            // TODO Auto-generated method stub
            // 更新当前经纬度
        }
    };



    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();
        if (locationManager != null) {
            locationManager.removeUpdates(locationListener);
        }
    }


}
