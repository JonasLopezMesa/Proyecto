package com.example.jons.proyecto;

import android.graphics.Color;

/**
 * Created by Jonás on 09/11/2015.
 */
public class Vinos {

    public int icon;
    public String title;
    public int color;

    public Vinos(int icon, String title, int color) {
        super();
        this.icon = icon;
        this.title = title;
        this.color = color;
    }

    public Vinos() {
        super();
    }

    public void set_title(String t){
        this.title = t;
    }
    public void set_icon(int i){
        this.icon = i;
    }

    public String get_title(){
        return this.title;
    }
    public int get_icon(){
        return this.icon;
    }

    public void clone_vino(Vinos v){
        this.icon = v.icon;
        this.title = v.title;
    }

}

