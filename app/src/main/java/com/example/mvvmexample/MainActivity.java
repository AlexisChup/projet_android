package com.example.mvvmexample;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.mvvmexample.databinding.ActivityMainBinding;
import com.example.mvvmexample.models.CoinsData;
import com.example.mvvmexample.viewmodels.IViewModel;
import com.example.mvvmexample.viewmodels.RetrofitViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private IViewModel viewModel;
    private CustomAdapter customAdapter;
    private CoinsData coinsData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        viewModel = new ViewModelProvider(this).get(RetrofitViewModel.class);

        binding.nextValueButton.setOnClickListener(v -> viewModel.generateNextValue());
        viewModel.fetch10FirstCrypto();
    }

    @Override
    protected void onResume() {
        super.onResume();
        viewModel.getData().observe(this, sampleModel -> {
            binding.dataTextView.setText(sampleModel.getData());
        });

        viewModel.getCoinsData().observe(this, coinsData -> {
                    customAdapter = new CustomAdapter(coinsData.getCoinList());
        });

        binding.myRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        binding.myRecyclerView.setAdapter(customAdapter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        viewModel.getData().removeObservers(this);
    }
}