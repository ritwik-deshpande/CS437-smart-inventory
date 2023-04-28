package com.example.cs437;


import android.content.Context;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class FoodItemAdapter extends RecyclerView.Adapter<FoodItemAdapter.MyViewHolder>{

    String TAG="RecyclerView";
    private ArrayList<FoodItem> foodItems= new ArrayList<>();
    Context context;

    public FoodItemAdapter(ArrayList<FoodItem> foodItems, Context context) {
        this.foodItems = foodItems;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v;
        v = LayoutInflater.from(context).inflate(R.layout.food_item, viewGroup,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, final int i) {
        Log.d(TAG,"Setting my View holder");

        byte[] imageByteArray = Base64.decode(foodItems.get(i).getFoodImage(), Base64.DEFAULT);

        Glide.with(context).asBitmap().load(imageByteArray).into(myViewHolder.image);
        myViewHolder.name.setText(foodItems.get(i).getName());
        myViewHolder.expiry.setText(String.valueOf(foodItems.get(i).getExpiry()));
        myViewHolder.add_date.setText(String.valueOf(foodItems.get(i).getAddDate()));

    }

    @Override
    public int getItemCount() {
        return foodItems.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        CircleImageView image;
        TextView name;
        TextView expiry;
        TextView add_date;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            image=(CircleImageView) itemView.findViewById(R.id.fruit_image);
            name= itemView.findViewById(R.id.fruit_name);
            expiry= itemView.findViewById(R.id.expiry_date);
            add_date = itemView.findViewById(R.id.add_date);
        }
    }

}