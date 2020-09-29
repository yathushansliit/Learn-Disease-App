package com.example.learndiseaseapp.Model;

public class Diseases {
    private String Name;
    private String Image;
    private String Description;
    private String Symptoms;

    public Diseases() {
    }

    public Diseases(String name, String image, String description,String symptoms) {
        Name = name;
        Image = image;
        Description = description;
        Symptoms = symptoms;

    }
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }
    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getSymptoms() {
        return Symptoms;
    }

    public void setSymptoms(String symptoms) {
        Symptoms = symptoms;
    }
}
