package com.example.takehometest.maskinglist;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.takehometest.R;

import java.util.ArrayList;

/**
 * Created by 서대원 on 2017-04-12.
 */

public class MaskingAdapter extends RecyclerView.Adapter<MaskingAdapter.ViewHolder> {

    private ArrayList<CardItem> items;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView txtViewComment;
        public ViewHolder(View view) {
            super(view);
            txtViewComment = (TextView) view.findViewById(R.id.txtViewComment);
        }
    }

    public MaskingAdapter(ArrayList<CardItem> items) {
        this.items = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerviewitem_masking_layout, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.txtViewComment.setText(items.get(position).getComment());
    }

    @Override
    public int getItemCount() {
        return this.items.size();
    }
}
