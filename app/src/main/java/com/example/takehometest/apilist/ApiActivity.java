package com.example.takehometest.apilist;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.widget.TextView;

import com.example.takehometest.R;

import java.io.IOException;
import java.util.List;

import io.realm.Realm;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import static com.example.takehometest.apilist.GithubService.retrofit;

public class ApiActivity extends AppCompatActivity {

    private Realm realm;
    private RecyclerView recyclerView;
//    private Menu menu;
    private GithubUserAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_api);
        realm = Realm.getDefaultInstance();
        recyclerView = (RecyclerView) findViewById(R.id.recyclerViewGithubUsers);
        setUpRecyclerView();
        setGithubUsers();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        recyclerView.setAdapter(null);
        realm.close();
    }

    private void setUpRecyclerView() {
        adapter = new GithubUserAdapter(realm.where(GithubUser.class).findAll(), true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
    }

    private void setGithubUsers() {
        GithubService gitHubService = retrofit.create(GithubService.class);
        Call<List<GithubUser>> call = gitHubService.getGithubUsers();
        new NetworkCall().execute(call);
    }

    private class NetworkCall extends AsyncTask<Call, Void, String> {
        @Override
        protected String doInBackground(Call[] params) {
            try {
                Call<List<GithubUser>> call = params[0];
                Response<List<GithubUser>> response = call.execute();
                return response.body().toString();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String result) {

        }
    }
}
