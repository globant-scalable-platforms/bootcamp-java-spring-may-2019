package com.dinamik.app.dinamikprintservice.domain;

public class Order {

    private String order;
    private String link;

    public Order() {
    }

    public Order(String order, String link) {
        this.order = order;
        this.link = link;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
