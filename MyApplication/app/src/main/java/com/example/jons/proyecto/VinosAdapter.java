package com.example.jons.proyecto;

/**
 * Created by Jonás on 09/11/2015.
 */
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Jonás on 06/10/2015.
 */
public class VinosAdapter extends ArrayAdapter<Vinos> {

    Context context;
    int LayoutResortId;
    ArrayList<Vinos> data = null;

    public VinosAdapter(Context context, int layoutResortId,  ArrayList<Vinos> data) {
        super(context, layoutResortId,data);

        this.context= context;
        this.LayoutResortId= layoutResortId;
        this.data = data;

    }

    public View getView(int position, View contentView, ViewGroup parent){
        View row= contentView;
        VinosHolder holder = null;

        if(row==null){
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row= inflater.inflate(LayoutResortId, parent, false);

            holder= new VinosHolder();
            holder.imagen= (ImageView) row.findViewById(R.id.imagen);
            holder.texto = (TextView) row.findViewById((R.id.tv));
            holder.principal = (LinearLayout) row.findViewById(R.id.principal);
            row.setTag(holder);
        }
        else{
            holder= (VinosHolder) row.getTag();
        }

        Vinos bandas = data.get(position);
        holder.texto.setText(bandas.title);
        holder.imagen.setImageResource(bandas.icon);
        holder.principal.setBackgroundColor(bandas.color);


        return row;
    }

    static class VinosHolder{
        ImageView imagen;
        TextView texto;
        LinearLayout principal;
    }
}

