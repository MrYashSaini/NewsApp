package com.example.ysnews.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ysnews.Adapter.Adapter;
import com.example.ysnews.Apis.ApiUtilities;
import com.example.ysnews.Apis.ModelClass;
import com.example.ysnews.Apis.mainNews;
import com.example.ysnews.CountryActivity;
import com.example.ysnews.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EntertainmentFragment extends Fragment {
    String apikey="0510487bbbe34398af0368fb5c2512f0";
    ArrayList<ModelClass> modelClassArrayList;
    Adapter adapter;
    String country = "in";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_entertainment, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerViewOfEntertainment);
        modelClassArrayList= new ArrayList<>();
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new Adapter(getContext(),modelClassArrayList);
        recyclerView.setAdapter(adapter);

        findNews();
        return view;
    }
    private void findNews() {
        CountryActivity countryActivity = new CountryActivity();
        country = countryActivity.getCNames();
        ApiUtilities.getApiInterface().getCategoryNews(country,"entertainment",100,apikey).enqueue(new Callback<mainNews>() {
            @Override
            public void onResponse(@NonNull Call<mainNews> call, @NonNull Response<mainNews> response) {
                if(response.isSuccessful()){
                    assert response.body() != null;
                    modelClassArrayList.addAll(response.body().getArticles());
                    adapter.notifyDataSetChanged();

                }
            }

            @Override
            public void onFailure(@NonNull Call<mainNews> call, @NonNull Throwable t) {}
        });
    }
}