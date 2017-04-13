package com.example.takehometest.maskinglist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import com.example.takehometest.R;

import java.util.ArrayList;

public class MaskingActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private MaskingAdapter adapter;
    private ArrayList<CardItem> items;
    private EditText editTextCommentInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_masking);

        layoutManager = new LinearLayoutManager(this);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerViewComment);
        recyclerView.setLayoutManager(layoutManager);

        items = new ArrayList<>();

        // Sample Data 입니다.
        items.add(new CardItem("서대원 입니다 test 1"));
        items.add(new CardItem("서대원 입니다 test 2"));
        items.add(new CardItem("서대원 입니다 test 3"));
        items.add(new CardItem("서대원 입니다 test 4"));
        items.add(new CardItem("서대원 입니다 test 5"));

        adapter = new MaskingAdapter(items);
        recyclerView.setAdapter(adapter);

        editTextCommentInput = (EditText) findViewById(R.id.editTextCommentInput);
        editTextCommentInput.setImeOptions(EditorInfo.IME_ACTION_DONE);
        editTextCommentInput.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    inputComment(v.getText().toString());
                    v.setText(null);
                }
                return false;
            }
        });
    }

    private void inputComment(String comment) {
        if (items == null) {
            items = new ArrayList<>();
        }

        items.add(new CardItem(comment));
    }
}
