package com.cap.seattlegetready;


public class Maps {
    private int id;
    private String title;
    private String locahubs;
    private int hubs;
    private String city;
    private int image;

    public Maps(int id, String title, String locahubz, int hubz, String cityz, int image) {
        this.id = id;
        this.title = title;
        this.locahubs = locahubz;
        this.hubs = hubz;
        this.city = cityz;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getLocahubs() {
        return locahubs;
    }

    public int getHubs() {
        return hubs;
    }

    public String getCity() {
        return city;
    }

    public int getImage() {
        return image;
    }
}