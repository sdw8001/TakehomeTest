package com.example.takehometest.maskinglist;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by 라라 on 2017-04-12.
 */

public class MaskingAdapter extends RecyclerView.Adapter<MaskingAdapter.ViewHolder> {

    private CardItem[] items;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView txtViewComment;
        public ViewHolder(TextView view) {
            super(view);
            txtViewComment = view;
        }
    }

    public MaskingAdapter(CardItem[] items) {
        this.items = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
        return null;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
