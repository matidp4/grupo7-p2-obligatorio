package entities;

import uy.edu.um.prog2.adt.linkedlist.MyLinkedList;

import java.time.LocalDateTime;

public class User {
    // atributos user ok -UML
    private LocalDateTime id;
    private String name;
    private String location;
    private String description;
    private LocalDateTime user_created;
    private float user_followers;
    private float user_friends;
    private float user_favourites;
    private Boolean user_verified;
    private int cant_tweets;

    public User(LocalDateTime userId, String userName, String userLocation, String userDescription, LocalDateTime userCreated, Float userFollowers, Float userFriends, Float userFavourites, Boolean userVerified, int Cant_tweets) {
        this.id = userId;
        this.name = userName;
        this.location = userLocation;
        this.description = userDescription;
        this.user_created = userCreated;
        this.user_followers = userFollowers;
        this.user_friends = userFriends;
        this.user_favourites = userFavourites;
        this.user_verified = userVerified;
        this.cant_tweets = Cant_tweets;
    }

    public LocalDateTime getId() {
        return id;
    }

    public void setId(LocalDateTime id) {
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



    public void setUser_created(LocalDateTime user_created) {
        this.user_created = user_created;
    }

    public float getUser_followers() {
        return user_followers;
    }

    public void setUser_followers(int user_followers) {
        this.user_followers = user_followers;
    }

    public float getUser_friends() {
        return user_friends;
    }

    public void setUser_friends(int user_friends) {
        this.user_friends = user_friends;
    }

    public float getUser_favourites() {
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

    public MyLinkedList<Object> getTweets() {
        return null;
    }
}
