package com.example.acer.gunungtertinggidiindonesia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvMountain;
    private ArrayList<Mountain> list = new ArrayList<>();

    private String title = "Gunung Tertinggi";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setActionBarTitle(title);

        rvMountain = findViewById(R.id.rv_mountain);
        rvMountain.setHasFixedSize(true);

        list.addAll(MountainData.getListData());
        showRecycleList();
    }

    private void showRecycleList() {
        rvMountain.setLayoutManager(new LinearLayoutManager(this));
        ListMountainAdapter listMountainAdapter = new ListMountainAdapter(list);
        rvMountain.setAdapter(listMountainAdapter);

        listMountainAdapter.setOnItemClickCallback(new ListMountainAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Mountain mountain) {
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra("Mountain", mountain);
                startActivity(intent);
            }
        });

    }

    private void setActionBarTitle(String title) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_name) {
            Intent moveAbout = new Intent(MainActivity.this, About.class);
            startActivity(moveAbout);
        }
        return super.onOptionsItemSelected(item);
    }
}
