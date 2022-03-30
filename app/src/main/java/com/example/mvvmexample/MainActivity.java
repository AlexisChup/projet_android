package com.example.projetandroid;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

<<<<<<< Updated upstream:app/src/main/java/com/example/mvvmexample/MainActivity.java
import com.example.mvvmexample.databinding.ActivityMainBinding;
import com.example.mvvmexample.viewmodels.IViewModel;
import com.example.mvvmexample.viewmodels.RetrofitViewModel;
=======
import com.example.projetandroid.databinding.ActivityMainBinding;
import com.example.projetandroid.viewmodels.IViewModel;
import com.example.projetandroid.viewmodels.RetrofitViewModel;
>>>>>>> Stashed changes:app/src/main/java/com/example/projetandroid/MainActivity.java

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

        binding.nextValueButton.setOnClickListener(v -> viewModel.generateNextValue());
    }

    @Override
    protected void onResume() {
        super.onResume();
        viewModel.getData().observe(this, sampleModel -> {

        });

        cryptoList = new ArrayList<Crypto>();

        cryptoList.add(new Crypto("Btc", "47000"));
        cryptoList.add(new Crypto("Eth", "4200"));

        customAdapter = new CustomAdapter((cryptoList));

        binding.myRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        binding.myRecyclerView.setAdapter(customAdapter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        viewModel.getData().removeObservers(this);
    }
}