package com.aleenaadil.project;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.MyViewHolder>{
    private Context context;
    private ArrayList<NewsFlash> News;

    public NewsAdapter(Context context, ArrayList news) {
        this.context = context;
        this.News = news;
    }

    public void adapFilterList(ArrayList<NewsFlash> filterList) {
        News = filterList;
        notifyDataSetChanged();
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.news_entry, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.news_title.setText(News.get(position).getTitle());
        holder.news_description.setText(News.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return News.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView news_title;
        TextView news_description;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            news_title = itemView.findViewById(R.id.news_title);
            news_description = itemView.findViewById(R.id.news_description);
        }
    }
}
