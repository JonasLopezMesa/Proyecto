package com.example.jons.proyecto;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;



public class MainActivity extends ActionBarActivity implements View.OnClickListener {
    //COMENTARIO
    //otro comentario
    ImageButton spain;
    int request;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);


        spain = (ImageButton) findViewById(R.id.spain);
        spain.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.spain:
                Log.i("MyActivity", "Se pulso el boton spain");
                Intent intent = new Intent(MainActivity.this, GridActivity.class);
                startActivityForResult(intent, request);
                break;
        }
    }
}