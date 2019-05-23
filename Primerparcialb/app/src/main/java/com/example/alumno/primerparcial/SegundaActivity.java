package com.example.alumno.primerparcial;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;


public class SegundaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);


        Button b = (Button) findViewById(R.id.btndos);

        b.setOnClickListener(new MyListener(this));
    }
}
