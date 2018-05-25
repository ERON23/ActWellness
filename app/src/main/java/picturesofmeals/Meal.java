package picturesofmeals;

import android.view.View;

import com.google.android.youtube.player.YouTubePlayer;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.*;


public class Meal implements Serializable {

    private String id;
    private String name;
    private String description;
    private BigDecimal price;
    private int photo;
    //private String video;
    //change youtube api
    YouTubePlayer video;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    //video
    public YouTubePlayer getVideo() {
        return video;
    }

    public void getVideo(View mVideo) { this.video = (YouTubePlayer) mVideo;}
    //video

    //description
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    //description

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }


    public Meal() {
    }

    public Meal(String id, String name, String description, BigDecimal price, int photo) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.photo = photo;
    }
}
