package entities;

import java.time.LocalDateTime;

public class Tweet {
    public Tweet(int idTweet, String tweetText, String hashtags, String tweetSource, Boolean isRetweet, LocalDateTime date) {
        this.id = idTweet;
        this.content = tweetText;
        this.source = tweetSource;
        this.isRetweet = isRetweet;
        this.date = date;
        this.hashtags = hashtags.split(" ");
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Boolean getRetweet() {
        return isRetweet;
    }

    public void setRetweet(Boolean retweet) {
        isRetweet = retweet;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    // atributos tweet ok
    private long id;
    private String driver;
    private String content;
    private Boolean isRetweet;
    private LocalDateTime date;
    private String source;

    public String[] getHashtags() {
        return hashtags;
    }

    public void setHashtags(String[] hashtags) {
        this.hashtags = hashtags;
    }

    private String[] hashtags;
}
