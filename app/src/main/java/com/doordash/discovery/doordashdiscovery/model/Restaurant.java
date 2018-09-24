package com.doordash.discovery.doordashdiscovery.model;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * This class represents the restaurant object, with all its fields
 */
public class Restaurant {
   private String id;
   private String name;
   private String description;
   private String cover_img_url;
   private String status;
   private String delivery_fee;

   public Restaurant(@NonNull String id, @NonNull String name, @NonNull String description, @NonNull String imageUrl, @Nullable String status, @Nullable String deliveryFee) {
       this.id = id;
       this.name = name;
       this.description = description;
       this.cover_img_url = imageUrl;
       this.status = status;
       this.delivery_fee = deliveryFee;
   }

    /**
     * This method returns the restaurant's ID
     *
     * @return String
     */
   @NonNull
    public String getId() {
        return id;
    }

    /**
     * This method returns the restaurant's name
     *
     * @return String
     */
    @NonNull
    public String getName() {
        return name;
    }

    /**
     * This method returns a description about the restaurant
     *
     * @return String
     */
    @NonNull
    public String getDescription() {
        return description;
    }

    /**
     * This method returns the url on server for the restaurant's image
     *
     * @return String
     */
    @NonNull
    public String getImageUrl() {
        return cover_img_url;
    }

    /**
     * This method returns the restaurant's status if present
     *
     * @return String if status exists, null otherwise
     */
    @Nullable
    public String getStatus() {
        return status;
    }

    /**
     * This method returns the restaurant's delivery fee if applicable
     *
     * @return String if delivery fee exists, null otherwise
     */
    @Nullable
    public String getDeliveryFee() {
        return delivery_fee;
    }
}
