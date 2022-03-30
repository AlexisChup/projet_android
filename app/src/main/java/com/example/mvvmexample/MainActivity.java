package com.example.mvvmexample;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.mvvmexample.databinding.ActivityMainBinding;
import com.example.mvvmexample.viewmodels.IViewModel;
import com.example.mvvmexample.viewmodels.RetrofitViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private IViewModel viewModel;
    private CustomAdapter customAdapter;
    private List<Crypto> cryptoList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        viewModel = new ViewModelProvider(this).get(RetrofitViewModel.class);

    }

    @Override
    protected void onResume() {
        super.onResume();
        viewModel.getData().observe(this, sampleModel -> {

        });

        cryptoList = new ArrayList<Crypto>();

        cryptoList.add(new Crypto("Btc", "47000"));
        cryptoList.add(new Crypto("Eth", "4200"));
        cryptoList.add(new Crypto("Eth", "4200"));
        cryptoList.add(new Crypto("Eth", "4200"));
        cryptoList.add(new Crypto("Eth", "4200"));
        cryptoList.add(new Crypto("Eth", "4200"));

        customAdapter = new CustomAdapter(cryptoList);

        binding.myRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        binding.myRecyclerView.setAdapter(customAdapter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        viewModel.getData().removeObservers(this);
    }
}