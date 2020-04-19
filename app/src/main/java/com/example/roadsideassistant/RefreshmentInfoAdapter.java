package com.example.roadsideassistant;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class RefreshmentInfoAdapter extends ArrayAdapter<Refreshments>{
    private Activity context;
    private List<Refreshments>refreshmentsList;

    public RefreshmentInfoAdapter(Activity context,List<Refreshments>refreshmentsList){
        super(context,R.layout.list_view,refreshmentsList);
        this.context = context;
        this.refreshmentsList = refreshmentsList;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listView = inflater.inflate(R.layout.list_view,null,true);

        TextView refreshmentName = (TextView)listView.findViewById(R.id.textViewName);
        TextView refreshmentAddress = (TextView)listView.findViewById(R.id.textViewAddress);

        Refreshments refreshments = refreshmentsList.get(position);
        refreshmentName.setText(refreshments.getRefreshmentname());
        refreshmentAddress.setText((refreshments.getRefreshmentcity()));
        return listView;
    }
}
