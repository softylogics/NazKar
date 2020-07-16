package com.softylogics.nazkar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.softylogics.nazkar.adslist.DummyData;

import java.util.ArrayList;

public class CustomListViewAdapter extends ArrayAdapter<DummyData> {

    private class ViewHolder {
        TextView txtvwName;
        TextView txtvwlocation;
        TextView txtvwprice;
        ImageView picanimal;
    }

    Context c;
    ArrayList<DummyData> list;
    public CustomListViewAdapter(Context context, ArrayList<DummyData> list) {
        super(context, R.layout.listview_item);
        this.c = context;
        this.list = list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder holder = new ViewHolder();
        LayoutInflater inflator = LayoutInflater.from(getContext());
        convertView = inflator.inflate( R.layout.listview_item, parent, false);
        holder.picanimal = convertView.findViewById(R.id.imageadlistview);
        holder.txtvwlocation = convertView.findViewById(R.id.locationtxtlistview);
        holder.txtvwName = convertView.findViewById(R.id.nametxtlistview);
        holder.txtvwprice = convertView.findViewById(R.id.pricetxtlistview);

        holder.txtvwName.setText(list.get(position).getTitle());
        holder.txtvwprice.setText(list.get(position).getPrice());
        holder.txtvwlocation.setText(list.get(position).getLocation());
        holder.picanimal.setImageBitmap(list.get(position).getImage());
        holder.picanimal.setClipToOutline(true);

        return super.getView(position, convertView, parent);
    }



}
