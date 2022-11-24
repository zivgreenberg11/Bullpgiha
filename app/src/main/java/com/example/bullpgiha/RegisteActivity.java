package com.example.bullpgiha;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RegisteActivity extends AppCompatActivity {
    private EditText etName, etPas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registe);
        initView();
    }

    private void initView() {
        etName = findViewById(R.id.editTextTextPersonName);
        etPas = findViewById(R.id.editTextTextPassword);
    }

    public void Registerlick(View view) {
        String nameStr = etName.getText().toString();
        String pasStr = etPas.getText().toString();
        //1. בדיקה אם המידע תקין
        //2. שצירה
        //3. מעבר למשחק
        if(nameStr.length()==0 || pasStr.length()==0){
            Toast.makeText(this, "אחד הפריטים חסר", Toast.LENGTH_LONG).show();
        }
        else{
            saveData(nameStr,pasStr);
            startActivity(new Intent(this, GameActivity.class));
        }
    }

    private void saveData(String nameStr, String pasStr) {
        SharedPreferences sharedPreferences=
                getSharedPreferences("myData", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("name",nameStr);
        editor.putString("pas",pasStr);
        editor.commit();
    }
}