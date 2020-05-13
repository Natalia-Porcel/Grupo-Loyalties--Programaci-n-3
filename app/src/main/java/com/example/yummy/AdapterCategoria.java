package com.example.yummy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class AdapterCategoria extends BaseAdapter {
    Context context;


    public AdapterCategoria(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return Categorias.ITEMS.length;
    }

    @Override
    public Object getItem(int position) {
        return Categorias.ITEMS[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.grid_item, parent, false);
        }

        ImageView imagenCategory = (ImageView) convertView.findViewById(R.id.imagenCate);
        TextView nombreCategory = (TextView) convertView.findViewById(R.id.nombreCate);

        final Categorias item = (Categorias) getItem(position);
        imagenCategory.setImageResource(item.getImagenCategoria());
        nombreCategory.setText(item.getCategoria());

        return convertView;
    }
}
