package com.example.jons.proyecto;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class GridActivity extends ActionBarActivity implements View.OnClickListener {

    ImageButton home; //Variable del botón home
    GridView lv; //Variable del Grid
    Spinner spinner; //Variable del selector, en ese caso sólo está el primero.
    int mod = 0;
    int variableidioma;
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
    public void hideVirtualButtons() {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);
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
        Intent intent =getIntent();
        Bundle extras = intent.getExtras();

        requestWindowFeature(Window.FEATURE_NO_TITLE); //Impedir que se vea el AppBar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            hideVirtualButtons();
        }

        setContentView(R.layout.activity_grid); //Iniciar el activity

        //Enlazar los objetos con el Layout
        spinner = (Spinner)findViewById(R.id.spinner2); //Enlazar el Spinner con el layout
        lv = (GridView) findViewById(R.id.grid); //Enlazar el Grid con el Layout
        home = (ImageButton) findViewById(R.id.homeicon); //Enlazar el botón con el Layout

        //BOTÓN HOME/////////////////////////////////////////////////////////////////////////////////////////////////////////
        home.setOnClickListener(this); //Función que permite que se hagan cosas al pulsar el botón home

        //SPINNER////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //rellenar Spinner de prueba, este Spinner es de prueba para probar como interactuarían los Spinners con el Grid
        List list = new ArrayList();
        if(extras != null){
            int dato = extras.getInt("Variable");
            if (dato == 1){
                Log.i("MyActivity", "if1");
                list.add(getResources().getString(R.string.tipoes));
                list.add("Vino1");
                list.add("Vino2");
                list.add("Vino3");
                list.add("Vino4");
                list.add("Vino5");
                list.add("Vino6");
                list.add("Vino7");
                list.add("Vino8");

            }
            if (dato == 2){
                Log.i("MyActivity", "if2");
                list.add(getResources().getString(R.string.tipoen));
                list.add("Vino1");
                list.add("Vino2");
                list.add("Vino3");
                list.add("Vino4");
                list.add("Vino5");
                list.add("Vino6");
                list.add("Vino7");
                list.add("Vino8");

            }
            if (dato == 3){
                Log.i("MyActivity", "if3");
                list.add(getResources().getString(R.string.tipoal));
                list.add("Vino1");
                list.add("Vino2");
                list.add("Vino3");
                list.add("Vino4");
                list.add("Vino5");
                list.add("Vino6");
                list.add("Vino7");
                list.add("Vino8");

            }
            if (dato == 4){
                Log.i("MyActivity", "if4");
                list.add(getResources().getString(R.string.tiporu));
                list.add("Vino1");
                list.add("Vino2");
                list.add("Vino3");
                list.add("Vino4");
                list.add("Vino5");
                list.add("Vino6");
                list.add("Vino7");
                list.add("Vino8");

            }}
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, list); //Adaptador para el Spinner
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter); //Adaptador para el Spinner


        //GRID///////////////////////////////////////////////////////////////////////////////////////////////////////////////
        final ArrayList<Vinos> array_vinos = new ArrayList<Vinos>();
        int c;
        for (int i = 0; i < 50; i++) {
            String aux = "Vino" + String.valueOf(i).toString();
            if (i!=0){
                if ((i/5)%2==0){
                    c = Color.WHITE;
                } else{
                    c = Color.GRAY;
                }
            } else {
                c = Color.WHITE;
            }
            array_vinos.add(new Vinos(R.drawable.botellaa, aux, c));
        }

        VinosAdapter adapter = new VinosAdapter(GridActivity.this, R.layout.grid_view_item_row, array_vinos); //Adaptador para el GRID
        View header = (View) getLayoutInflater().inflate(R.layout.grid_header_row, null);
        lv.setAdapter(adapter);

        //FUNCIÓN QUE SE ACTIVA CUANDO SE SELECCIONA UN ITEM DEL SPINNER
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { //Cuando se selecciona un ITEM del Spinner
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) { // Que hacer cuando se selecciona un ítem

                 Toast.makeText(GridActivity.this, "Position " + String.valueOf(spinner.getSelectedItem()), Toast.LENGTH_SHORT).show(); //Hace un toast
                int j = 0; //Variable que servirá para incrementar el nuevo vector modificado que almacenará los nuevos datos del grid.
                if (String.valueOf(spinner.getSelectedItem()).equals("Tipo") == false) { //Si el item seleccionado por el Spinner es Tipo, no cambia el estado del grid. Debería mostrar todos los Vinos. Necesita un Else
                    int contador = 0; //Variable que contará de que tamaño se debe construir el vector que almacenará los nuevos datos
                    for (int i = 0; i < array_vinos.size(); i++) { //Se recorre todo el vector donde están los vinos
                        if (array_vinos.get(i).get_title().equals(String.valueOf(spinner.getSelectedItem()))) { //Si es el vino seleccionado en el Spinner
                            contador = contador + 1; //Se aumenta 1 en el contador
                        }
                    }
                    final ArrayList<Vinos> modificado = new ArrayList<Vinos>(); //Se crea el nuevo vector con el tamaño indicado anteriormente
                    //Se recorre de nuevo el vector
                    for (int i = 0; i < array_vinos.size(); i++)
                        if (array_vinos.get(i).get_title().equals(String.valueOf(spinner.getSelectedItem()))) {  //Si es el vino seleccionado en el Spinner
                            modificado.add(new Vinos(array_vinos.get(i).get_icon(), array_vinos.get(i).get_title(), array_vinos.get(i).color)); //Se almacenan los datos nuevos en el vector modificado
                            j++; //Se incrementa el contador
                        }
                    VinosAdapter adapter = new VinosAdapter(GridActivity.this, R.layout.grid_view_item_row, modificado); //Se vuelve a crear el adaptador para los vinos con el nuevo vector
                    lv = (GridView) findViewById(R.id.grid);
                    View header = (View) getLayoutInflater().inflate(R.layout.grid_header_row, null);
                    lv.setAdapter(adapter);
                } //else {
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) { //Que hacer cuando no hay nada seleccionado
                hideVirtualButtons();
                //Nada por ahora
            }
        });

        //FUNCIÓN QUE SE ACTIVA CUANDO SE SELECCIONA UN ELEMENTO DEL GRID
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) { //Al pulsar sobre un elemento del grid
                FragmentManager fragmentManager = getSupportFragmentManager(); //Se crea un fragmento
                DialogoPersonalizado dialogo = new DialogoPersonalizado(); //Se crea el nuevo cuadro de diálogo
                dialogo.show(fragmentManager, "tagPersonalizado"); //Se muestra el nuevo cuadro de diálogo en el fragmento.
            }
        });
    }

    @Override //Para los botones del Activity
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.homeicon:
                Log.i("MyActivity", "Se pulso el boton home");
                setResult(RESULT_OK);
                startActivity(new Intent(this, MainActivity.class));
                overridePendingTransition(R.anim.right_in, R.anim.right_out);
                finish();
                break;
        }
    }
    @Override
    public void onResume() {
        super.onResume();
        hideVirtualButtons();
    }
}