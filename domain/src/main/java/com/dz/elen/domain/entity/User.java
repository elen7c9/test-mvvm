package com.dz.elen.domain.entity;

public class User implements DomainModel{

    private String firsname;
    private String surname;
    private Gender gender;
    private String imageUrl;

    public User(String firsname, String surname, Gender gender, String imageUrl) {
        this.firsname = firsname;
        this.surname = surname;
        this.gender = gender;
        this.imageUrl = imageUrl;
    }

    public String getFirsname() {
        return firsname;
    }

    public String getSurname() {
        return surname;
    }

    public Gender getGender() {
        return gender;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
