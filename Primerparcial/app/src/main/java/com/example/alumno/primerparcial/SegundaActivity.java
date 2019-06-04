package com.example.alumno.primerparcial;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;


public class SegundaActivity extends AppCompatActivity implements Handler.Callback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);


        Button b = (Button) findViewById(R.id.btningreso);

        b.setOnClickListener(new MyListener(this,new Handler(this)));


        //XmlParse.jsonparse("{ 'frutas': [ { 'nombre_fruta':'Manzana' , 'cantidad':10 }, { 'nombre_fruta':'Pera' , 'cantidad':20 }, { 'nombre_fruta':'Naranja' , 'cantidad':30 } ] }");



    }

    @Override
    public boolean handleMessage(Message msg) {

        if ( msg.obj.equals("User")||msg.obj.equals("Admin"))
        {

            Intent i=new Intent(this, MainActivity.class);
            i.putExtra("tipo",(String) msg.obj);
            this.finish();
            this.startActivity(i);

        }
        if (msg.obj.equals("error"))
        {
            Log.d("Error",(String) msg.obj);
        }
        return false;
    }

}
