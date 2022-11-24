package com.example.bullpgiha;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
    public void init(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (this){
                    try {
                        wait(2000);
                        SharedPreferences sharedPreferences=getSharedPreferences("myData", Context.MODE_PRIVATE);
                        String str1 = sharedPreferences.getString("name", null);
                        String str2 = sharedPreferences.getString("pas", null);
                        if (str1!=null)
                            startActivity(new Intent(MainActivity.this,GameActivity.class));
                        else
                            startActivity(new Intent(MainActivity.this,RegisteActivity.class));

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        }).start();
    }
}