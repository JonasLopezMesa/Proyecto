package com.example.jons.proyecto;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class GridActivity extends ActionBarActivity implements View.OnClickListener {

    ImageButton home;
    GridView lv;
    Spinner spinner;
    int mod = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_grid);



        spinner = (Spinner)findViewById(R.id.spinner2);
        List list = new ArrayList();
        list.add("Item 1");
        list.add("Item 2");
        list.add("Item 3");
        list.add("Item 4");
        list.add("Item 5");
        list.add("Item 6");
        list.add("Item 7");
        list.add("Item 8");

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, list);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);



        final Vinos bandas_data[] = new Vinos[]{
                new Vinos(R.drawable.vino, "Vino1"),
                new Vinos(R.drawable.vino, "Vino2"),
                new Vinos(R.drawable.vino, "Vino3"),
                new Vinos(R.drawable.vino, "Vino4"),
                new Vinos(R.drawable.vino, "Vino5"),
                new Vinos(R.drawable.vino, "Vino6"),
                new Vinos(R.drawable.vino, "Vino7"),
                new Vinos(R.drawable.ic_launcher, "Vino8"),
                new Vinos(R.drawable.ic_launcher, "Vino9"),
                new Vinos(R.drawable.ic_launcher, "Vino10"),
                new Vinos(R.drawable.ic_launcher, "Vino11"),
                new Vinos(R.drawable.ic_launcher, "Vino12"),
                new Vinos(R.drawable.ic_launcher, "Vino13"),
                new Vinos(R.drawable.ic_launcher, "Vino14"),
                new Vinos(R.drawable.ic_launcher, "Vino15"),
                new Vinos(R.drawable.ic_launcher, "Vino21"),
                new Vinos(R.drawable.ic_launcher, "Vino32"),
                new Vinos(R.drawable.ic_launcher, "Vino41"),
                new Vinos(R.drawable.ic_launcher, "Vino55"),
                new Vinos(R.drawable.ic_launcher, "Vino64"),
                new Vinos(R.drawable.ic_launcher, "Vino76"),
                new Vinos(R.drawable.ic_launcher, "Vino83"),
                new Vinos(R.drawable.ic_launcher, "Vino94"),
                new Vinos(R.drawable.ic_launcher, "Vino120"),
                new Vinos(R.drawable.ic_launcher, "Vino151"),
                new Vinos(R.drawable.ic_launcher, "Vino127"),
                new Vinos(R.drawable.ic_launcher, "Vino135"),
                new Vinos(R.drawable.ic_launcher, "Vino148"),
                new Vinos(R.drawable.ic_launcher, "Vino12"),
                new Vinos(R.drawable.ic_launcher, "Vino13"),
                new Vinos(R.drawable.ic_launcher, "Vino14"),
                new Vinos(R.drawable.ic_launcher, "Vino15"),
                new Vinos(R.drawable.ic_launcher, "Vino21"),
                new Vinos(R.drawable.ic_launcher, "Vino32"),
                new Vinos(R.drawable.ic_launcher, "Vino41"),
                new Vinos(R.drawable.ic_launcher, "Vino55"),
                new Vinos(R.drawable.ic_launcher, "Vino64"),
                new Vinos(R.drawable.ic_launcher, "Vino76"),
                new Vinos(R.drawable.ic_launcher, "Vino83"),
                new Vinos(R.drawable.ic_launcher, "Vino94"),
                new Vinos(R.drawable.ic_launcher, "Vino120"),
                new Vinos(R.drawable.ic_launcher, "Vino151"),
                new Vinos(R.drawable.ic_launcher, "Vino127"),
                new Vinos(R.drawable.ic_launcher, "Vino135"),
                new Vinos(R.drawable.ic_launcher, "Vino148"),
        };
        VinosAdapter adapter = new VinosAdapter(GridActivity.this, R.layout.grid_view_item_row, bandas_data);
        lv = (GridView) findViewById(R.id.grid);

        View header = (View) getLayoutInflater().inflate(R.layout.grid_header_row, null);
        lv.setAdapter(adapter);

        final Vinos modificado[] = new Vinos[20];

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) { // Que hacer cuando se selecciona un ítem
                Toast.makeText(GridActivity.this, "Position " + String.valueOf(spinner.getSelectedItem()), Toast.LENGTH_SHORT).show();
                if (String.valueOf(spinner.getSelectedItem()).equals("Item 2")) {
                    Log.i("GridActivity", "Entró en el primer IF");
                    int j = 0;
                    for (int i = 0; i < 10; i++) {
                        Log.i("GridActivity", "jeje");
                        if (bandas_data[i].get_title().equals("Vino1")) {
                            Log.i("GridActivity", bandas_data[i].get_title());
                            Log.i("GridActivity", "titl1e");
                            modificado[j] = new Vinos(bandas_data[i].get_icon(), bandas_data[i].get_title());
                            //modificado[j].set_title(bandas_data[i].get_title());
                            Log.i("GridActivity", "title");
                            //modificado[j].set_icon(bandas_data[i].get_icon());
                            Log.i("GridActivity", "icon");
                            j++;
                            mod = 1;
                        }
                    }
                    Log.i("GridActivity", "1");
                    VinosAdapter adapter = new VinosAdapter(GridActivity.this, R.layout.grid_view_item_row, modificado);
                    Log.i("GridActivity", "2");
                    lv = (GridView) findViewById(R.id.grid);
                    Log.i("GridActivity", "3");

                    View header = (View) getLayoutInflater().inflate(R.layout.grid_header_row, null);
                    Log.i("GridActivity", "4");
                    lv.setAdapter(adapter);
                    Log.i("GridActivity", "5");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


       /* lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView v = (TextView) view.findViewById(R.id.tv);
                Toast.makeText(getApplicationContext(), v.getText(), Toast.LENGTH_SHORT).show();
            }
        });*/

          lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                DialogoPersonalizado dialogo = new DialogoPersonalizado();
                dialogo.show(fragmentManager, "tagPersonalizado");
            }
        });


       /* lv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                DialogoPersonalizado dialogo = new DialogoPersonalizado();
                dialogo.show(fragmentManager, "tagPersonalizado");
            }
        });
*/

        home = (ImageButton) findViewById(R.id.homeicon);
        home.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.homeicon:
                Log.i("MyActivity", "Se pulso el boton home");
                setResult(RESULT_OK);
                finish();
                break;
        }
    }
}