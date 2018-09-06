package com.project.arsalan.kitchenette;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.os.AsyncTask;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.Object.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    Runnable runnableToGetVegDb = new Runnable() {
        @Override
        public void run() {
            Log.d("DEBUG","RUNNING VEG RUNNABLE");
            try {
                URL url = new URL("http://192.168.43.242/luncheon/getveg.php");
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.connect();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
                String response = bufferedReader.readLine();
                TextView updateveg = (TextView) findViewById(R.id.getveg);
                updateveg.setText(response);
                Log.d("DEBUG", response);
                httpURLConnection.disconnect();
            }
            catch (Exception e)
            {
                Log.d("DEBUG",e.toString());
            }
        }
    };

    Runnable runnableToGetNonVegDb = new Runnable() {
        @Override
        public void run() {
            Log.d("DEBUG","RUNNING NON VEG RUNNABLE");
            try {
                URL url = new URL("http://192.168.43.242/luncheon/getnonveg.php");
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.connect();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
                String response = bufferedReader.readLine();
                TextView updatenonveg = (TextView) findViewById(R.id.getnonveg);
                updatenonveg.setText(response);
                Log.d("DEBUG", response);
                httpURLConnection.disconnect();
            }
            catch (Exception e)
            {
                Log.d("DEBUG",e.toString());
            }
        }
    };

    Runnable runnableToGetHostellerDb = new Runnable() {
        @Override
        public void run() {
            Log.d("DEBUG","RUNNING HOSTELLER RUNNABLE");
            try {
                URL url = new URL("http://192.168.43.242/luncheon/gethosteller.php");
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.connect();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
                String response = bufferedReader.readLine();
                TextView updatehosteller = (TextView) findViewById(R.id.gethosteller);
                updatehosteller.setText(response);
                Log.d("DEBUG", response);
                httpURLConnection.disconnect();
            }
            catch (Exception e)
            {
                Log.d("DEBUG",e.toString());
            }
        }
    };

    Runnable runnableToGetDayscholarDb = new Runnable() {
        @Override
        public void run() {
            Log.d("DEBUG","RUNNING DAYSCHOLAR RUNNABLE");
            try {
                URL url = new URL("http://192.168.43.242/luncheon/getdayscholar.php");
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.connect();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
                String response = bufferedReader.readLine();
                TextView updatedayscholar = (TextView) findViewById(R.id.getdayscholar);
                updatedayscholar.setText(response);
                Log.d("DEBUG", response);
                httpURLConnection.disconnect();
            }
            catch (Exception e)
            {
                Log.d("DEBUG",e.toString());
            }
        }
    };





    public void getupdate(View view) {
        //add data to database
        Toast.makeText(this, "Above is the current data.", Toast.LENGTH_SHORT).show();

            //get value of veg from database
            Thread threadToGetVegDb = new Thread(runnableToGetVegDb);
            threadToGetVegDb.start();



            //get value of non-veg from database
            Thread threadToGetNonVegDb = new Thread(runnableToGetNonVegDb);
            threadToGetNonVegDb.start();

            //get value of hosteller from database
            Thread threadToGetHostellerDb = new Thread(runnableToGetHostellerDb);
            threadToGetHostellerDb.start();

            //get value of dayscholar from database
            Thread threadToGetDayScholarDb = new Thread(runnableToGetDayscholarDb);
            threadToGetDayScholarDb.start();

    }



}
