package iamrajendra.github.io.apolis.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public  class RockyResponse {

    @Expose
    @SerializedName("results")
    public List<Results> results;
    @Expose
    @SerializedName("info")
    public Info info;

    public static class Results {
        @Expose
        @SerializedName("created")
        public String created;
        @Expose
        @SerializedName("url")
        public String url;
        @Expose
        @SerializedName("episode")
        public List<String> episode;
        @Expose
        @SerializedName("image")
        public String image;
        @Expose
        @SerializedName("location")
        public Location location;
        @Expose
        @SerializedName("origin")
        public Origin origin;
        @Expose
        @SerializedName("gender")
        public String gender;
        @Expose
        @SerializedName("type")
        public String type;
        @Expose
        @SerializedName("species")
        public String species;
        @Expose
        @SerializedName("status")
        public String status;
        @Expose
        @SerializedName("name")
        public String name;
        @Expose
        @SerializedName("id")
        public int id;
    }

    public static class Location {
        @Expose
        @SerializedName("url")
        public String url;
        @Expose
        @SerializedName("name")
        public String name;
    }

    public static class Origin {
        @Expose
        @SerializedName("url")
        public String url;
        @Expose
        @SerializedName("name")
        public String name;
    }

    public static class Info {
        @Expose
        @SerializedName("next")
        public String next;
        @Expose
        @SerializedName("pages")
        public int pages;
        @Expose
        @SerializedName("count")
        public int count;
    }
}
