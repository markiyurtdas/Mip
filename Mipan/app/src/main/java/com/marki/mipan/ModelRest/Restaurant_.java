
package com.marki.mipan.ModelRest;

import android.media.Rating;
import android.widget.RatingBar;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Restaurant_ {


    @SerializedName("R")
    @Expose
    public R r;
    @SerializedName("apikey")
    @Expose
    public String apikey;
    @SerializedName("id")
    @Expose
    public String id;
    @SerializedName("name")
    @Expose
    public String name;

    public String getName() {
        return name;
    }
    public String getAdress() {
        return location.address;
    }
    public String getRating() {
        return "Rating: "+userRating.aggregateRating+" - "+userRating.ratingText;
    }
    public String getRatingStar(){

        return userRating.aggregateRating;
    }

    public String getUrl() {
        return url;
    }

    @SerializedName("url")
    @Expose
    public String url;
    @SerializedName("location")
    @Expose
    public Location location;
    @SerializedName("switch_to_order_menu")
    @Expose
    public Integer switchToOrderMenu;

    public String getCuisines() {
        return cuisines;
    }

    @SerializedName("cuisines")
    @Expose
    public String cuisines;
    @SerializedName("average_cost_for_two")
    @Expose
    public Integer averageCostForTwo;
    @SerializedName("price_range")
    @Expose
    public Integer priceRange;
    @SerializedName("currency")
    @Expose
    public String currency;
    @SerializedName("offers")
    @Expose
    public List<Object> offers = null;
    @SerializedName("opentable_support")
    @Expose
    public Integer opentableSupport;
    @SerializedName("is_zomato_book_res")
    @Expose
    public Integer isZomatoBookRes;
    @SerializedName("mezzo_provider")
    @Expose
    public String mezzoProvider;
    @SerializedName("is_book_form_web_view")
    @Expose
    public Integer isBookFormWebView;
    @SerializedName("book_form_web_view_url")
    @Expose
    public String bookFormWebViewUrl;
    @SerializedName("book_again_url")
    @Expose
    public String bookAgainUrl;
    @SerializedName("thumb")
    @Expose
    public String thumb;
    @SerializedName("user_rating")
    @Expose
    public UserRating userRating;

    public String getPhotosUrl() {
        return thumb;
    }

    @SerializedName("photos_url")
    @Expose
    public String photosUrl;
    @SerializedName("menu_url")
    @Expose
    public String menuUrl;
    @SerializedName("featured_image")
    @Expose
    public String featuredImage;
    @SerializedName("has_online_delivery")
    @Expose
    public Integer hasOnlineDelivery;
    @SerializedName("is_delivering_now")
    @Expose
    public Integer isDeliveringNow;
    @SerializedName("include_bogo_offers")
    @Expose
    public Boolean includeBogoOffers;
    @SerializedName("deeplink")
    @Expose
    public String deeplink;
    @SerializedName("is_table_reservation_supported")
    @Expose
    public Integer isTableReservationSupported;
    @SerializedName("has_table_booking")
    @Expose
    public Integer hasTableBooking;
    @SerializedName("events_url")
    @Expose
    public String eventsUrl;
    @SerializedName("establishment_types")
    @Expose
    public List<Object> establishmentTypes = null;

}
