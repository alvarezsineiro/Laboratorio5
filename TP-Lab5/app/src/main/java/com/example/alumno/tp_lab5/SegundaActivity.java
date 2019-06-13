package com.example.alumno.tp_lab5;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class SegundaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        FloatingActionButton bt;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);

        ActionBar actionBar =getSupportActionBar();
        actionBar.setTitle("Noticia");
        actionBar.setDisplayHomeAsUpEnabled(true);

        WebView wv=(WebView)findViewById(R.id.webview);
        WebSettings ws =wv.getSettings();
        ws.setJavaScriptEnabled(true);
        wv.setWebViewClient(new WebViewClient());
        Intent i = getIntent();
        wv.loadUrl(i.getStringExtra("Url"));

        bt=(FloatingActionButton)findViewById(R.id.fab);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Intent.ACTION_SEND);
                i.setType("text/plain");
                String shareBody = "Body";
                String shareSub = "Sub";
                i.putExtra(Intent.EXTRA_SUBJECT,shareSub);
                i.putExtra(Intent.EXTRA_TEXT,shareBody);
                startActivity(Intent.createChooser(i,"Compartir"));
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
