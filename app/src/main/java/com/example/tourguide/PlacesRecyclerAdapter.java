package com.example.tourguide;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class PlacesRecyclerAdapter extends RecyclerView.Adapter<PlacesRecyclerAdapter.MyViewHolder> {

    ArrayList<Place> placesList;
    RecyclerItemClickListener mListener;

    public PlacesRecyclerAdapter(ArrayList<Place> placesList, RecyclerItemClickListener listener) {
        this.placesList = placesList;
        this.mListener = listener;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public MyViewHolder(View itemView) {
            super(itemView);
            itemFrame.setOnClickListener(this);
        }
        ImageView placeImage = itemView.findViewById(R.id.place_image);
        TextView placeName = itemView.findViewById(R.id.place_name);
        TextView placeType = itemView.findViewById(R.id.place_type);
        RelativeLayout itemFrame = itemView.findViewById(R.id.item_frame);

        @Override
        public void onClick(View v) {
            if (v == itemFrame) {
                int position = getAdapterPosition();
                Place currentPlace = placesList.get(position);
                mListener.onItemClick(currentPlace);
            }
        }
    }

    @NonNull
    @NotNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.places_item, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull MyViewHolder holder, int position) {
        Place currentPlace = placesList.get(position);
        holder.placeImage.setImageResource(currentPlace.getMainPlaceImage());
        holder.placeName.setText(currentPlace.getPlaceName());
        holder.placeType.setText(currentPlace.getPlaceType());
    }

    @Override
    public int getItemCount() {
        return placesList.size();
    }
}
