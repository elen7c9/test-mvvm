package com.dz.elen.data.net;

import com.dz.elen.data.entity.UserResponse;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.Map;

public class UserJsonAdapter implements JsonDeserializer<UserResponse>{

    @Override
    public UserResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

        JsonObject jsonObject = json.getAsJsonObject();

        Map.Entry<String, JsonElement> entry = jsonObject.entrySet().iterator().next();

        JsonObject userJsonObject = entry.getValue().getAsJsonObject();

        JsonElement userElement = userJsonObject.get("user");

        if(userElement.isJsonNull()) {

//            User user = gson.fromJson(userElement, User.class);
            return null;
        } else {


            throw new Error("dsfdsfsdf");
        }
    }
}
