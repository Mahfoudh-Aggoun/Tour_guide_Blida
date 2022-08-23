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

public class RestaurantsFragment extends Fragment implements RecyclerItemClickListener {
    ArrayList<Place> restaurantsList;
    PlacesRecyclerAdapter restaurantsAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_restaurants, container, false);
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        restaurantsList = new ArrayList<Place>();
        restaurantsList.add(new Place(R.drawable.cine_main_image, R.drawable.cine_image2, R.drawable.cine_image3, R.drawable.cine_image4,
                getString(R.string.resto_name1), getString(R.string.resto_type1), getString(R.string.resto_visiting_time1),
                getString(R.string.resto_location1), getString(R.string.resto_des1)));
        restaurantsList.add(new Place(R.drawable.chicken_main_image, R.drawable.chicken_image2, R.drawable.chicken_image3, R.drawable.chicken_image4,
                getString(R.string.resto_name2), getString(R.string.resto_type2), getString(R.string.resto_visiting_time2),
                getString(R.string.resto_location2), getString(R.string.resto_des2)));
        restaurantsList.add(new Place(R.drawable.lartisto_main_image, R.drawable.lartisto_image2, R.drawable.lartisto_image3, R.drawable.lartisto_image4,
                getString(R.string.resto_name3), getString(R.string.resto_type3), getString(R.string.resto_visiting_time3),
                getString(R.string.resto_location3), getString(R.string.resto_des3)));
        restaurantsList.add(new Place(R.drawable.venezia_main_image, R.drawable.venezia_image2, R.drawable.venezia_image3, R.drawable.venezia_image4,
                getString(R.string.resto_name4), getString(R.string.resto_type4), getString(R.string.resto_visiting_time4),
                getString(R.string.resto_location4), getString(R.string.resto_des4)));

        restaurantsAdapter = new PlacesRecyclerAdapter(restaurantsList, this);
        RecyclerView recyclerView = (RecyclerView) requireView().findViewById(R.id.restaurant_recycler);
        RecyclerView.LayoutManager lm = new LinearLayoutManager(this.getContext());
        recyclerView.setLayoutManager(lm);
        recyclerView.setAdapter(restaurantsAdapter);
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