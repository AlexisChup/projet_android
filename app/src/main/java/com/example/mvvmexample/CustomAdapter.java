package com.example.mvvmexample;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private List<Crypto> cryptoList;

    public CustomAdapter(List<Crypto> cryptoList){
        this.cryptoList = cryptoList;
    }

    @NonNull
    @Override
    public CustomAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.text_row_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.MyViewHolder holder, int position) {
        holder.display(cryptoList.get(position));
    }

    @Override
    public int getItemCount() { return cryptoList.size(); }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView mName;
        private TextView mPrice;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            mName = itemView.findViewById(R.id.textViewName);
            mPrice = itemView.findViewById(R.id.textViewPrice);
        }

        public void display(Crypto cryptoList){
            mName.setText(cryptoList.getCryptoName());
            mPrice.setText(cryptoList.getCryptoPrice());
        }
    }
}
