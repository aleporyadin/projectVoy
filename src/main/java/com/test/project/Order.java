package com.test.project;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

@Entity
@Table(name = "orders")
public class Order {

    //Fields
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "item")
    private String item;
    @Column(name = "price")
    private double price;
    @Column(name = "quantity")
    private int quantity;
    @Column(name = "live_timer")
    private long live_Timer;
    //Constructors
    public Order() {  }

    public Order(String item, int price, int quantity) {
        this.setItem(item);
        this.setPrice(price);
        this.setQuantity(quantity);
        this.setLive_Timer(new Date().getTime()/1000);
    }

    public Order(int id, String item, int price, int quantity) {
        this.setId(id);
        this.setItem(item);
        this.setPrice(price);
        this.setQuantity(quantity);
        this.setLive_Timer(new Date().getTime()/1000);
    }


    //Object to string data
    @Override
    public String toString() {
        return "Order{" +
                "id=" + getId() +
                ", item='" + getItem() + '\'' +
                ", price='" + getPrice() + '\'' +
                ", quantity='" + getQuantity() + '\'' +
                ", time to end: " + getLive_Timer() + '\''+
                '}';
    }


    //Getters & Setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getItem() {
        return item;
    }
    public void setItem(String item) {
        this.item = item;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public long getLive_Timer() {
        return live_Timer;
    }
    public void setLive_Timer(long live_timer) {
        this.live_Timer = live_timer;
    }
//    public long getSecLeft(){
//            //returns how many seconds are left until the end of the object's life (object's life is 10 minutes)
//            return (( -this.live_Timer.getTime() / 1000) % 60);
//    }
//    public void setSecLeft(long live_timer){
//        this.live_Timer = live_timer;
//    }

}