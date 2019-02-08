/*
 * *
 *  * Created by Arslan on 2/9/19 4:37 AM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 2/9/19 4:14 AM
 *
 */

package com.example.telenorassignmentapp.Models;



//-----------------------------------com.example.telenorassignmentapp.PersonModel.java-----------------------------------


        import org.parceler.Parcel;

        import java.util.List;

@Parcel
public class PeopleModel {

    private String id;
    private String name;
    private String gender;
    private String age;
    private String eye_color;
    private String hair_color;
    private List<String> films = null;
    private String species;
    private String url;
//    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEye_color() {
        return eye_color;
    }

    public void setEye_color(String eye_color) {
        this.eye_color = eye_color;
    }

    public String getHair_color() {
        return hair_color;
    }

    public void setHair_color(String hair_color) {
        this.hair_color = hair_color;
    }

    public List<String> getFilms() {
        return films;
    }

    public void setFilms(List<String> films) {
        this.films = films;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

//    public Map<String, Object> getAdditionalProperties() {
//        return this.additionalProperties;
//    }
//
//    public void setAdditionalProperty(String name, Object value) {
//        this.additionalProperties.put(name, value);
//    }

}
