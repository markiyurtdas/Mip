
package com.marki.mipan.ModelRest;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Location {

    @SerializedName("address")
    @Expose
    public String address;
    @SerializedName("locality")
    @Expose
    public String locality;
    @SerializedName("city")
    @Expose
    public String city;
    @SerializedName("city_id")
    @Expose
    public Integer cityId;
    @SerializedName("latitude")
    @Expose
    public String latitude;
    @SerializedName("longitude")
    @Expose
    public String longitude;
    @SerializedName("zipcode")
    @Expose
    public String zipcode;
    @SerializedName("country_id")
    @Expose
    public Integer countryId;
    @SerializedName("locality_verbose")
    @Expose
    public String localityVerbose;

}
