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
}
