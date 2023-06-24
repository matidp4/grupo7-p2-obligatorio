package entities;

import java.time.LocalDateTime;

public class User {
    private long id;
    private String name;
    private String location;
    private String description;
    private LocalDateTime user_created;
    private int user_followers;
    private int user_friends;
    private int user_favourites;
    private Boolean user_verified;
    private int cant_tweets;

    public User(LocalDateTime userId, String userName, String userLocation, String userDescription, LocalDateTime userCreated, Float userFollowers, Float userFriends, Float userFavourites, Boolean userVerified) {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getUser_created() {
        return user_created;
    }

    public void setUser_created(LocalDateTime user_created) {
        this.user_created = user_created;
    }

    public int getUser_followers() {
        return user_followers;
    }

    public void setUser_followers(int user_followers) {
        this.user_followers = user_followers;
    }

    public int getUser_friends() {
        return user_friends;
    }

    public void setUser_friends(int user_friends) {
        this.user_friends = user_friends;
    }

    public int getUser_favourites() {
        return user_favourites;
    }

    public void setUser_favourites(int user_favourites) {
        this.user_favourites = user_favourites;
    }

    public Boolean getUser_verified() {
        return user_verified;
    }

    public void setUser_verified(Boolean user_verified) {
        this.user_verified = user_verified;
    }

    public int getCant_tweets() {
        return cant_tweets;
    }

    public void setCant_tweets(int cant_tweets) {
        this.cant_tweets = cant_tweets;
    }
}
