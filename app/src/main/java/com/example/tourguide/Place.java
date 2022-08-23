package com.example.tourguide;

public class Place {
    private String location;
    private String description;
    private int imageTwo;
    private int imageThree;
    private int imageFour;
    private String placeName;
    private String placeType;
    private String visitingTime;
    private int mainPlaceImage;

    public int getImageTwo() {
        return imageTwo;
    }

    public int getImageThree() {
        return imageThree;
    }

    public int getImageFour() {
        return imageFour;
    }

    public String getVisitingTime() {
        return visitingTime;
    }

    public String getLocation() {
        return location;
    }

    public String getDescription() {
        return description;
    }

    public int getMainPlaceImage() {
        return mainPlaceImage;
    }

    public String getPlaceName() {
        return placeName;
    }

    public String getPlaceType() {
        return placeType;
    }

    public Place(int mainImage, int imageTwo, int imageThree, int imageFour,
                 String placeName, String placeType, String visitingTime,
                 String location, String description) {
        this.mainPlaceImage = mainImage;
        this.imageTwo = imageTwo;
        this.imageThree = imageThree;
        this.imageFour = imageFour;
        this.placeName = placeName;
        this.placeType = placeType;
        this.visitingTime = visitingTime;
        this.location = location;
        this.description = description;
    }
}
