package com.example.kyrsovaya2;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterRecyclerView extends RecyclerView.Adapter<AdapterRecyclerView.ViewHolder>{
    private final LayoutInflater inflater;
    private final List<Item> items;

    AdapterRecyclerView(Context context, List<Item> items) {
        this.items = items;
        this.inflater = LayoutInflater.from(context);
    }
    @Override
    public AdapterRecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.it_i, parent, false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(AdapterRecyclerView.ViewHolder holder, int position) {
        Item item = items.get(position);
        holder.textView.setText(item.getText());

        holder.textView.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(
                        inflater.getContext(),
                        (String)holder.textView.getText(),
                        Toast.LENGTH_SHORT).show();
                Log.d("onBindViewHolder", (String)holder.textView.getText());
            }
        });
    }
    @Override
    public int getItemCount() {
        return items.size();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        final TextView textView;
        ViewHolder(View view){
            super(view);
            textView = view.findViewById(R.id.TextViewList);
        }
    }
}
