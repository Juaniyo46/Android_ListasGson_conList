package com.example.ejerciciolistas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

class SitiosAdapter extends ArrayAdapter<Sitio> {

    public SitiosAdapter(Context context, List<Sitio> objects){
        super(context, 0, objects);
    }

    public View getView(int position, View convertView, ViewGroup parent ) {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (null == convertView) {
            convertView = inflater.inflate(R.layout.list_item, parent, false);
        }

        TextView sitio = convertView.findViewById(R.id.inserccion);

        Sitio item = getItem(position);

        sitio.setText(item.getSitio());

        return convertView;
    }

}
