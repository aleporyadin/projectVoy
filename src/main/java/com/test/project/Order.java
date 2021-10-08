package com.test.project;

import javax.persistence.*;

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
    private int price;
    @Column(name = "quantity")
    private int quantity;


    //Constructors
    public Order() {  }

    public Order(String item, int price, int quantity) {
        this.setItem(item);
        this.setPrice(price);
        this.setQuantity(quantity);
    }

    public Order(int id, String item, int price, int quantity) {
        this.setId(id);
        this.setItem(item);
        this.setPrice(price);
        this.setQuantity(quantity);
    }


    //Object to string data
    @Override
    public String toString() {
        return "Order{" +
                "id=" + getId() +
                ", item='" + getItem() + '\'' +
                ", price='" + getPrice() + '\'' +
                ", price='" + getQuantity() + '\'' +
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
    public int getPrice() {
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

}