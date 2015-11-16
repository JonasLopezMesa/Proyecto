package com.example.jons.proyecto;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;



public class MainActivity extends ActionBarActivity implements View.OnClickListener {
    ImageButton spain;
    ImageButton england;
    ImageButton germany;
    ImageButton russia;
    int request;

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            // In KITKAT (4.4) and next releases, hide the virtual buttons
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                hideVirtualButtons();
            }
        }
    }
    @TargetApi(19)
    private void hideVirtualButtons() {
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            hideVirtualButtons();
        }
        setContentView(R.layout.activity_main);

                  //TODOS LOS IDIOMAS
        spain = (ImageButton) findViewById(R.id.spain);
        spain.setOnClickListener(this);
        england = (ImageButton) findViewById(R.id.unitedkindong);
        england.setOnClickListener(this);
        germany = (ImageButton) findViewById(R.id.germany);
        germany.setOnClickListener(this);
        russia = (ImageButton) findViewById(R.id.russian);
        russia.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        int variableidioma; //Esta es la variable que voy a usar para saber que idioma debo mostrar: 1:Español, 2:Ingles, 3:Aleman, 4:Ruso
        switch (v.getId()){
            case R.id.spain:
                variableidioma=1;
                Log.i("MyActivity", "Se pulso el boton spain");
                Intent intentes = new Intent(MainActivity.this, GridActivity.class);
                intentes.putExtra("Variable",variableidioma);
                startActivityForResult(intentes, request);
                overridePendingTransition(R.anim.left_in, R.anim.left_out);
                break;
            case R.id.unitedkindong:
                variableidioma=2;
                Log.i("MyActivity", "Se pulso el boton england");
                Intent intenten = new Intent(MainActivity.this, GridActivity.class);
                intenten.putExtra("Variable",variableidioma);
                startActivityForResult(intenten, request);
                overridePendingTransition(R.anim.left_in, R.anim.left_out);
                break;
            case R.id.germany:
                variableidioma=3;
                Log.i("MyActivity", "Se pulso el boton germany");
                Intent intentge = new Intent(MainActivity.this, GridActivity.class);
                intentge.putExtra("Variable",variableidioma);
                startActivityForResult(intentge, request);
                overridePendingTransition(R.anim.left_in, R.anim.left_out);
                break;
            case R.id.russian:
                variableidioma=4;
                Log.i("MyActivity", "Se pulso el boton russia");
                Intent intentru = new Intent(MainActivity.this, GridActivity.class);
                intentru.putExtra("Variable",variableidioma);
                startActivityForResult(intentru, request);
                overridePendingTransition(R.anim.left_in, R.anim.left_out);
                break;
        }
    }
    @Override
    public void onResume() {
        super.onResume();
        hideVirtualButtons();
    }
}