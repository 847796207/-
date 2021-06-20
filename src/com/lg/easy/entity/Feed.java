package com.lg.easy.entity;

public class Feed {
    private String feed_number;
    private String name;
    private String feed_time;
    private String food;
    private String new_weight;

    public String getFeed_number() {
        return feed_number;
    }

    public void setFeed_number(String feed_number) {
        this.feed_number = feed_number;
    }

    public String getNew_weight() {
        return new_weight;
    }

    public void setNew_weight(String new_weight) {
        this.new_weight = new_weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFeed_time() {
        return feed_time;
    }

    public void setFeed_time(String feed_time) {
        this.feed_time = feed_time;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }


    @Override
    public String toString() {
        return "Feed{" +
                "number=" + feed_number+
                ", name='" + name+ '\'' +
                ", new_eight='" + new_weight+ '\'' +
                ", feed_time='" + feed_time + '\'' +
                ", food='" + food + '\'' +
                '}';
    }
}
