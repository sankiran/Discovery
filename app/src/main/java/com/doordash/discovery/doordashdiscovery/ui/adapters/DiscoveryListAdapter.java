package com.doordash.discovery.doordashdiscovery.ui.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.doordash.discovery.doordashdiscovery.R;
import com.doordash.discovery.doordashdiscovery.model.Restaurant;
import com.squareup.picasso.Picasso;

import java.util.List;

public class DiscoveryListAdapter extends RecyclerView.Adapter<DiscoveryListAdapter.RestaurantItemViewHolder> {
    private List<Restaurant> mRestaurants;

    public static class RestaurantItemViewHolder extends RecyclerView.ViewHolder {
        public ImageView mImageView;
        public TextView mRestaurantNameTv;
        public TextView mCuisineTv;
        public TextView mDurationTv;

        public RestaurantItemViewHolder(@NonNull View listItemView) {
            super(listItemView);
            mImageView = listItemView.findViewById(R.id.restaurant_image);
            mRestaurantNameTv = listItemView.findViewById(R.id.restaurant_name);
            mCuisineTv = listItemView.findViewById(R.id.restaurant_cuisine);
            mDurationTv = listItemView.findViewById(R.id.restaurant_status);
        }
    }

    public DiscoveryListAdapter(List<Restaurant> restaurantList) {
        mRestaurants = restaurantList;
    }

    @NonNull
    @Override
    public RestaurantItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_restaurant_list_item, viewGroup, false);
        return new RestaurantItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RestaurantItemViewHolder restaurantItemViewHolder, int i) {
        setRestaurantImage(i, restaurantItemViewHolder);
        restaurantItemViewHolder.mRestaurantNameTv.setText(mRestaurants.get(i).getName());
        restaurantItemViewHolder.mCuisineTv.setText(mRestaurants.get(i).getDescription());
        restaurantItemViewHolder.mDurationTv.setText(mRestaurants.get(i).getStatus());
    }

    @Override
    public int getItemCount() {
        return mRestaurants.size();
    }

    private void setRestaurantImage(int position, RestaurantItemViewHolder viewHolder) {
        Picasso.get()
                .load(mRestaurants.get(position).getImageUrl())
                .fit()
                .placeholder(R.drawable.ic_launcher_background)
                .into(viewHolder.mImageView);
    }
}
