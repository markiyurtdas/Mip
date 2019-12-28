
package com.marki.mipan.ModelRest;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserRating {

    @SerializedName("aggregate_rating")
    @Expose
    public String aggregateRating;
    @SerializedName("rating_text")
    @Expose
    public String ratingText;
    @SerializedName("rating_color")
    @Expose
    public String ratingColor;
    @SerializedName("votes")
    @Expose
    public String votes;

}
