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


public class HotelsFragment extends Fragment implements RecyclerItemClickListener {

    ArrayList<Place> hotelsList;
    PlacesRecyclerAdapter hotelsAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_hotels, container, false);
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        hotelsList = new ArrayList<Place>();
        hotelsList.add(new Place(R.drawable.bn_main_image, R.drawable.bn_image2, R.drawable.bn_image3, R.drawable.bn_image4,
                getString(R.string.hotels_name1), getString(R.string.hotels_type1), getString(R.string.hotels_visiting_time1),
                getString(R.string.hotels_location1), getString(R.string.hotels_des1)));
        hotelsList.add(new Place(R.drawable.clean_hotel_main_image, R.drawable.clean_hotel_image2, R.drawable.clean_hotel_image3, R.drawable.clean_hotel_image4,
                getString(R.string.hotels_name2), getString(R.string.hotels_type2), getString(R.string.hotels_visiting_time2),
                getString(R.string.hotels_location2), getString(R.string.hotels_des2)));
        hotelsList.add(new Place(R.drawable.kt_main_image, R.drawable.kt_image2, R.drawable.kt_image3, R.drawable.kt_image4,
                getString(R.string.hotels_name3), getString(R.string.hotels_type3), getString(R.string.hotels_visiting_time3),
                getString(R.string.hotels_location3), getString(R.string.hotels_des3)));
        hotelsList.add(new Place(R.drawable.ville_des_roses_main_image, R.drawable.ville_des_roses_image2, R.drawable.ville_des_roses_image3, R.drawable.ville_des_roses_image4,
                getString(R.string.hotels_name4), getString(R.string.hotels_type4), getString(R.string.hotels_visiting_time4),
                getString(R.string.hotels_location4), getString(R.string.hotels_des4)));

        hotelsAdapter = new PlacesRecyclerAdapter(hotelsList, this);
        RecyclerView recyclerView = (RecyclerView) requireView().findViewById(R.id.hotels_recycler);
        RecyclerView.LayoutManager lm = new LinearLayoutManager(this.getContext());
        recyclerView.setLayoutManager(lm);
        recyclerView.setAdapter(hotelsAdapter);
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