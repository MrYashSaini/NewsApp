package com.example.ysnews.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.ysnews.Apis.ModelClass;
import com.example.ysnews.FullNewsActivity;
import com.example.ysnews.R;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    Context context;
    ArrayList<ModelClass> modelClassesArrayList;

    public Adapter(Context context, ArrayList<ModelClass> modelClassesArrayList) {
        this.context = context;
        this.modelClassesArrayList = modelClassesArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_iteam,null,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.cardView.setOnClickListener(view -> {
            Intent intent = new Intent(context, FullNewsActivity.class);
            intent.putExtra("url",modelClassesArrayList.get(position).getUrl());
            context.startActivity(intent);
        });
        holder.time.setText("Published At:-"+modelClassesArrayList.get(position).getPublishedAt());
        holder.author.setText(modelClassesArrayList.get(position).getAuthor());
        holder.heading.setText(modelClassesArrayList.get(position).getTitle());
        holder.content.setText(modelClassesArrayList.get(position).getDescription());
        Glide.with(context).load(modelClassesArrayList.get(position).getUrlToImage()).into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return modelClassesArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView heading,content,author,time;
        CardView cardView;
        ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            heading = itemView.findViewById(R.id.mainheading);
            content = itemView.findViewById(R.id.content);
            author = itemView.findViewById(R.id.author);
            time = itemView.findViewById(R.id.time);
            cardView = itemView.findViewById(R.id.cardView );
            imageView = itemView.findViewById(R.id.imageview);
        }
    }
}
