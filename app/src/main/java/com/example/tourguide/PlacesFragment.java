package com.example.tourguide;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class PlacesFragment extends Fragment implements RecyclerItemClickListener {
    ArrayList<Place> placesList;
    PlacesRecyclerAdapter itemsAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_places, container, false);
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        placesList = new ArrayList<Place>();
        placesList.add(new Place(R.drawable.place_ettoute_gv, R.drawable.place_de_toute2,
                R.drawable.place_ettoute3, R.drawable.place_ettoute4,
                getString(R.string.places_name1), getString(R.string.places_type1), getString(R.string.places_visiting_time1),
                getString(R.string.places_location1), getString(R.string.places_des1)));
        placesList.add(new Place(R.drawable.hamam_melouane, R.drawable.hammam_melouane2, R.drawable.hammam_melouane3,
                R.drawable.hammam_melouane4, getString(R.string.place_name2), getString(R.string.places_type2), getString(R.string.places_visiting_time2),
                getString(R.string.places_location2), getString(R.string.places_des2)));
        placesList.add(new Place(R.drawable.chrea, R.drawable.chrea2, R.drawable.chrea3, R.drawable.chrea4,
                getString(R.string.places_name3), getString(R.string.places_type3), getString(R.string.places_visiting_time3), getString(R.string.places_location3), getString(R.string.places_des3)));
        placesList.add(new Place(R.drawable.cheffa, R.drawable.cheffa2, R.drawable.chrea3, R.drawable.cheffa4,
                getString(R.string.places_name4), getString(R.string.places_type4), getString(R.string.places_visiting_time4), getString(R.string.places_location4),
                getString(R.string.places_des4)));

        itemsAdapter = new PlacesRecyclerAdapter(placesList, this);
        RecyclerView recyclerView = (RecyclerView) requireView().findViewById(R.id.places_recycler);
        RecyclerView.LayoutManager lm = new LinearLayoutManager(this.getContext());
        recyclerView.setLayoutManager(lm);
        recyclerView.setAdapter(itemsAdapter);
    }

    @Override
    public void onItemClick(Place currentPlace) {
        Intent intent = new Intent(getActivity(), PlacesDetailsActivity.class);
        intent.putExtra("mainPlaceImage", currentPlace.getMainPlaceImage());
        intent.putExtra("imageTwo", currentPlace.getImageTwo());
        intent.putExtra("imageThree", currentPlace.getImageThree());
        intent.putExtra("imageFour", currentPlace.getImageFour());
        intent.putExtra("placeName", currentPlace.getPlaceName());
        intent.putExtra("placeType", currentPlace.getPlaceType());
        intent.putExtra("visitingTime", currentPlace.getVisitingTime());
        intent.putExtra("location", currentPlace.getLocation());
        intent.putExtra("description", currentPlace.getDescription());
        startActivity(intent);
    }
}