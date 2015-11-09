package com.example.jons.proyecto;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Window;

public class GridActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_grid);
    }
}
