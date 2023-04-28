package com.aleenaadil.project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.SearchView;

import java.util.ArrayList;

public class NewsPage extends AppCompatActivity {
    ImageButton back2;
    RecyclerView recyclerView;
    NewsAdapter newsAdapter;
    ArrayList<NewsFlash> news;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_page);

        back2= (ImageButton)findViewById(R.id.back2);

        back2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),Home.class);
                startActivity(i);
            }
        });

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        news = new ArrayList<>();
        SQLDBHelper db = new SQLDBHelper(this);
        news = db.getAllNews();
        newsAdapter = new NewsAdapter(this, news);
        recyclerView.setAdapter(newsAdapter);

        SearchView searchView = findViewById(R.id.searchView);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterList(newText);
                return false;
            }
        });
    }

    private void filterList(String newText) {
        ArrayList<NewsFlash> filteredList = new ArrayList<>();
        for (NewsFlash s : news) {
            if (s.getTitle().toLowerCase().contains(newText.toLowerCase()) || s.getDescription().toLowerCase().contains(newText.toLowerCase())) {
                filteredList.add(s);
            }
        }
        newsAdapter.adapFilterList(filteredList);
    }
}