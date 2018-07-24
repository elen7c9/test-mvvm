package com.dz.elen.data.entity;

import com.google.gson.annotations.SerializedName;

public class UserResponse implements DataModel{

    @SerializedName("objectId")
    private String objectId;

    @SerializedName("username")
    private String username;

    @SerializedName("firstname")
    private String firstname;

    @SerializedName("surname")
    private String surname;

    @SerializedName("age")
    private int age;

    @SerializedName("image_url")
    private String imageUrl;

    @SerializedName("created")
    private long created;

    @SerializedName("updated")
    private long updated;

    public String getObjectId() {
        return objectId;
    }

    public String getUsername() {
        return username;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public long getCreated() {
        return created;
    }

    public long getUpdated() {
        return updated;
    }
}
