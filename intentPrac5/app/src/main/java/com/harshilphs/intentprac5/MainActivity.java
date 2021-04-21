package com.harshilphs.intentprac5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText iptext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iptext = (EditText)findViewById(R.id.editText);
    }

    public void gotoSecondScreen(View view){
        String name = iptext.getText().toString();
        Intent intent = new Intent(this,MainActivity2.class);
        intent.putExtra("name",name);
        startActivity(intent);
    }
}