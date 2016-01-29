package com.commit451.adapterlayout.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.commit451.adapterlayout.AdapterLinearLayout;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.adapter_layout) AdapterLinearLayout mAdapterLinearLayout;
    CheeseAdapter mAdapter;

    @OnClick(R.id.add_cheese)
    void onAddCheeseClicked() {
        mAdapter.add(Cheeses.getRandomCheese());
    }

    @OnClick(R.id.remove_cheese)
    void onRemoveCheeseClicked() {
        mAdapter.removeLast();
    }

    @OnClick(R.id.remove_middle)
    void onRemoveMiddleClicked() {
        mAdapter.removeMiddle();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mAdapter = new CheeseAdapter(this, new CheeseAdapter.Listener() {
            @Override
            public void onItemClicked(Cheese cheese) {
                Toast.makeText(MainActivity.this, "Clicked", Toast.LENGTH_SHORT).show();
            }
        });
        mAdapterLinearLayout.setAdapter(mAdapter);
    }
}
