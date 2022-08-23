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


public class HistoryFragment extends Fragment implements RecyclerItemClickListener {
    ArrayList<Place> historicalPlacesList;
    PlacesRecyclerAdapter historicalPlacesAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_history, container, false);
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        historicalPlacesList = new ArrayList<Place>();
        historicalPlacesList.add(new Place(R.drawable.sidi_main_image, R.drawable.sidi_image2, R.drawable.sidi_image3, R.drawable.sidi_image4,
                getString(R.string.hisorical_name1), getString(R.string.historical_type1), getString(R.string.historical_visit_time1),
                getString(R.string.historical_location1), getString(R.string.historical_des1)));
        historicalPlacesList.add(new Place(R.drawable.ibn_saadoun_main_image, R.drawable.ibn_saadoun_image2, R.drawable.ibn_saadoun_image3, R.drawable.ibn_saadoun_image4,
                getString(R.string.historical_name2), getString(R.string.historical_type2), getString(R.string.historical_visit_time2),
                getString(R.string.historical_location2), getString(R.string.historical_des2)));
        historicalPlacesList.add(new Place(R.drawable.douirette_main_image, R.drawable.douirette_image2, R.drawable.douirette_image3, R.drawable.douirette_image4,
                getString(R.string.historical_name3), getString(R.string.historical_type3), getString(R.string.historical_visiting_time3),
                getString(R.string.historical_location3), getString(R.string.historical_des3)));
        historicalPlacesList.add(new Place(R.drawable.jardin_main_image, R.drawable.jardin_image2, R.drawable.jardin_image3, R.drawable.jardin_image4,
                getString(R.string.historical_name4), getString(R.string.historical_type4), getString(R.string.historical_visiting_time4),
                getString(R.string.historical_location4), getString(R.string.historical_des4)));

        historicalPlacesAdapter = new PlacesRecyclerAdapter(historicalPlacesList, this);
        RecyclerView recyclerView = (RecyclerView) requireView().findViewById(R.id.historical_recycler);
        RecyclerView.LayoutManager lm = new LinearLayoutManager(this.getContext());
        recyclerView.setLayoutManager(lm);
        recyclerView.setAdapter(historicalPlacesAdapter);
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