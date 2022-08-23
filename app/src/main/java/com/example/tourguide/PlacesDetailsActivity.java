package com.example.tourguide;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;

public class PlacesDetailsActivity extends AppCompatActivity {
    int mainImage;
    int imageTwo;
    int imageThree;
    int imageFour;
    String placeName;
    String placeType;
    String visitingTime;
    String location;
    String description;
    ImageSlider imageSlider;
    TextView placeNameTextView;
    TextView placeTypeTextView;
    TextView visitingTimeTextview;
    TextView locationTextView;
    TextView descriptionTextView;
    ArrayList<SlideModel> images = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_places_details);

        imageSlider = findViewById(R.id.image_slider);
        placeNameTextView = findViewById(R.id.place_name_detailed);
        placeTypeTextView = findViewById(R.id.place_type_detailed);
        visitingTimeTextview = findViewById(R.id.visiting_time_text);
        locationTextView = findViewById(R.id.location_text_detailed);
        descriptionTextView = findViewById(R.id.description);

        Intent intent = getIntent();
        mainImage = intent.getIntExtra("mainPlaceImage", 0);
        imageTwo = intent.getIntExtra("imageTwo", 0);
        imageThree = intent.getIntExtra("imageThree", 0);
        imageFour = intent.getIntExtra("imageFour", 0);
        placeName = intent.getStringExtra("placeName");
        placeType = intent.getStringExtra("placeType");
        visitingTime = intent.getStringExtra("visitingTime");
        location = intent.getStringExtra("location");
        description = intent.getStringExtra("description");

        images.add(new SlideModel(mainImage, null));
        images.add(new SlideModel(imageTwo, null));
        images.add(new SlideModel(imageThree, null));
        images.add(new SlideModel(imageFour, null));

        imageSlider.setImageList(images, ScaleTypes.CENTER_CROP);
        placeNameTextView.setText(placeName);
        placeTypeTextView.setText(placeType);
        visitingTimeTextview.setText(visitingTime);
        locationTextView.setText(location);
        descriptionTextView.setText(description);
    }
}