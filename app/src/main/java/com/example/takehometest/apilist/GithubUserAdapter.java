package com.example.takehometest.apilist;

import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.takehometest.R;

import io.realm.OrderedRealmCollection;
import io.realm.RealmRecyclerViewAdapter;

/**
 * Created by 서대원 on 2017-04-13.
 */

public class GithubUserAdapter extends RealmRecyclerViewAdapter<GithubUser, GithubUserAdapter.GithubUserViewHolder> {

    public GithubUserAdapter(@Nullable OrderedRealmCollection<GithubUser> data, boolean autoUpdate) {
        super(data, autoUpdate);
    }

    @Override
    public GithubUserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerviewitem_githubuser_layout, parent, false);
        return new GithubUserViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(GithubUserViewHolder holder, int position) {
        final GithubUser githubUser = getItem(position);
        holder.txtViewLogin.setText(githubUser.getLogin());
    }

    class GithubUserViewHolder extends RecyclerView.ViewHolder {
        TextView txtViewLogin;
        public GithubUserViewHolder(View view) {
            super(view);
            txtViewLogin = (TextView) view.findViewById(R.id.txtViewLogin);
        }
    }
}
