package com.example.windows.wilayahindonesia.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.windows.wilayahindonesia.Model.ModelProvinsi;
import com.example.windows.wilayahindonesia.R;

import java.util.ArrayList;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {

    private ArrayList<ModelProvinsi> modelProvinsiArrayList;

    public DataAdapter(ArrayList<ModelProvinsi> modelProvinsiArrayList) {
        this.modelProvinsiArrayList = modelProvinsiArrayList;
    }

    @NonNull
    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_wilayah, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DataAdapter.ViewHolder viewHolder, int i) {

        viewHolder.tv_id.setText(modelProvinsiArrayList.get(i).getId());
        viewHolder.tv_name.setText(modelProvinsiArrayList.get(i).getName());
    }

    @Override
    public int getItemCount() {
        return modelProvinsiArrayList.size();
    }

    public ArrayList<ModelProvinsi> getModelProvinsiArrayList() {
        return modelProvinsiArrayList;
    }

    public void setModelProvinsiArrayList(ArrayList<ModelProvinsi> modelProvinsiArrayList) {
        this.modelProvinsiArrayList = modelProvinsiArrayList;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tv_id;
        private TextView tv_name;

        public ViewHolder(View view) {
            super(view);

            tv_id = (TextView) view.findViewById(R.id.tv_id);
            tv_name = (TextView) view.findViewById(R.id.tv_name);

        }
    }
}
